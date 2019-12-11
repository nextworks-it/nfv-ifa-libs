/*
 * Copyright (c) 2019 Nextworks s.r.l
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.nextworks.nfvmano.libs.ifa.templates;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.libs.ifa.common.exceptions.MalformattedElementException;


/**
 * Network Service Template definition
 */
@Entity
public class NST {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
    private String nstId;
    private String nstName;
    private String nstVersion;
    private String nstProvider;
    @ElementCollection(targetClass=String.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> nsstIds;
    private String nsdId;

    @OneToOne(cascade = {CascadeType.ALL})
    private NstServiceProfile nstServiceProfile;

    public NST() { }

    /**
     *
     * @param nstId Id of the NST
     * @param nstVersion Version of the NST
     * @param nstProvider NST provider
     * @param nsstIds List of NSST IDs
     * @param nsdId NSD Id
     */
    public NST(String nstId, String nstVersion, String nstProvider, List<String> nsstIds, String nsdId) {
        this.nstId = nstId;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        this.nsstIds = nsstIds;
        this.nsdId = nsdId;
    }

    /**
     *
     * @param nstId Id of the NST
     * @param nstVersion Version of the NST
     * @param nstProvider NST provider
     * @param nsstIds List of NSST IDs
     * @param nstServiceProfile [optional] - For the RAN segment, as defined @3gpp-TS28.541 - Clause 6.3.3
     */
    public NST(String nstId, String nstVersion, String nstProvider, List<String> nsstIds,
               NstServiceProfile nstServiceProfile) {
        this.nstId = nstId;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        this.nsstIds = nsstIds;
        this.nstServiceProfile = nstServiceProfile;
    }

    /**
     *
     * @param nstId Id of the NST
     * @param nstVersion Version of the NST
     * @param nstProvider NST provider
     * @param nsstIds List of NSST IDs
     * @param nsdId NSD Id
     * @param nstServiceProfile [optional] - For the RAN segment, as defined @3gpp-TS28.541 - Clause 6.3.3
     */
    public NST(String nstId, String nstVersion, String nstProvider, List<String> nsstIds, String nsdId,
               NstServiceProfile nstServiceProfile) {
        this.nstId = nstId;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        this.nsstIds = nsstIds;
        this.nsdId = nsdId;
        this.nstServiceProfile = nstServiceProfile;
    }

    public String getNstId() {
        return nstId;
    }

    public void setNstId(String nstId) {
        this.nstId = nstId;
    }

    public Long getId(){
    			return id;
    }
    	
    public String getNstVersion() {
        return nstVersion;
    }

    public void setNstVersion(String nstVersion) {
        this.nstVersion = nstVersion;
    }

    public String getNstProvider() {
        return nstProvider;
    }

    public void setNstProvider(String nstProvider) {
        this.nstProvider = nstProvider;
    }

    public List<String> getNsstIds() {
        return nsstIds;
    }

    public void setNsstIds(List<String> nsstIds) {
        this.nsstIds = nsstIds;
    }

    public String getNsdId() {
        return nsdId;
    }

    public void setNsdId(String nsdId) {
        this.nsdId = nsdId;
    }

    public NstServiceProfile getNstServiceProfile() {
        return nstServiceProfile;
    }

    public void setNstServiceProfile(NstServiceProfile nstServiceProfile) {
        this.nstServiceProfile = nstServiceProfile;
    }

    public void isValid()  throws MalformattedElementException {
        if(this.nstId == null) throw new MalformattedElementException("NST id not set");
        if(this.nstVersion == null) throw new MalformattedElementException("NST version not set");
        if(this.nstProvider == null) throw new MalformattedElementException("NST provider not set");
    }

	public String getNstName() {
		return nstName;
	}

	public void setNstName(String nstName) {
		this.nstName = nstName;
	}
}
