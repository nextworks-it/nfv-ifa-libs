package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.ThresholdType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines thresholds for sending capacity change notifications.
 * 
 * REF IFA 005 v2.3.1 - 8.7.5
 * 
 * 
 * @author nextworks
 *
 */
public class CapacityThreshold implements DescriptorInformationElement {

	private ThresholdType thresholdType;
	private CapacityThresholdDetails thresholdDetails;
	
	public CapacityThreshold() { }
	
	/**
	 * Constructor
	 * 
	 * @param thresholdType Defines the type of threshold.
	 * @param thresholdDetails Details of the threshold.
	 */
	public CapacityThreshold(ThresholdType thresholdType,
			CapacityThresholdDetails thresholdDetails) { 
		this.thresholdDetails = thresholdDetails;
		this.thresholdType = thresholdType;
	}
	
	

	/**
	 * @return the thresholdType
	 */
	public ThresholdType getThresholdType() {
		return thresholdType;
	}

	

	/**
	 * @return the thresholdDetails
	 */
	public CapacityThresholdDetails getThresholdDetails() {
		return thresholdDetails;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (thresholdDetails == null) throw new MalformattedElementException("Capacity threshold without threshold details");
		else thresholdDetails.isValid();
	}

}
