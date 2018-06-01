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

import javax.persistence.Embeddable;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information about an SAP of an NS instance.
 * Ref. IFA 013 v2.3.1 section 8.3.3.12
 * 
 * @author nextworks
 *
 */
@Embeddable
public class SapInfo implements DescriptorInformationElement {

	private String sapInstanceId;
	private String sapdId;
	private String sapName;
	private String description;
	private String address;
	
	
	public SapInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param sapInstanceId Identifier of this SapInfo information element, identifying the SAP instance.
	 * @param sapdId Reference to the SAPD for this SAP.
	 * @param sapName Human readable name for the SAP.
	 * @param description Human readable description for the SAP.
	 * @param address Address for this SAP. In some cases, the NFVO provides the address.
	 */
	public SapInfo(String sapInstanceId,
			String sapdId,
			String sapName,
			String description,
			String address) {
		this.sapdId = sapdId;
		this.sapInstanceId = sapInstanceId;
		this.sapName = sapName;
		this.description = description;
		this.address = address;
	}
	
	

	/**
	 * @return the sapInstanceId
	 */
	public String getSapInstanceId() {
		return sapInstanceId;
	}

	/**
	 * @return the sapdId
	 */
	public String getSapdId() {
		return sapdId;
	}

	/**
	 * @return the sapName
	 */
	public String getSapName() {
		return sapName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (sapInstanceId == null) throw new MalformattedElementException("SAP Info without SAP instance ID");
		if (sapdId == null) throw new MalformattedElementException("SAP Info without SAPD ID");
		if (sapName == null) throw new MalformattedElementException("SAP Info without SAP name");
		if (description == null) throw new MalformattedElementException("SAP Info without SAP description");
		if (address == null) throw new MalformattedElementException("SAP Info without SAP address");
	}

}
