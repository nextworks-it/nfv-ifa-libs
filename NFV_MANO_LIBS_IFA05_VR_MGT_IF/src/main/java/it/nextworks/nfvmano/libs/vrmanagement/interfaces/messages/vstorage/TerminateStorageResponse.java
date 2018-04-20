package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a terminate storage request
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.5
 * 
 * @author nextworks
 *
 */
public class TerminateStorageResponse implements InterfaceMessage {

	private List<String> storageId = new ArrayList<>();
	
	public TerminateStorageResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param storageId Identifier of the virtualised storage resource(s) successfully terminated.
	 */
	public TerminateStorageResponse(List<String> storageId) {
		if (storageId != null) this.storageId = storageId;
	}
	
	

	/**
	 * @return the storageId
	 */
	public List<String> getStorageId() {
		return storageId;
	}

	@Override
	public void isValid() throws MalformattedElementException {	
		if (storageId.isEmpty()) throw new MalformattedElementException("Terminate storage response without IDs");
	}

}
