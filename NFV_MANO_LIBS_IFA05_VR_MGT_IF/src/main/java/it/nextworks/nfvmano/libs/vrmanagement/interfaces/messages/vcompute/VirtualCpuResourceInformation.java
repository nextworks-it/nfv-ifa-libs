package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VirtualCpuResourceInformation defines the virtual CPU(s) characteristics 
 * of consumable virtualised compute resource.
 * 
 * 
 * REF IFA 005 v2.1.1 - 8.3.3.3
 * 
 * 
 * @author nextworks
 *
 */
public class VirtualCpuResourceInformation implements DescriptorInformationElement {

	private String cpuArchitecture;
	private int numVirtualCpu;
	private int virtualCpuClock;
	private String virtualCpuOversubscriptionPolicy;
	private boolean virtualCpuPinningSupported;
	
	public VirtualCpuResourceInformation() {}
	
	/**
	 * Constructor
	 * 
	 * @param cpuArchitecture CPU architecture type.
	 * @param numVirtualCpu Number of virtual CPUs.
	 * @param virtualCpuClock Minimum virtual CPU clock rate in MHz
	 * @param virtualCpuOversubscriptionPolicy The CPU core oversubscription policy, e.g. the relation of virtual CPU cores to physical CPU cores/threads.
	 * @param virtualCpuPinningSupported It defines whether CPU pinning capability is available on the consumable virtualised compute resource.
	 */
	public VirtualCpuResourceInformation(String cpuArchitecture,
			int numVirtualCpu,
			int virtualCpuClock,
			String virtualCpuOversubscriptionPolicy,
			boolean virtualCpuPinningSupported) {
		this.cpuArchitecture = cpuArchitecture;
		this.numVirtualCpu = numVirtualCpu;
		this.virtualCpuClock = virtualCpuClock;
		this.virtualCpuOversubscriptionPolicy = virtualCpuOversubscriptionPolicy;
		this.virtualCpuPinningSupported = virtualCpuPinningSupported;
	}

	
	
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
	 * @return the virtualCpuPinningSupported
	 */
	public boolean isVirtualCpuPinningSupported() {
		return virtualCpuPinningSupported;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
