package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to an operate virtual storage request.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.6
 * 
 * @author nextworks
 *
 */
public class OperateStorageResponse implements InterfaceMessage {

	private String storageId;
	private Map<String, String> storageOperationData = new HashMap<>();

	
	public OperateStorageResponse() { }
	
	
	/**
	 * Constructor
	 * 
	 * @param storageId The same identifier used in the input parameter is returned.
	 * @param storageOperationData Set of values depending on the type of operation. For instance, when a snapshot operation is requested, this field provides information about the identifier of the snapshot.
	 */
	public OperateStorageResponse(String storageId, Map<String, String> storageOperationData) {
		this.storageId = storageId;
		if (storageOperationData != null) this.storageOperationData = storageOperationData;
	}



	/**
	 * @return the storageId
	 */
	public String getStorageId() {
		return storageId;
	}



	/**
	 * @return the storageOperationData
	 */
	public Map<String, String> getStorageOperationData() {
		return storageOperationData;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (storageId == null) throw new MalformattedElementException("Operate storage response without storage ID.");
	}

}
