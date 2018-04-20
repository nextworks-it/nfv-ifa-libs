package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkResourceInformation;


public class QueryVirtualNetworkResourceInfoResponse implements InterfaceMessage {

	private List<VirtualNetworkResourceInformation> virtualisedResourceInformation = new ArrayList<>();
	
	public QueryVirtualNetworkResourceInfoResponse() {}
	
	/**
	 * Constructor
	 * 
	 * @param virtualisedResourceInformation Virtualised network resource information in the VIM that satisfies the query condition
	 */
	public QueryVirtualNetworkResourceInfoResponse(List<VirtualNetworkResourceInformation> virtualisedResourceInformation) {
		if (virtualisedResourceInformation != null) this.virtualisedResourceInformation = virtualisedResourceInformation;
	}
	
	/**
	 * @return the virtualisedResourceInformation
	 */
	public List<VirtualNetworkResourceInformation> getVirtualisedResourceInformation() {
		return virtualisedResourceInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (virtualisedResourceInformation == null) throw new MalformattedElementException("Query virtual network resource information response without info");
		else {
			for (VirtualNetworkResourceInformation vcr : virtualisedResourceInformation) vcr.isValid();
		}
	}

}
