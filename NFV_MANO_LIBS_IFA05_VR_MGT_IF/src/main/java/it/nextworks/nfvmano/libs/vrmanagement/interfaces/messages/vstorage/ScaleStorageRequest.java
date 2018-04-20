package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to scale a virtual storage resource. 
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.7
 * 
 * @author nextworks
 *
 */
public class ScaleStorageRequest implements InterfaceMessage {

	private String storageId;
	private int newSize;
	
	public ScaleStorageRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param storageId Identifier of the virtualised storage resource to scale.
	 * @param newSize Resized amount of allocated storage virtualised resource.
	 */
	public ScaleStorageRequest(String storageId,
			int newSize) {
		this.storageId = storageId;
		this.newSize = newSize;
	}
	
	

	/**
	 * @return the storageId
	 */
	public String getStorageId() {
		return storageId;
	}

	/**
	 * @return the newSize
	 */
	public int getNewSize() {
		return newSize;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (storageId == null) throw new MalformattedElementException("Scale storage request without ID.");
	}

}
