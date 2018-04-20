package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;

/**
 * Response to a query virtual compute resource
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.3
 * 
 * @author nextworks
 *
 */
public class QueryComputeResponse implements InterfaceMessage {

	private List<VirtualCompute> virtualCompute = new ArrayList<>(); 
	
	public QueryComputeResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param virtualCompute Element containing information about the virtual compute resource(s) matching the filter.
	 */
	public QueryComputeResponse(List<VirtualCompute> virtualCompute) {	
		if (virtualCompute != null) this.virtualCompute = virtualCompute;
	}
	
	

	/**
	 * @return the virtualCompute
	 */
	public List<VirtualCompute> getVirtualCompute() {
		return virtualCompute;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualCompute vc : virtualCompute) vc.isValid();
	}

}
