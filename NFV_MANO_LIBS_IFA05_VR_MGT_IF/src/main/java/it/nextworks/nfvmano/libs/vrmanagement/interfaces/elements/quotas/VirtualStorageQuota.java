package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.11.4.3
 * 
 * @author nextworks
 *
 */
public class VirtualStorageQuota implements InterfaceInformationElement {

	private String resourceGroupId;
	private int storageSize;
	private int numSnapshots;
	private int numVolumes;
	
	public VirtualStorageQuota() {	}

	
	
	/**
	 * Constructor
	 * 
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 * @param storageSize Size of virtualised storage resource that has been restricted by the quota.
	 * @param numSnapshots Number of snapshots that have been restricted by the quota.
	 * @param numVolumes Number of volumes that have been restricted by the quota.
	 */
	public VirtualStorageQuota(String resourceGroupId, int storageSize, int numSnapshots, int numVolumes) {
		this.resourceGroupId = resourceGroupId;
		this.storageSize = storageSize;
		this.numSnapshots = numSnapshots;
		this.numVolumes = numVolumes;
	}



	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}



	/**
	 * @return the storageSize
	 */
	public int getStorageSize() {
		return storageSize;
	}



	/**
	 * @return the numSnapshots
	 */
	public int getNumSnapshots() {
		return numSnapshots;
	}



	/**
	 * @return the numVolumes
	 */
	public int getNumVolumes() {
		return numVolumes;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceGroupId == null) throw new MalformattedElementException("Virtual storage quota without resource group ID.");
	}

}
