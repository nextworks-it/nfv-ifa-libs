package it.nextworks.nfvmano.libs.policy.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.policy.enums.ActivationStatus;

/**
 * The PolicyInfo element defines policy related information
 *
 * REF IFA 013 v3.1.1 - 8.8.2.2
 *
 * @author nextworks
 *
 */

public class PolicyInfo implements InterfaceInformationElement {

    private String policyInfoId;
    private String designer;
    private String name;
    private String version;
    private Policy policy;
    private ActivationStatus activationStatus;

    public PolicyInfo() { }

    /**
     * Constructor
     *
     * @param policyInfoId Identifier of policy information
     * @param designer Human readable name of designer of the policy
     * @param name Human readable name of the policy
     * @param version Version of the policy
     * @param policy Specifies the policy
     * @param activationStatus Status of the policy on whether it is activated or deactivated
     */

    public PolicyInfo(String policyInfoId, String designer, String name, String version, Policy policy, ActivationStatus activationStatus){

        this.policyInfoId = policyInfoId;
        this.designer = designer;
        this.name = name;
        this.version = version;
        this.policy = policy;
        this.activationStatus = activationStatus;
    }

    /**
     *
     * @return policyInfoId
     */
    public String getPolicyInfoId() {
        return policyInfoId;
    }

    /**
     *
     * @return designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @return policy
     */
    public Policy getPolicy() {
        return policy;
    }

    /**
     *
     * @return activationStatus
     */
    public ActivationStatus getActivationStatus() {
        return activationStatus;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.policyInfoId == null) throw new MalformattedElementException("PolicyInfo without policyInfoId");
        if (this.designer == null) throw new MalformattedElementException("PolicyInfo without designer");
        if (this.name == null) throw new MalformattedElementException("PolicyInfo without name");
        if (this.version == null) throw new MalformattedElementException("PolicyInfo without version");
        if (this.policy == null) throw new MalformattedElementException("PolicyInfo without policy");
        if (this.activationStatus == null) throw new MalformattedElementException("PolicyInfo without activationStatus");
    }
}