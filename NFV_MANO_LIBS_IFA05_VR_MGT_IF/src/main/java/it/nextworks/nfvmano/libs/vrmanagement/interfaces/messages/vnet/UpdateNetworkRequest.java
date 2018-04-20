package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnetData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPortData;


/**
 * Request to update a virtual network
 * 
 * REF IFA 005 v2.3.1 - 7.4.1.4
 * 
 * @author nextworks
 *
 */
public class UpdateNetworkRequest implements InterfaceMessage {

	private String networkResourceId;
	private VirtualNetworkData updateNetworkData;
	private NetworkSubnetData updateSubnetData;
	private VirtualNetworkPortData updateNetworkPort;
	private Map<String, String> metadata = new HashMap<>();
	
	public UpdateNetworkRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param networkResourceId Identifier of the virtualised network resource to update.
	 * @param updateNetworkData If update is on a network resource, the element contains the fields that can be updated.
	 * @param updateSubnetData If update is on a subnet resource, the element contains the fields that can be updated.
	 * @param updateNetworkPort If update is on a network port, the element contains the fields that can be updated.
	 * @param metadata List of metadata key-value pairs used by the consumer to associate meaningful metadata to the related virtualised resource.
	 */
	public UpdateNetworkRequest(String networkResourceId,
			VirtualNetworkData updateNetworkData,
			NetworkSubnetData updateSubnetData,
			VirtualNetworkPortData updateNetworkPort,
			Map<String, String> metadata) {	
		this.networkResourceId = networkResourceId;
		this.updateNetworkData = updateNetworkData;
		this.updateNetworkPort = updateNetworkPort;
		this.updateSubnetData = updateSubnetData;
		if (metadata != null) this.metadata = metadata;
	}
	
	

	/**
	 * @return the networkResourceId
	 */
	public String getNetworkResourceId() {
		return networkResourceId;
	}

	/**
	 * @return the updateNetworkData
	 */
	public VirtualNetworkData getUpdateNetworkData() {
		return updateNetworkData;
	}

	/**
	 * @return the updateSubnetData
	 */
	public NetworkSubnetData getUpdateSubnetData() {
		return updateSubnetData;
	}

	/**
	 * @return the updateNetworkPort
	 */
	public VirtualNetworkPortData getUpdateNetworkPort() {
		return updateNetworkPort;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (networkResourceId == null) throw new MalformattedElementException("Update network request without resource ID");
		if (updateNetworkData != null) updateNetworkData.isValid();
		if (updateNetworkPort != null) updateNetworkPort.isValid();
		if (updateSubnetData != null) updateSubnetData.isValid();
	}

}
