package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.enums.VirtualStorageChangeType;

/**
 * This information element provides information about added, deleted, modified and temporary virtual storage resources.
 * 
 * REF IFA 007 v2.3.1 - 8.6.5
 * 
 * @author nextworks
 *
 */
public class AffectedVirtualStorage implements InterfaceInformationElement {

	private String virtualStorageInstanceId;
	private String virtualStorageDescId;
	private VirtualStorageChangeType changeType;
	private ResourceHandle storageResource;
	
	public AffectedVirtualStorage() { }
	
	/**
	 * Constructor
	 * 
	 * @param virtualStorageInstanceId Identifier of the virtual storage instance.
	 * @param virtualStorageDescId Identifier of the VirtualStorageDesc in the VNFD.
	 * @param changeType Signals the type of change
	 * @param storageResource Reference to the VirtualStorage resource. Detailed information is (for new and modified resources) or has been (for removed resources) available from the Virtualised Storage Resource Management interface.
	 */
	public AffectedVirtualStorage(String virtualStorageInstanceId,
			String virtualStorageDescId,
			VirtualStorageChangeType changeType,
			ResourceHandle storageResource) {
		this.virtualStorageInstanceId = virtualStorageInstanceId;
		this.virtualStorageDescId = virtualStorageDescId;
		this.changeType = changeType;
		this.storageResource = storageResource;
	}

	
	
	/**
	 * @return the virtualStorageInstanceId
	 */
	public String getVirtualStorageInstanceId() {
		return virtualStorageInstanceId;
	}

	/**
	 * @return the virtualStorageDescId
	 */
	public String getVirtualStorageDescId() {
		return virtualStorageDescId;
	}

	/**
	 * @return the changeType
	 */
	public VirtualStorageChangeType getChangeType() {
		return changeType;
	}

	/**
	 * @return the storageResource
	 */
	public ResourceHandle getStorageResource() {
		return storageResource;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (virtualStorageInstanceId == null) throw new MalformattedElementException("Affected virtual storage without ID");
		if (virtualStorageDescId == null) throw new MalformattedElementException("Affected virtual storage without descriptor ID");
		if (storageResource == null) throw new MalformattedElementException("Affected virtual storage without resource");
	}

}
