package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;


import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;

/**
 * Response to a migrate virtual storage request.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.8
 * 
 * @author nextworks
 *
 */
public class MigrateStorageResponse implements InterfaceMessage {

	private VirtualStorage storageData;
	
	public MigrateStorageResponse() { }
	
	public MigrateStorageResponse(VirtualStorage storageData) {
		this.storageData = storageData;
	}

	/**
	 * @return the storageData
	 */
	public VirtualStorage getStorageData() {
		return storageData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (storageData == null) throw new MalformattedElementException("Migrate storage response without storage data.");
		else storageData.isValid();
	}

}
