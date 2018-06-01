/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.libs.records.nsinfo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information about a PNF that is part of an NS instance.
 * Ref. IFA 013 v2.3.1 section 8.3.3.9
 * 
 * @author nextworks
 *
 */
@Entity
public class PnfInfo implements DescriptorInformationElement {


	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private NsInfo nsInfo;
	
	private String pnfName;
	private String pnfInfoId;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<PnfExtCpInfo> cpInfo = new ArrayList<>();
	
	public PnfInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsInfo NS info this element belongs to
	 * @param pnfName Name of the PNF.
	 * @param pnfInfoId Identifier of (reference to) the PNFD information related to this PNF.
	 * @param cpInfo Information on the external CP of the PNF.
	 */
	public PnfInfo(NsInfo nsInfo, String pnfName, String pnfInfoId, List<PnfExtCpInfo> cpInfo) {
		this.nsInfo = nsInfo;
		this.pnfInfoId = pnfInfoId;
		this.pnfName = pnfName;
		if (cpInfo != null) this.cpInfo = cpInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.pnfInfoId == null) throw new MalformattedElementException("PNF info without ID");
		if (this.pnfName == null) throw new MalformattedElementException("PNF info without name");
		if ((this.cpInfo == null) || (this.cpInfo.isEmpty())) {
			throw new MalformattedElementException("PNF info without CP information");
		} else {
			for (PnfExtCpInfo i : this.cpInfo) i.isValid();
		}
	}
}
