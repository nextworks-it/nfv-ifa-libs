package it.nextworks.nfvmano.libs.ifa.templates.plugAndPlay;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.nextworks.nfvmano.libs.ifa.common.exceptions.MalformattedElementException;

import javax.persistence.*;

@Entity
public class PpFunction {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private int seqId;

    private String ppFeatureName;
    private PpFeatureLevel ppFeatureLevel;
    private PpFeatureType ppFeatureType;


    public PpFunction(){}


    public PpFunction(String ppFeatureName, PpFeatureLevel ppFeatureLevel, PpFeatureType ppFeatureType){
        this.ppFeatureName=ppFeatureName;
        this.ppFeatureLevel=ppFeatureLevel;
        this.ppFeatureType=ppFeatureType;
    }

    public void isValid()  throws MalformattedElementException {
        if(ppFeatureName == null) throw new MalformattedElementException("P&P function feature name cannot be null");
        if(ppFeatureLevel == null) throw new MalformattedElementException("P&P function feature level cannot be null");
        if(ppFeatureType == null) throw new MalformattedElementException("P&P function feature type cannot be null");
    }


    public boolean equals(PpFunction ppFunction){
        if(ppFunction.getPpFeatureName().equals(this.ppFeatureName))
            return true;

        if(ppFunction.getPpFeatureLevel().equals(this.ppFeatureLevel))
            return true;

        if(ppFunction.ppFeatureType.equals(this.ppFeatureType))
            return true;

        return false;
    }

    public String getPpFeatureName(){
        return ppFeatureName;
    }

    public PpFeatureLevel getPpFeatureLevel(){
        return ppFeatureLevel;
    }

    public PpFeatureType getPpFeatureType(){
        return ppFeatureType;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }
}
