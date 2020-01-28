package it.nextworks.nfvmano.libs.ifa.templates.plugAndPlay;

import it.nextworks.nfvmano.libs.ifa.common.exceptions.MalformattedElementException;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PpFunction {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String seqId;
    
    @EmbeddedId
    private PpFunctionCompositeKey ppFunctionCompositeKey;

    public PpFunction(){}

    public PpFunction(String ppFeatureName, PpFeatureLevel ppFeatureLevel, PpFeatureType ppFeatureType){
        ppFunctionCompositeKey=new PpFunctionCompositeKey(ppFeatureName, ppFeatureLevel, ppFeatureType);
    }

    public void isValid()  throws MalformattedElementException {
        if(this.ppFunctionCompositeKey.getPpFeatureName() == null) throw new MalformattedElementException("P&P function feature name cannot be null");
        if(this.ppFunctionCompositeKey.getPpFeatureLevel() == null) throw new MalformattedElementException("P&P function feature level cannot be null");
        if(this.ppFunctionCompositeKey.getPpFeatureType() == null) throw new MalformattedElementException("P&P function feature type cannot be null");
    }

    @Embeddable
    private class PpFunctionCompositeKey implements Serializable {
        private String ppFeatureName;
        private PpFeatureLevel ppFeatureLevel;
        private PpFeatureType ppFeatureType;


        public PpFunctionCompositeKey(){///For JPA Only
        }
        public PpFunctionCompositeKey(String ppFeatureName, PpFeatureLevel ppFeatureLevel, PpFeatureType ppFeatureType){
            this.ppFeatureName=ppFeatureName;
            this.ppFeatureLevel=ppFeatureLevel;
            this.ppFeatureType=ppFeatureType;
        }

        public String getPpFeatureName() {
            return ppFeatureName;
        }


        public PpFeatureLevel getPpFeatureLevel() {
            return ppFeatureLevel;
        }


        public PpFeatureType getPpFeatureType() {
            return ppFeatureType;
        }

    }
}
