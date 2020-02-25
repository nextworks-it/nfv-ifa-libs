package it.nextworks.nfvmano.libs.ifa.templates.sap;

import java.util.List;

public class Sap {
    private String nameAccessPoint;
    private AccessPointType accessPointType;
    //a list of allowed peering NST providers (i.e. NSPs) for end-to-end
    //composition constraints
    private List<String> peeringNSTProviders;//D.7.1, Table 16.

    public Sap(){

    }
    public Sap(String nameAccessPoint, AccessPointType accessPointType,  List<String> peeringNSTProviders){
            this.nameAccessPoint=nameAccessPoint;
            this.accessPointType=accessPointType;
            this.peeringNSTProviders=peeringNSTProviders;
    }

    public String getNameAccessPoint() {
        return nameAccessPoint;
    }

    public void setNameAccessPoint(String nameAccessPoint) {
        this.nameAccessPoint = nameAccessPoint;
    }

    public AccessPointType getAccessPointType() {
        return accessPointType;
    }

    public void setAccessPointType(AccessPointType accessPointType) {
        this.accessPointType = accessPointType;
    }

    public List<String> getPeeringNSTProviders() {
        return peeringNSTProviders;
    }

    public void setPeeringNSTProviders(List<String> peeringNSTProviders) {
        this.peeringNSTProviders = peeringNSTProviders;
    }
}
