package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.11.3.2
 * 
 * @author nextworks
 *
 */
public class VirtualNetworkQuotaData implements InterfaceInformationElement {

	private int numPublicIps;
	private int numPorts;
	private int numSubnets;
	
	public VirtualNetworkQuotaData() {	}
	
	

	/**
	 * Constructor
	 * 
	 * @param numPublicIps Number of public IP addresses to be restricted by the quota
	 * @param numPorts Number of ports to be restricted by the quota
	 * @param numSubnets Number of subnets to be restricted by the quota
	 */
	public VirtualNetworkQuotaData(int numPublicIps, int numPorts, int numSubnets) {
		this.numPublicIps = numPublicIps;
		this.numPorts = numPorts;
		this.numSubnets = numSubnets;
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
	public void isValid() throws MalformattedElementException {	}

}
