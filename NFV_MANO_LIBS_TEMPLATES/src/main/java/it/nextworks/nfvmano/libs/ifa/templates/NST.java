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

import it.nextworks.nfvmano.libs.ifa.templates.nsst.NSST;
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
    private String nstDescription;
    private String nstProvider;


    @ElementCollection(targetClass=String.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> nsstIds = new ArrayList<String>();

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NSST> nsstList = new ArrayList<>();

    private SliceType sliceType;

    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PpFunction> ppFunctionList = new ArrayList<PpFunction>();


    public NST() { }

    /**
     * Constructor
     * 
     * @param nstId ID of the NST
     * @param nstName name of the NST
     * @param nstVersion version of the NST
     * @param nstProvider provider of the NST
     * @param nsstIds ID of the network slice subnet templates included in the NST
     * @param sliceType sliceType of the NST
     */
    public NST(String nstId, String nstName, String nstVersion, String nstProvider, List<String> nsstIds, SliceType sliceType) {
		this.nstId = nstId;
		this.nstName = nstName;
		this.nstVersion = nstVersion;
		this.nstProvider = nstProvider;
		if (nsstIds != null) this.nsstIds = nsstIds;
		this.sliceType = sliceType;
	}

    public NST(String nstId, String nstName, String nstVersion, String nstProvider, List<NSST> nsstList) {
        this.nstId = nstId;
        this.nstName = nstName;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        this.nsstList=nsstList;
    }

    public NST(String nstId, String nstName, String nstVersion, String nstProvider, List<String> nsstIds, SliceType sliceType, List<PpFunction> ppFunctionList) {
        this.nstId = nstId;
        this.nstName = nstName;
        this.nstVersion = nstVersion;
        this.nstProvider = nstProvider;
        if (nsstIds != null) this.nsstIds = nsstIds;
        this.sliceType = sliceType;
        setPpFunctionList(ppFunctionList);
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


    public void isValid()  throws MalformattedElementException {
        if(this.nstId == null) throw new MalformattedElementException("NST id not set");
        if(this.nstVersion == null) throw new MalformattedElementException("NST version not set");
        if(this.nstProvider == null) throw new MalformattedElementException("NST provider not set");
        for(PpFunction ppFunction: ppFunctionList)
            ppFunction.isValid();
        checkPpFunctionsDuplicate();
        for(NSST nsst: nsstList){
            nsst.isValid();
        }
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

    public List<NSST> getNsstList(){
        return nsstList;
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

    public String getNstDescription() {
        return nstDescription;
    }

    public void setNstDescription(String nstDescription) {
        this.nstDescription = nstDescription;
    }

    public SliceType getSliceType() {
        return sliceType;
    }

    public void setSliceType(SliceType sliceType) {
        this.sliceType = sliceType;
    }
}
