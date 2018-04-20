package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;

/**
 * Response to an update virtual storage request
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.4
 * 
 * @author nextworks
 *
 */
public class UpdateStorageResponse implements InterfaceMessage {

	private String storageId;
	private VirtualStorage storageData;
	
	public UpdateStorageResponse() { }

	
	/**
	 * Constructor
	 * 
	 * @param storageId The identifier of the virtualised storage resource that has been updated. This parameter has the same value as the input parameter.
	 * @param storageData It contains the data relative to the updated storage.
	 */
	public UpdateStorageResponse(String storageId, 
			VirtualStorage storageData) {
		this.storageId = storageId;
		this.storageData = storageData;
	}



	/**
	 * @return the storageId
	 */
	public String getStorageId() {
		return storageId;
	}



	/**
	 * @return the storageData
	 */
	public VirtualStorage getStorageData() {
		return storageData;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (storageId == null) throw new MalformattedElementException("Update storage response without storage ID");
		if (storageData == null) throw new MalformattedElementException("Update storage response without storage data");
		else storageData.isValid();

	}

}
