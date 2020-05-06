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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import it.nextworks.nfvmano.libs.ifa.templates.plugAndPlay.NsstType;
import it.nextworks.nfvmano.libs.ifa.templates.plugAndPlay.PpFunction;
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
    private UUID uuid;
	
    private String nstId;
    private String nstName;
    private String nstVersion;
    private String nstProvider;

    public List<GeographicalAreaInfo> getGeographicalAreaInfoList() {
        return geographicalAreaInfoList;
    }

    public void setGeographicalAreaInfoList(List<GeographicalAreaInfo> geographicalAreaInfoList) {
        this.geographicalAreaInfoList = geographicalAreaInfoList;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GeographicalAreaInfo> geographicalAreaInfoList;

    @ElementCollection(targetClass=String.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> nsstIds = new ArrayList<String>();

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NST> nsst;

    private NsstType nsstType;
    
    //Additional info to manage the association with NFV NSD
    private String nsdId;
    private String nsdVersion;

    @OneToOne(cascade = {CascadeType.ALL})
    private NstServiceProfile nstServiceProfile;

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PpFunction> ppFunctionList = new ArrayList<PpFunction>();

    /*
    * The NST class has 0 to n NST children, also called NSST.
    * The NST father has NsstType equal to None, while the children has one of the other defined enum values.
    * */
    public NST() { }

    /**
     * Constructor
     * 
     * @param nstId ID of the NST
     * @param nstName name of the NST
     * @param nstVersion version of the NST
     * @param nstProvider provider of the NST
     * @param nsdId ID of the NFV Network Service Descriptor associated to the NST
     * @param nsdVersion version of the NFV Network Service Descriptor associated to the NST
     * @param nstServiceProfile service profile associated to the NST
     */
    public NST(String nstId, String nstName, String nstVersion, String nstProvider,   List<String> nsstIds, String nsdId,
			String nsdVersion, NstServiceProfile nstServiceProfile) {
		this.nstId = nstId;
		this.nstName = nstName;
		this.nstVersion = nstVersion;
		this.nstProvider = nstProvider;
        if (nsstIds != null) this.nsstIds = nsstIds;
		this.nsdId = nsdId;
		this.nsdVersion = nsdVersion;
		this.nstServiceProfile = nstServiceProfile;
	}

    public NST(String nstId, String nstName, String nstVersion, String nstProvider, List<String> nsstIds, String nsdId,
               String nsdVersion, NstServiceProfile nstServiceProfile, List<PpFunction> ppFunctionList) {
        this.nstId = nstId;
        this.nstName = nstName;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        if (nsstIds != null) this.nsstIds = nsstIds;
        this.nsdId = nsdId;
        this.nsdVersion = nsdVersion;
        this.nstServiceProfile = nstServiceProfile;
        setPpFunctionList(ppFunctionList);
    }

    public NST(String nstId, String nstName, String nstVersion, String nstProvider, List<String> nsstIds, String nsdId,
               String nsdVersion, NstServiceProfile nstServiceProfile, List<PpFunction> ppFunctionList, List<GeographicalAreaInfo> geographicalAreaInfoList) {
        this.nstId = nstId;
        this.nstName = nstName;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        if (nsstIds != null) this.nsstIds = nsstIds;
        this.nsdId = nsdId;
        this.nsdVersion = nsdVersion;
        this.nstServiceProfile = nstServiceProfile;
        this.ppFunctionList = ppFunctionList;
        this.geographicalAreaInfoList = geographicalAreaInfoList;
    }


	public String getNsdVersion() {
		return nsdVersion;
	}

	public String getNstId() {
        return nstId;
    }

    public void setNstId(String nstId) {
        this.nstId = nstId;
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
        //if (this.nsdId == null) throw new MalformattedElementException("NFV NSD ID associated to NST not set");
        if (this.nsdVersion == null) throw new MalformattedElementException("NFV NSD version associated to NST not set");
        for(PpFunction ppFunction: ppFunctionList)
            ppFunction.isValid();
        checkPpFunctionsDuplicate();
    }

    private void checkPpFunctionsDuplicate() throws MalformattedElementException {
        for(int i=0; i<ppFunctionList.size(); i++) {
            for (int j = i+1; j < ppFunctionList.size(); j++) {
                if(ppFunctionList.get(i).equals(ppFunctionList.get(j)))
                    throw new MalformattedElementException("NST cannot have two P&P functions with same name, type and feature.");
            }
        }
    }

	public String getNstName() {
		return nstName;
	}

	public void setNstName(String nstName) {
		this.nstName = nstName;
	}

    public List<PpFunction> getPpFunctionList() {
        return ppFunctionList;
    }

    public void setPpFunctionList(List<PpFunction> ppFunctionList) {
        for(int i=0; i<ppFunctionList.size(); i++) {
            ppFunctionList.get(i).setSeqId(i);
        }

        this.ppFunctionList = ppFunctionList;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public List<NST> getNsst() {
        return nsst;
    }

    public void setNsst(List<NST> nsst) {
        this.nsst = nsst;
    }


    public NsstType getNsstType() {
        return nsstType;
    }

    public void setNsstType(NsstType nsstType) {
        this.nsstType = nsstType;
    }
}
