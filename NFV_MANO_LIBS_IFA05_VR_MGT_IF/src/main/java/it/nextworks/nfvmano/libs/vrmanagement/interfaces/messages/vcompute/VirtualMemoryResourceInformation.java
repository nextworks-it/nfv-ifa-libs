package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VirtualMemoryResourceInformation defines the virtual memory 
 * characteristics of consumable virtualised compute resource.
 * 
 * REF IFA 005 v2.1.1 - 8.3.3.4
 * 
 * @author nextworks
 *
 */
public class VirtualMemoryResourceInformation implements DescriptorInformationElement {

	private int virtualMemSize;
	private String virtualMemOversubscriptionPolicy;
	private boolean numaSupported;
	
	public VirtualMemoryResourceInformation() {	}
	
	/**
	 * Constructor
	 * 
	 * @param virtualMemSize Amount of virtual memory in MB
	 * @param virtualMemOversubscriptionPolicy The memory core oversubscription policy in terms of virtual memory to physical memory on the platform.
	 * @param numaSupported It specifies if the memory allocation can be cognisant of the relevant process/core allocation.
	 */
	public VirtualMemoryResourceInformation(int virtualMemSize,
			String virtualMemOversubscriptionPolicy,
			boolean numaSupported) {	
		this.virtualMemSize = virtualMemSize;
		this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
		this.numaSupported = numaSupported;
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
	 * @return the numaSupported
	 */
	public boolean isNumaSupported() {
		return numaSupported;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
