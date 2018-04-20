package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeResourceInformation;

/**
 * Response to a query virtual compute resource info request
 * 
 *  REF IFA 005 v2.3.1 - 7.3.3.4
 * 
 * @author nextworks
 *
 */
public class QueryVirtualComputeResourceInfoResponse implements InterfaceMessage {

	private List<VirtualComputeResourceInformation> virtualisedResourceInformation = new ArrayList<>();
	
	public QueryVirtualComputeResourceInfoResponse() {}
	
	/**
	 * Constructor
	 * 
	 * @param virtualisedResourceInformation Virtualised compute resource information in the VIM that satisfies the query condition
	 */
	public QueryVirtualComputeResourceInfoResponse(List<VirtualComputeResourceInformation> virtualisedResourceInformation) {
		if (virtualisedResourceInformation != null) this.virtualisedResourceInformation = virtualisedResourceInformation;
	}
	
	/**
	 * @return the virtualisedResourceInformation
	 */
	public List<VirtualComputeResourceInformation> getVirtualisedResourceInformation() {
		return virtualisedResourceInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (virtualisedResourceInformation == null) throw new MalformattedElementException("Query virtual compute resource information response without info");
		else {
			for (VirtualComputeResourceInformation vcr : virtualisedResourceInformation) vcr.isValid();
		}
	}

}
