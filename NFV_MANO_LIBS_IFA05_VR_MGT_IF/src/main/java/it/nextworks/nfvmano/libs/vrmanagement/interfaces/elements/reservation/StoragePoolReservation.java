package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 *  
 *  REF IFA 005 v2.3.1 - 8.8.6.3
 * 
 * @author nextworks
 *
 */
public class StoragePoolReservation implements InterfaceInformationElement {

	private int storageSize;
	private int numSnapshots;
	private int numVolumes;
	
	public StoragePoolReservation() {	}
	
	
	/**
	 * Constructor
	 * 
	 * @param storageSize Size of virtualised storage resource (e.g. size of volume, in GB) to be reserved.
	 * @param numSnapshots Number of snapshots to be reserved.
	 * @param numVolumes Number of volumes to be reserved.
	 */
	public StoragePoolReservation(int storageSize, int numSnapshots, int numVolumes) {
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
