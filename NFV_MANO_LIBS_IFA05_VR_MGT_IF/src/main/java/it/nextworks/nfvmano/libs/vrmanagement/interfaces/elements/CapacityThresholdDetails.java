package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.ThresholdCrossingDirection;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.enums.ResourceCapacityType;

/**
 * Details about  a threshold. 
 * Note: the information element is not yet defined in IFA 005.
 * 
 * Ref. IFA 005 v2.3.1 section 8.7.5.2
 * 
 * Threshold: 
 * Details of the threshold: value to be crossed and direction in
 * which it is crossed and capacity information to which it applies
 * (available, total, reserved, allocated).
 * 
 * 
 * @author nextworks
 *
 */
public class CapacityThresholdDetails implements InterfaceInformationElement {
	
	private ResourceCapacityType resourceCapacityType;
	private int targetValue;
	private ThresholdCrossingDirection direction;

	public CapacityThresholdDetails() {	}
	
	/**
	 * Construction
	 * 
	 * @param resourceCapacityType Capacity information to which it applies (available, total, reserved, allocated)
	 * @param targetValue Value to be crossed
	 * @param direction Direction in which the value is crossed
	 */
	public CapacityThresholdDetails(ResourceCapacityType resourceCapacityType,
			int targetValue,
			ThresholdCrossingDirection direction) {	
		this.resourceCapacityType = resourceCapacityType;
		this.targetValue = targetValue;
		this.direction = direction;
	}
	
	

	/**
	 * @return the resourceCapacityType
	 */
	public ResourceCapacityType getResourceCapacityType() {
		return resourceCapacityType;
	}

	/**
	 * @return the targetValue
	 */
	public int getTargetValue() {
		return targetValue;
	}

	/**
	 * @return the direction
	 */
	public ThresholdCrossingDirection getDirection() {
		return direction;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
