package it.nextworks.nfvmano.libs.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VirtualMemoryData information element supports 
 * the specification of requirements related to virtual 
 * memory of a virtual compute resource.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.9.3
 * REF IFA 005 v2.3.1 - 8.4.2.5
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VirtualMemoryData implements DescriptorInformationElement {

	private int virtualMemSize;
	private String virtualMemOversubscriptionPolicy;
	private boolean numaEnabled;
	
	public VirtualMemoryData() {}
	
	/**
	 * Constructor
	 * 
	 * @param virtualMemSize Amount of virtual Memory (e.g. in MB).
	 * @param virtualMemOversubscriptionPolicy The memory core oversubscription policy in terms of virtual memory to physical memory on the platform.
	 * @param numaEnabled It specifies the memory allocation to be cognisant of the relevant process/core allocation.
	 */
	public VirtualMemoryData(int virtualMemSize,
			String virtualMemOversubscriptionPolicy,
			boolean numaEnabled) {
		this.virtualMemOversubscriptionPolicy = virtualMemOversubscriptionPolicy;
		this.virtualMemSize = virtualMemSize;
		this.numaEnabled = numaEnabled;
	}
	
	
	/**
	 * @return the virtualMemSize
	 */
	@JsonProperty("virtualMemSize")
	public int getVirtualMemSize() {
		return virtualMemSize;
	}

	/**
	 * @return the virtualMemOversubscriptionPolicy
	 */
	@JsonProperty("virtualMemOversubscriptionPolicy")
	public String getVirtualMemOversubscriptionPolicy() {
		return virtualMemOversubscriptionPolicy;
	}

	/**
	 * @return the numaEnabled
	 */
	@JsonProperty("numaEnabled")
	public boolean isNumaEnabled() {
		return numaEnabled;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
