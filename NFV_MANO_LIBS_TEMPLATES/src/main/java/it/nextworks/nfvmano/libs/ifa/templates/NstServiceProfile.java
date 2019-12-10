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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Service Profile for the NST - Defined @3gpp-TS28.541 - Clause 6.3.3
 */

@Entity
public class NstServiceProfile {
	
	@Id
    @GeneratedValue
    @JsonIgnore
	private Long id;
	
    private String serviceProfileId;
    //sNSSAIList Omitted
    @ElementCollection(targetClass=String.class)
    private List<String> pLMNIdList;
    
    /*
    @ElementCollection//(targetClass=SlicePerfReq.class)
	@OneToMany(cascade=CascadeType.ALL)
    private List<SlicePerfReq> perfReq;
    */
    @ElementCollection
	@OneToMany(cascade=CascadeType.ALL)
    private List<EMBBPerfReq> eMBBPerfReq;
    
    @ElementCollection
	@OneToMany(cascade=CascadeType.ALL)
    private List<URLLCPerfReq> uRLLCPerfReq;
    
    private int maxNumberofUEs;
    @ElementCollection(targetClass=String.class)
    private List<String> coverageAreaTAList;
    private int latency;
    
    @Enumerated(EnumType.STRING)
    private UEMobilityLevel uEMobilityLevel;
    private Boolean resourceSharingLevel; // SHARED = true, NOT-SHARED =  false
    @Enumerated(EnumType.STRING)
    private SliceType sST;
    private float availability;

    public NstServiceProfile() {
    }

    /**
     *
     * @param serviceProfileId
     * @param pLMNIdList
     * @param perfReq
     * @param maxNumberofUEs
     * @param coverageAreaTAList
     * @param latency
     * @param uEMobilityLevel See 6.2.1 of TS 22.261
     * @param resourceSharingLevel
     * @param sST SliceType (e.g. urllc)
     * @param availability in %
     */
    public NstServiceProfile(String serviceProfileId, List<String> pLMNIdList, /*List<SlicePerfReq> perfReq,*/
                             int maxNumberofUEs, List<String> coverageAreaTAList, int latency,
                             UEMobilityLevel uEMobilityLevel, Boolean resourceSharingLevel, SliceType sST,
                             float availability) {
        this.serviceProfileId = serviceProfileId;
        this.pLMNIdList = pLMNIdList;
        //this.perfReq = perfReq;
        this.maxNumberofUEs = maxNumberofUEs;
        this.coverageAreaTAList = coverageAreaTAList;
        this.latency = latency;
        this.uEMobilityLevel = uEMobilityLevel;
        this.resourceSharingLevel = resourceSharingLevel;
        this.sST = sST;
        this.availability = availability;
    }

    public String getServiceProfileId() {
        return serviceProfileId;
    }

    public void setServiceProfileId(String serviceProfileId) {
        this.serviceProfileId = serviceProfileId;
    }

    public List<String> getpLMNIdList() {
        return pLMNIdList;
    }

    public void setpLMNIdList(List<String> pLMNIdList) {
        this.pLMNIdList = pLMNIdList;
    }
    /*
    public List<SlicePerfReq> getPerfReq() {
        return perfReq;
    }

    public void setPerfReq(List<SlicePerfReq> perfReq) {
        this.perfReq = perfReq;
    }
    */
    public int getMaxNumberofUEs() {
        return maxNumberofUEs;
    }

    public void setMaxNumberofUEs(int maxNumberofUEs) {
        this.maxNumberofUEs = maxNumberofUEs;
    }

    public List<String> getCoverageAreaTAList() {
        return coverageAreaTAList;
    }

    public void setCoverageAreaTAList(List<String> coverageAreaTAList) {
        this.coverageAreaTAList = coverageAreaTAList;
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public UEMobilityLevel getuEMobilityLevel() {
        return uEMobilityLevel;
    }

    public void setuEMobilityLevel(UEMobilityLevel uEMobilityLevel) {
        this.uEMobilityLevel = uEMobilityLevel;
    }

    public Boolean getResourceSharingLevel() {
        return resourceSharingLevel;
    }

    public void setResourceSharingLevel(Boolean resourceSharingLevel) {
        this.resourceSharingLevel = resourceSharingLevel;
    }

    public SliceType getsST() {
        return sST;
    }

    public void setsST(SliceType sST) {
        this.sST = sST;
    }

    public float getAvailability() {
        return availability;
    }

    public void setAvailability(float availability) {
        this.availability = availability;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<EMBBPerfReq> geteMBBPerfReq() {
		return eMBBPerfReq;
	}

	public void seteMBBPerfReq(List<EMBBPerfReq> eMBBPerfReq) {
		this.eMBBPerfReq = eMBBPerfReq;
	}

	public List<URLLCPerfReq> getuRLLCPerfReq() {
		return uRLLCPerfReq;
	}

	public void setuRLLCPerfReq(List<URLLCPerfReq> uRLLCPerfReq) {
		this.uRLLCPerfReq = uRLLCPerfReq;
	}
}
