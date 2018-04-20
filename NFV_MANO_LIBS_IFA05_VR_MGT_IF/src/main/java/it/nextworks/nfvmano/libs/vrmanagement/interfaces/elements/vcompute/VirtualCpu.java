package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The virtual CPU(s) of the virtualised compute.
 * 
 * REF IFA 005 v2.3.1 - 8.4.3.3
 * 
 * @author nextworks
 *
 */
public class VirtualCpu implements InterfaceInformationElement {

	private String cpuArchitecture;
	private int numVirtualCpu;
	private int virtualCpuClock;
	private String virtualCpuOversubscriptionPolicy;
	private VirtualCpuPinning virtualCpuPinning;
	
	/**
	 * Constructor
	 * 
	 * @param cpuArchitecture CPU architecture type
	 * @param numVirtualCpu Number of virtual CPUs.
	 * @param virtualCpuClock Minimum virtual CPU clock rate
	 * @param virtualCpuOversubscriptionPolicy The CPU core oversubscription policy, e.g. the relation of virtual CPU cores to physical CPU cores/threads
	 * @param virtualCpuPinning The virtual CPU pinning configuration for the virtualised compute resource.
	 */
	public VirtualCpu(String cpuArchitecture,
			int numVirtualCpu,
			int virtualCpuClock,
			String virtualCpuOversubscriptionPolicy,
			VirtualCpuPinning virtualCpuPinning) {
		this.cpuArchitecture = cpuArchitecture;
		this.numVirtualCpu = numVirtualCpu;
		this.virtualCpuClock = virtualCpuClock;
		this.virtualCpuOversubscriptionPolicy = virtualCpuOversubscriptionPolicy;
		this.virtualCpuPinning = virtualCpuPinning;
	}
	
	public VirtualCpu() { }
	
	

	/**
	 * @return the cpuArchitecture
	 */
	public String getCpuArchitecture() {
		return cpuArchitecture;
	}

	/**
	 * @return the numVirtualCpu
	 */
	public int getNumVirtualCpu() {
		return numVirtualCpu;
	}

	/**
	 * @return the virtualCpuClock
	 */
	@JsonProperty("cpuClock")
	public int getVirtualCpuClock() {
		return virtualCpuClock;
	}

	/**
	 * @return the virtualCpuOversubscriptionPolicy
	 */
	public String getVirtualCpuOversubscriptionPolicy() {
		return virtualCpuOversubscriptionPolicy;
	}

	/**
	 * @return the virtualCpuPinning
	 */
	public VirtualCpuPinning getVirtualCpuPinning() {
		return virtualCpuPinning;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
