package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.11.4.2
 * 
 * @author nextworks
 *
 */
public class VirtualStorageQuotaData implements InterfaceInformationElement {

	private int storageSize;
	private int numSnapshots;
	private int numVolumes;
	
	public VirtualStorageQuotaData() {	}

	
	
	/**
	 * Constructor
	 * 
	 * @param storageSize Size of virtualised storage resource (e.g. size of volume, in GB) to be restricted by the quota.
	 * @param numSnapshots Number of snapshots to be restricted by the quota.
	 * @param numVolumes Number of volumes to be restricted by the quota.
	 */
	public VirtualStorageQuotaData(int storageSize, int numSnapshots, int numVolumes) {
		this.storageSize = storageSize;
		this.numSnapshots = numSnapshots;
		this.numVolumes = numVolumes;
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
	public void isValid() throws MalformattedElementException {	}

}
