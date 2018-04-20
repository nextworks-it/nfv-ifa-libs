package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;

/**
 * Response to an allocate storage request.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.2
 * 
 * @author nextworks
 *
 */
public class AllocateStorageResponse implements InterfaceMessage {

	private VirtualStorage storageResource;
	
	public AllocateStorageResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param storageResource Element containing information of the newly instantiated virtualised storage resource.
	 */
	public AllocateStorageResponse(VirtualStorage storageResource) {
		this.storageResource = storageResource;
	}

	/**
	 * @return the storageResource
	 */
	public VirtualStorage getStorageResource() {
		return storageResource;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (storageResource == null) throw new MalformattedElementException("Allocate storage response without storage resource");
		else storageResource.isValid();
	}

}
