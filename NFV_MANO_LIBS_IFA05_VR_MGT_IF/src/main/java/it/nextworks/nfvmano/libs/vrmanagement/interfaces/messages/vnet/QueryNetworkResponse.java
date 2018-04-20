package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnet;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetwork;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;

/**
 * Response to a query network request.
 * 
 * REF IFA 005 v2.3.1 - 7.4.1.3
 * 
 * @author nextworks
 *
 */
public class QueryNetworkResponse implements InterfaceMessage {

	//Note: the standard version includes only network data. This has been updated to cover also subnets and ports.
	
	private List<VirtualNetwork> networkData = new ArrayList<>();
	private List<NetworkSubnet> subnetData = new ArrayList<>();
	private List<VirtualNetworkPort> networkPortData = new ArrayList<>();
	
	
	public QueryNetworkResponse() { }
	
	public QueryNetworkResponse(List<VirtualNetwork> networkData,
			List<NetworkSubnet> subnetData,
			List<VirtualNetworkPort> networkPortData) {
		if (networkData != null) this.networkData = networkData;
		if (subnetData != null) this.subnetData = subnetData;
		if (networkPortData != null) this.networkPortData = networkPortData;
	}
	
	

	/**
	 * @return the networkData
	 */
	public List<VirtualNetwork> getNetworkData() {
		return networkData;
	}

	/**
	 * @return the subnetData
	 */
	public List<NetworkSubnet> getSubnetData() {
		return subnetData;
	}

	/**
	 * @return the networkPortData
	 */
	public List<VirtualNetworkPort> getNetworkPortData() {
		return networkPortData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (networkData != null) {
			for (VirtualNetwork n: networkData) n.isValid();
		}
		if (subnetData != null) {
			for (NetworkSubnet s: subnetData) s.isValid();
		}
		if (networkPortData != null) {
			for (VirtualNetworkPort p: networkPortData) p.isValid();
		}
	}

}
