package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This clause describes the attributes for the ReservedComputePool information element.
 * 
 * REF IFA 005 v2.1.1 - 8.8.3.3
 * 
 * @author nextworks
 *
 */
public class ReservedComputePool implements InterfaceInformationElement {

	private int numCpuCores;
	private int numVcInstances;
	private int virtualMemSize;
	private VirtualComputeAttributesReservationData computeAttributes;
	private String zoneId;
	
	public ReservedComputePool() {	}
	
	/**
	 * Constructor
	 * 
	 * 
	 * @param numCpuCores Number of CPU cores that have been reserved.
	 * @param numVcInstances Number of virtual container instances that have been reserved.
	 * @param virtualMemSize Size of virtual memory that has been reserved.
	 * @param computeAttributes Information specifying additional attributes of the virtual compute resource that have been reserved.
	 * @param zoneId References the resource zone where the virtual compute resources have been reserved.
	 */
	public ReservedComputePool(int numCpuCores,
			int numVcInstances,
			int virtualMemSize,
			VirtualComputeAttributesReservationData computeAttributes,
			String zoneId) {
		this.numCpuCores = numCpuCores;
		this.numVcInstances = numVcInstances;
		this.virtualMemSize = virtualMemSize;
		this.computeAttributes = computeAttributes;
		this.zoneId = zoneId;
	}

	
	
	/**
	 * @return the numCpuCores
	 */
	public int getNumCpuCores() {
		return numCpuCores;
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

	/**
	 * @return the computeAttributes
	 */
	public VirtualComputeAttributesReservationData getComputeAttributes() {
		return computeAttributes;
	}

	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (computeAttributes != null) computeAttributes.isValid();
	}

}
