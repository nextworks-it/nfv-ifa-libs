package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.4.3.5
 * 
 * @author nextworks
 *
 */
public class VirtualMemory implements InterfaceInformationElement {

	private int virtualMemSize;
	private String virtualMemOversubscriptionPolicy; 
	private boolean numaEnabled;
	
	public VirtualMemory() { }
	
	/**
	 * Constructor
	 * 
	 * @param virtualMemSize Amount of virtual Memory
	 * @param virtualMemOversubscriptionPolicy The memory core oversubscription policy in terms of virtual memory to physical memory on the platform.
	 * @param numaEnabled It specifies the memory allocation to be cognisant of the relevant process/core allocation.
	 */
	public VirtualMemory(int virtualMemSize,
			String virtualMemOversubscriptionPolicy,
			boolean numaEnabled) {
		this.virtualMemSize = virtualMemSize;
		this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
		this.numaEnabled = numaEnabled;
	}
	
	

	/**
	 * @return the virtualMemSize
	 */
	public int getVirtualMemSize() {
		return virtualMemSize;
	}

	/**
	 * @return the virtualMemOversubscriptionPolicy
	 */
	public String getVirtualMemOversubscriptionPolicy() {
		return virtualMemOversubscriptionPolicy;
	}

	/**
	 * @return the numaEnabled
	 */
	public boolean isNumaEnabled() {
		return numaEnabled;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
