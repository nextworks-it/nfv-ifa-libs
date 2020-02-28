package it.nextworks.nfvmano.libs.ifa.templates.nsst;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.nextworks.nfvmano.libs.ifa.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.ifa.templates.NstServiceProfile;
import it.nextworks.nfvmano.libs.ifa.templates.plugAndPlay.PpFunction;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class NSST {
    @Id
    @GeneratedValue
    @JsonIgnore
    private UUID uuid;

    private String nsstId;
    private String nsstName;
    private String nsstDescription;
    private NsstType nsstType;

    @ElementCollection(targetClass=NSST.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<NSST> nsstList=new ArrayList<>();

    //@ElementCollection(targetClass=LogicalEndpoint.class)
    //@LazyCollection(LazyCollectionOption.FALSE)
    //private List<LogicalEndpoint> logicalEndpointList;

    @OneToOne(cascade = {CascadeType.ALL})
    private NstServiceProfile nstServiceProfile;

    private String nsdId;
    private String nsdName;
    private String nsdType;
    private String nsdVersion;

    public NSST(){

    }
    public NSST(String nsstName, String nsstDescription, NstServiceProfile nstServiceProfile, String nsdId, String nsdName, String nsdType){
        this.nsstName=nsstName;
        this.nsstDescription=nsstDescription;
        this.nstServiceProfile=nstServiceProfile;
        this.nsdId=nsdId;
        this.nsdName=nsdName;
        this.nsdType=nsdType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNsstId() {
        return nsstId;
    }

    public void setNsstId(String nsstId) {
        this.nsstId = nsstId;
    }

    public String getNsstName() {
        return nsstName;
    }

    public void setNsstName(String nsstName) {
        this.nsstName = nsstName;
    }

    public String getNsstDescription() {
        return nsstDescription;
    }

    public void setNsstDescription(String nsstDescription) {
        this.nsstDescription = nsstDescription;
    }

    public NsstType getNsstType() {
        return nsstType;
    }

    public void setNsstType(NsstType nsstType) {
        this.nsstType = nsstType;
    }

    public List<NSST> getNsstList() {
        return nsstList;
    }

    public void setNsstList(List<NSST> nsstList) {
        this.nsstList = nsstList;
    }

    public NstServiceProfile getNstServiceProfile() {
        return nstServiceProfile;
    }

    public void setNstServiceProfile(NstServiceProfile nstServiceProfile) {
        this.nstServiceProfile = nstServiceProfile;
    }

    public String getNsdId() {
        return nsdId;
    }

    public void setNsdId(String nsdId) {
        this.nsdId = nsdId;
    }

    public String getNsdName() {
        return nsdName;
    }

    public void setNsdName(String nsdName) {
        this.nsdName = nsdName;
    }

    public String getNsdType() {
        return nsdType;
    }

    public void setNsdType(String nsdType) {
        this.nsdType = nsdType;
    }

   public void isValid()  throws MalformattedElementException {
        if(this.nsdId == null) throw new MalformattedElementException("NSD id not set");
        if(this.nsdName == null) throw new MalformattedElementException("NSD name is not set");
    }

    public String getNsdVersion() {
        return nsdVersion;
    }

    public void setNsdVersion(String nsdVersion) {
        this.nsdVersion = nsdVersion;
    }
}
