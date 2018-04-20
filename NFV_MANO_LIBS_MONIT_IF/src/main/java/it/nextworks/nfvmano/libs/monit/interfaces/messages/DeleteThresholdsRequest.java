package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Delete threshold request 
 * 
 * REF IFA 013 v2.3.1 - 7.5.8
 * 
 * 
 * @author nextworks
 *
 */
public class DeleteThresholdsRequest implements InterfaceMessage {

	private List<String> thresholdId = new ArrayList<>();
	
	public DeleteThresholdsRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param thresholdId Identifiers of thresholds to be deleted.
	 */
	public DeleteThresholdsRequest(List<String> thresholdId) {
		if (thresholdId != null) this.thresholdId = thresholdId;
	}

	
	
	/**
	 * @return the thresholdId
	 */
	public List<String> getThresholdId() {
		return thresholdId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((thresholdId == null) || (thresholdId.isEmpty())) throw new MalformattedElementException("Delete threshold request without IDs");
	}

}
