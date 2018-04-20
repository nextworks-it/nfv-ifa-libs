package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to terminate network request
 * 
 * REF IFA 005 v2.3.1 - 7.4.1.5
 * 
 * @author nextworks
 *
 */
public class TerminateNetworkResponse implements InterfaceMessage {

	private List<String> networkResourceId = new ArrayList<>();

	
	public TerminateNetworkResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param networkResourceId Identifier and type of the virtualised network resource(s) successfully terminated
	 */
	public TerminateNetworkResponse(List<String> networkResourceId) {	
		if (networkResourceId != null) this.networkResourceId = networkResourceId;
	}
	
	

	/**
	 * @return the networkResourceId
	 */
	public List<String> getNetworkResourceId() {
		return networkResourceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((networkResourceId == null) || (networkResourceId.isEmpty()))
			throw new MalformattedElementException("Terminate network response without resource IDs");
	}

}
