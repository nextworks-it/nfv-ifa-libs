package it.nextworks.nfvmano.libs.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.AffinityScope;
import it.nextworks.nfvmano.libs.common.enums.AffinityType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The LocalAffinityOrAntiAffinityRule information element specifies 
 * affinity or anti-affinity rules applicable to VNFs or 
 * VLs instantiated from the same VNFD or VLD.
 * 
 * Ref. IFA 014 v2.3.1 - 6.3.8
 * 
 * @author nextworks
 *
 */
@Embeddable
public class AffinityRule implements DescriptorInformationElement {

	private AffinityType affinityType;
	private AffinityScope affinityScope;
	
	public AffinityRule() {
		// JPA only
	}

	/**
	 * Constructor
	 * 
	 * @param affinityType Specifies the type of the rule: "affinity" or "anti-affinity".
	 * @param affinityScope Specifies whether the scope of the rule is an NFVI-node, an NFVI-PoP, etc.
	 */
	public AffinityRule(AffinityType affinityType,
			AffinityScope affinityScope) {
		this.affinityType = affinityType;
		this.affinityScope = affinityScope;
	}
	
	
	
	/**
	 * @return the affinityType
	 */
	@JsonProperty("affinityOrAntiAffinity")
	public AffinityType getAffinityType() {
		return affinityType;
	}

	/**
	 * @return the affinityScope
	 */
	@JsonProperty("scope")
	public AffinityScope getAffinityScope() {
		return affinityScope;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		// TODO Auto-generated method stub

	}
}
