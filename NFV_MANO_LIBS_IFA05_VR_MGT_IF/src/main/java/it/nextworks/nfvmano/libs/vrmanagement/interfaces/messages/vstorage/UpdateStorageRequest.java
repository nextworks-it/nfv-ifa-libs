package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorageFlavour;

/**
 * Request to update a virtual storage resource
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.4
 * 
 * @author nextworks
 *
 */
public class UpdateStorageRequest implements InterfaceMessage {

	private String storageId;
	private VirtualStorageFlavour updateStorageData;
	private Map<String, String> metaData = new HashMap<>();
	
	public UpdateStorageRequest() {	}

	/**
	 * Constructor
	 * 
	 * @param storageId Identifier of the virtualised storage resource to update.
	 * @param updateStorageData The element contains the fields that can be updated of a storage resource.
	 * @param metaData List of meta-data key-value pairs used by the consumer to associate meaningful metadata to the related virtualised resource.
	 */
	public UpdateStorageRequest(String storageId, 
			VirtualStorageFlavour updateStorageData,
			Map<String, String> metaData) {
		this.storageId = storageId;
		this.updateStorageData = updateStorageData;
		if (metaData != null) this.metaData = metaData;
	}



	/**
	 * @return the storageId
	 */
	public String getStorageId() {
		return storageId;
	}



	/**
	 * @return the updateStorageData
	 */
	public VirtualStorageFlavour getUpdateStorageData() {
		return updateStorageData;
	}



	/**
	 * @return the metaData
	 */
	public Map<String, String> getMetaData() {
		return metaData;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (storageId == null) throw new MalformattedElementException("Update storage request without storage ID");
		if (updateStorageData != null) updateStorageData.isValid();
	}

}
