package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;

/**
 * Response to a scale virtual storage request.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.7
 * 
 * @author nextworks
 *
 */
public class ScaleStorageResponse implements InterfaceMessage {

	private VirtualStorage storageData;
	
	public ScaleStorageResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param storageData Element containing information of the scaled virtualised storage resource.
	 */
	public ScaleStorageResponse(VirtualStorage storageData) {
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
		if (storageData == null) throw new MalformattedElementException("Scale storage response without storage data");
		else storageData.isValid();
	}

}
