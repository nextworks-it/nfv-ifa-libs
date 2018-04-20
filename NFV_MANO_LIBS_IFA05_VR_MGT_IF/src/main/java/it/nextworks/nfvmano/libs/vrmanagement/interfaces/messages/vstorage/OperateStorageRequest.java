package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.enums.StorageOperationType;

/**
 * Request to perform an operation command on a virtual storage resource.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.6
 * 
 * @author nextworks
 *
 */
public class OperateStorageRequest implements InterfaceMessage {

	private String storageId;
	private StorageOperationType storageOperation;
	private Map<String, String> storageOperationExtraData = new HashMap<>();
	
	public OperateStorageRequest() { }
	

	/**
	 * Constructor
	 *  
	 * @param storageId Identifier of the virtualised storage resource to operate.
	 * @param storageOperation Type of operation to perform on the virtualised storage resource.
	 * @param storageOperationExtraData For example, if the operation is "delete snapshot", information about what snapshot identifier to delete is provided.
	 */
	public OperateStorageRequest(String storageId, 
			StorageOperationType storageOperation,
			Map<String, String> storageOperationExtraData) {
		this.storageId = storageId;
		this.storageOperation = storageOperation;
		if (storageOperationExtraData != null) this.storageOperationExtraData = storageOperationExtraData;
	}



	/**
	 * @return the storageId
	 */
	public String getStorageId() {
		return storageId;
	}



	/**
	 * @return the storageOperation
	 */
	public StorageOperationType getStorageOperation() {
		return storageOperation;
	}



	/**
	 * @return the storageOperationExtraData
	 */
	public Map<String, String> getStorageOperationExtraData() {
		return storageOperationExtraData;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (storageId == null) throw new MalformattedElementException("Operate storage request without storage ID.");
	}

}
