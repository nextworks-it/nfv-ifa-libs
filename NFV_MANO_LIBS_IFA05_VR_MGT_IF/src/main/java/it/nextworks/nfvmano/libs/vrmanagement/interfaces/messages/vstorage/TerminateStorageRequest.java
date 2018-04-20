package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to terminate a virtual storage resource.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.5
 * 
 * @author nextworks
 *
 */
public class TerminateStorageRequest implements InterfaceMessage {

	private List<String> storageId = new ArrayList<>();
	
	public TerminateStorageRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param storageId Identifier of the virtualised storage resource(s) to be terminated
	 */
	public TerminateStorageRequest(List<String> storageId) {
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
		if (storageId.isEmpty()) throw new MalformattedElementException("Terminate storage request without IDs");
	}

}
