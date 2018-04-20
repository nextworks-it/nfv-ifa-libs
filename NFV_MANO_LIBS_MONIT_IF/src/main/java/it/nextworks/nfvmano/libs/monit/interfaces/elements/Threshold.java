package it.nextworks.nfvmano.libs.monit.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.ThresholdType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides the details of a threshold.
 * 
 * REF IFA 013 v2.3.1 - 7.5.9
 * REF IFA 005 v2.1.1 - 8.5.4
 * REF IFA 007 v2.3.1 - 8.7.8
 * 
 * @author nextworks
 *
 */
public class Threshold implements InterfaceInformationElement {

	private String thresholdId;
	private List<ObjectSelection> objectSelector = new ArrayList<>();
	private String performanceMetric;
	private ThresholdType thresholdType;
	private String thresholdDetails;
	
	public Threshold() { }
	
	/**
	 * Constructor
	 * 
	 * @param thresholdId Id of threshold.
	 * @param objectSelector Defines the object instances associated with the threshold.
	 * @param performanceMetric Defines the performance metric associated with the threshold
	 * @param thresholdType Type of threshold.
	 * @param thresholdDetails Details of the threshold: value to be crossed, details on the notification to be generated.
	 */
	public Threshold(String thresholdId,
			List<ObjectSelection> objectSelector,
			String performanceMetric,
			ThresholdType thresholdType,
			String thresholdDetails) { 
		this.thresholdId = thresholdId;
		this.performanceMetric = performanceMetric;
		if (objectSelector != null) this.objectSelector = objectSelector;
		this.thresholdType = thresholdType;
		this.thresholdDetails = thresholdDetails;
	}

	
	
	/**
	 * @return the thresholdId
	 */
	public String getThresholdId() {
		return thresholdId;
	}

	/**
	 * @return the objectSelector
	 */
	public List<ObjectSelection> getObjectSelector() {
		return objectSelector;
	}

	/**
	 * @return the performanceMetric
	 */
	public String getPerformanceMetric() {
		return performanceMetric;
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
	public String getThresholdDetails() {
		return thresholdDetails;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (thresholdId == null) throw new MalformattedElementException("Threshold without ID");
		if (performanceMetric == null) throw new MalformattedElementException("Threshold without performance metrics");
		if (thresholdDetails == null) throw new MalformattedElementException("Threshold without details");
		if ((objectSelector == null) || (objectSelector.isEmpty())) throw new MalformattedElementException("Threshold without object selector");
		else {
			for (ObjectSelection os : objectSelector) os.isValid();
		}
	}

}
