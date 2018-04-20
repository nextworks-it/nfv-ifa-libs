package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Delete threshold response
 * 
 * REF IFA 013 v2.3.1 - 7.5.8
 * 
 * @author nextworks
 *
 */
public class DeleteThresholdsResponse implements InterfaceMessage {

	private List<String> deletedThresholdId = new ArrayList<>();
	
	public DeleteThresholdsResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param deletedThresholdId Identifiers of the thresholds that have been deleted successfully.
	 */
	public DeleteThresholdsResponse(List<String> deletedThresholdId) {
		if (deletedThresholdId != null) this.deletedThresholdId = deletedThresholdId;
	}

	
	
	/**
	 * @return the deletedThresholdId
	 */
	public List<String> getDeletedThresholdId() {
		return deletedThresholdId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((deletedThresholdId == null) || (deletedThresholdId.isEmpty())) throw new MalformattedElementException("Delete threshold response without IDs");
	}

}
