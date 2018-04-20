package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnet;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetwork;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;


/**
 * Reply to an allocate network request, sent from the VIM 
 * 
 * REF IFA 005 v2.3.1 - 7.4.1.2
 * 
 * @author nextworks
 *
 */
public class AllocateNetworkResponse implements InterfaceMessage {

	private VirtualNetwork networkData;
	private NetworkSubnet subnetData;
	private VirtualNetworkPort networkPortData;
	
	public AllocateNetworkResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param networkData The data relative to the instantiated virtualised network resource.
	 * @param subnetData The data relative to the instantiated subnet resource.
	 * @param networkPortData The data relative to the instantiated virtualised network port resource.
	 */
	public AllocateNetworkResponse(VirtualNetwork networkData,
			NetworkSubnet subnetData,
			VirtualNetworkPort networkPortData) {
		this.networkData = networkData;
		this.subnetData = subnetData;
		this.networkPortData = networkPortData;
	}
	
	

	/**
	 * @return the networkData
	 */
	public VirtualNetwork getNetworkData() {
		return networkData;
	}

	/**
	 * @return the subnetData
	 */
	public NetworkSubnet getSubnetData() {
		return subnetData;
	}

	/**
	 * @return the networkPortData
	 */
	public VirtualNetworkPort getNetworkPortData() {
		return networkPortData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (networkData != null) networkData.isValid();
		if (networkPortData != null) networkPortData.isValid();
		if (subnetData != null) subnetData.isValid();
	}

}
