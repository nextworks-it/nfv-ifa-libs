package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 *  REF IFA 005 v2.3.1 - 8.8.6.4
 * 
 * @author nextworks
 *
 */
public class ReservedStoragePool implements InterfaceInformationElement {

	private int storageSize;
	private int numSnapshots;
	private int numVolumes;
	private String zoneId;
	
	public ReservedStoragePool() {	}

	
	/**
	 * Constructor
	 * 
	 * @param storageSize Size of virtualised storage resource that has been reserved.
	 * @param numSnapshots Number of snapshots that have been reserved.
	 * @param numVolumes Number of volumes that have been reserved.
	 * @param zoneId References the resource zone where the virtual storage resources have been reserved.
	 */
	public ReservedStoragePool(int storageSize, int numSnapshots, int numVolumes, String zoneId) {
		this.storageSize = storageSize;
		this.numSnapshots = numSnapshots;
		this.numVolumes = numVolumes;
		this.zoneId = zoneId;
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



	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}



	@Override
	public void isValid() throws MalformattedElementException {	}

}
