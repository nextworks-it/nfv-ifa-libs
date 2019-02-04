package it.nextworks.nfvmano.libs.policy.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.policy.enums.PolicyType;
import it.nextworks.nfvmano.libs.policy.enums.PolicyValue;

/**
 * The Policy information element defines policy type and value
 * No IFA definition
 *
 * @author nextworks
 *
 */

public class Policy implements InterfaceInformationElement {

    private PolicyType policyType;
    private PolicyValue policyValue;

    public Policy() { }

    /**
     * Constructor
     *
     * @param policyType Identifier for the type of policy
     * @param policyValue Possible values for the policy
     */
    public Policy(PolicyType policyType, PolicyValue policyValue) {

        this.policyType = policyType;
        this.policyValue = policyValue;
    }

    /**
     *
     * @return the policyType
     */
    public PolicyType getPolicyType() {
        return policyType;
    }

    /**
     *
     * @return the policyValue
     */
    public PolicyValue getPolicyValue() {
        return policyValue;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.policyValue == null) throw new MalformattedElementException("Policy without value");
        if (this.policyType == null) throw new MalformattedElementException("Policy without type");
    }
}
