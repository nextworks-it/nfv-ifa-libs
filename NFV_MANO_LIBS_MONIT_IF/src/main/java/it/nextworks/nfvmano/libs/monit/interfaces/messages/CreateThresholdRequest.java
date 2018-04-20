package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.ThresholdType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.ObjectSelection;


/**
 * Create threshold request
 * 
 *  REF IFA 013 v2.3.1 - 7.5.7
 *  REF IFA 007 v2.3.1 - 7.4.7
 * 
 * @author nextworks
 *
 */
public class CreateThresholdRequest implements InterfaceMessage {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private ObjectSelection nsSelector;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private ObjectSelection vnfSelector;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ObjectSelection> resourceSelector = new ArrayList<>();
	
	private String performanceMetric;
	private ThresholdType thresholdType;
	private String thresholdDetails;
	
	public CreateThresholdRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param nsSelector Defines the NSs for which the threshold will be defined.
	 * @param vnfSelector Defines the VNFs for which the threshold will be defined.
	 * @param resourceSelector Defines the resources for which the threshold will be defined.
	 * @param performanceMetric Defines the performance metric on which the threshold will be defined.
	 * @param thresholdType Defines the type of threshold.
	 * @param thresholdDetails Details of the threshold: value to be crossed, details on the notification to be generated.
	 */
	public CreateThresholdRequest(ObjectSelection nsSelector,
			ObjectSelection vnfSelector,
			List<ObjectSelection> resourceSelector,
			String performanceMetric,
			ThresholdType thresholdType,
			String thresholdDetails) {
		this.nsSelector = nsSelector;
		this.vnfSelector = vnfSelector;
		if (resourceSelector != null) this.resourceSelector = resourceSelector;
		this.performanceMetric = performanceMetric;
		this.thresholdType = thresholdType;
		this.thresholdDetails = thresholdDetails;
	}

	
	
	/**
	 * @return the vnfSelector
	 */
	public ObjectSelection getVnfSelector() {
		return vnfSelector;
	}

	/**
	 * @return the nsSelector
	 */
	public ObjectSelection getNsSelector() {
		return nsSelector;
	}

	/**
	 * @return the resourceSelector
	 */
	public List<ObjectSelection> getResourceSelector() {
		return resourceSelector;
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
		if (((resourceSelector == null) || (resourceSelector.isEmpty())) && (nsSelector == null) && (vnfSelector == null)) throw new MalformattedElementException("Create threshould request without selector");
		else {
			if (resourceSelector != null) for (ObjectSelection os : resourceSelector) os.isValid();
			if (nsSelector != null) nsSelector.isValid();
			if (vnfSelector != null) vnfSelector.isValid();
		}
		if (performanceMetric == null) throw new MalformattedElementException("Create threshold request without metric");
		if (thresholdDetails == null) throw new MalformattedElementException("Create threshold request without threshold details");
	}

}
