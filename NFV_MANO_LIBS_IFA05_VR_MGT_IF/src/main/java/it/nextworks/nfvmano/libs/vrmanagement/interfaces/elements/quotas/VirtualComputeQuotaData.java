package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.11.2.2
 * 
 * @author nextworks
 *
 */
public class VirtualComputeQuotaData implements InterfaceInformationElement {

	private int numVCPUs;
	private int numVcInstances;
	private int virtualMemSize;
	
	public VirtualComputeQuotaData() {	}
	
	
	/**
	 * Constructor
	 * 
	 * @param numVCPUs Number of CPU cores to be restricted by the quota.
	 * @param numVcInstances Number of virtualisation container instances to be restricted by the quota.
	 * @param virtualMemSize Size of virtual memory to be restricted by the quota.
	 */
	public VirtualComputeQuotaData(int numVCPUs, int numVcInstances, int virtualMemSize) {
		this.numVCPUs = numVCPUs;
		this.numVcInstances = numVcInstances;
		this.virtualMemSize = virtualMemSize;
	}



	/**
	 * @return the numVCPUs
	 */
	public int getNumVCPUs() {
		return numVCPUs;
	}



	/**
	 * @return the numVcInstances
	 */
	public int getNumVcInstances() {
		return numVcInstances;
	}



	/**
	 * @return the virtualMemSize
	 */
	public int getVirtualMemSize() {
		return virtualMemSize;
	}



	@Override
	public void isValid() throws MalformattedElementException {	}

}
