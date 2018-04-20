package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnet;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetwork;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;

/**
 * Response to an update network request
 * 
 * REF IFA 005 v2.3.1 - 7.4.1.4
 * 
 * @author nextworks
 *
 */
public class UpdateNetworkResponse implements InterfaceMessage {

	private String networkResourceId;
	private VirtualNetwork networkData;
	private NetworkSubnet subnetData;
	private VirtualNetworkPort networkPortData;
	
	
	public UpdateNetworkResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param networkResourceId The identifier of the virtualised network resource that has been updated. This parameter has the same value as the input parameter
	 * @param networkData If network types are updated satisfactorily, it contains the data relative to the updated network.
	 * @param subnetData If subnet types are updated satisfactorily, it contains the data relative to the updated subnet.
	 * @param networkPortData If network port types are updated satisfactorily, it contains the data relative to the updated network port.
	 */
	public UpdateNetworkResponse(String networkResourceId,
			VirtualNetwork networkData,
			NetworkSubnet subnetData,
			VirtualNetworkPort networkPortData) {
		this.networkResourceId = networkResourceId;
		this.networkData = networkData;
		this.subnetData = subnetData;
		this.networkPortData = networkPortData;
	}
	
	

	/**
	 * @return the networkResourceId
	 */
	public String getNetworkResourceId() {
		return networkResourceId;
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
		if (networkResourceId == null) throw new MalformattedElementException("Update network response without network resource ID");
		if (networkData != null) networkData.isValid();
		if (networkPortData != null) networkPortData.isValid();
		if (subnetData != null) subnetData.isValid();
	}

}
