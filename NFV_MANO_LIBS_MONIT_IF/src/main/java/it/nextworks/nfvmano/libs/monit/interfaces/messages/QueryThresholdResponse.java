package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.Threshold;

/**
 * Query threshold response
 * 
 * REF IFA 013 v2.3.1 - 7.5.9
 * REF IFA 007 v2.3.1 - 7.4.9
 * 
 * @author nextworks
 *
 */
public class QueryThresholdResponse implements InterfaceMessage {

	private List<Threshold> thresholdDetails = new ArrayList<>();
	
	public QueryThresholdResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param thresholdDetails List of threshold details matching the input filter.
	 */
	public QueryThresholdResponse(List<Threshold> thresholdDetails) { 
		if (thresholdDetails != null) this.thresholdDetails = thresholdDetails;
	}
	
	

	/**
	 * @return the thresholdDetails
	 */
	public List<Threshold> getThresholdDetails() {
		return thresholdDetails;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (Threshold thr : thresholdDetails) thr.isValid();
	}

}
