package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Delete PM job response
 * 
 * REF IFA 013 v2.3.1 - 7.5.3
 * 
 * 
 * @author nextworks
 *
 */
public class DeletePmJobResponse implements InterfaceMessage {

	private List<String> deletedPmJobId = new ArrayList<>();
	
	public DeletePmJobResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param deletedPmJobId Identifiers of the PM jobs successfully deleted.
	 */
	public DeletePmJobResponse(List<String> deletedPmJobId) {
		if (deletedPmJobId != null) this.deletedPmJobId = deletedPmJobId;
	}
	
	

	/**
	 * @return the deletedPmJobId
	 */
	public List<String> getDeletedPmJobId() {
		return deletedPmJobId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((deletedPmJobId == null) || (deletedPmJobId.isEmpty())) throw new MalformattedElementException("Delete PM job response without IDs");

	}

}
