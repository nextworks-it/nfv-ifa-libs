package it.nextworks.nfvmano.libs.descriptors.nsd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VnfToLevelMapping information element specifies 
 * the profile to be used for a VNF involved in a given NS level
 * and the required number of instances.
 * 
 * Ref. IFA 014 v2.3.1 - 6.7.4
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VnfToLevelMapping implements DescriptorInformationElement {

	private String vnfProfileId;
	private int numberOfInstances;
	
	public VnfToLevelMapping() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfProfileId Identifies the profile to be used for a VNF involved in an NS level.
	 * @param numberOfInstances Specifies the number of VNF instances required for an NS level.
	 */
	public VnfToLevelMapping(String vnfProfileId,
			int numberOfInstances) {
		this.vnfProfileId = vnfProfileId;
		this.numberOfInstances = numberOfInstances;
	}
	
	/**
	 * @return the vnfProfileId
	 */
	@JsonProperty("vnfProfileId")
	public String getVnfProfileId() {
		return vnfProfileId;
	}

	/**
	 * @return the numberOfInstances
	 */
	@JsonProperty("numberOfInstances")
	public int getNumberOfInstances() {
		return numberOfInstances;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.vnfProfileId == null) throw new MalformattedElementException("VNF to level mapping without VNF profile ID");
	}

}
