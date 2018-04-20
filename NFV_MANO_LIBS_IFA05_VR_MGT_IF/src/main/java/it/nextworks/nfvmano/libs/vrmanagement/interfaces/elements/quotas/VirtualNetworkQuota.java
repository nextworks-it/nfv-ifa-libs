package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.11.3.3
 * 
 * @author nextworks
 *
 */
public class VirtualNetworkQuota implements InterfaceInformationElement {

	private String resourceGroupId;
	private int numPublicIps;
	private int numPorts;
	private int numSubnets;
	
	public VirtualNetworkQuota() {	}

	/**
	 * Constructor
	 * 
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 * @param numPublicIps Number of public IP addresses that have been restricted by the quota
	 * @param numPorts Number of ports that have been restricted by the quota
	 * @param numSubnets Number of subnets that have been restricted by the quota
	 */
	public VirtualNetworkQuota(String resourceGroupId, int numPublicIps, int numPorts, int numSubnets) {
		this.resourceGroupId = resourceGroupId;
		this.numPublicIps = numPublicIps;
		this.numPorts = numPorts;
		this.numSubnets = numSubnets;
	}



	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}

	/**
	 * @return the numPublicIps
	 */
	public int getNumPublicIps() {
		return numPublicIps;
	}



	/**
	 * @return the numPorts
	 */
	public int getNumPorts() {
		return numPorts;
	}



	/**
	 * @return the numSubnets
	 */
	public int getNumSubnets() {
		return numSubnets;
	}

	
	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceGroupId == null) throw new MalformattedElementException("Virtual network quota without resource group ID.");
	}

}