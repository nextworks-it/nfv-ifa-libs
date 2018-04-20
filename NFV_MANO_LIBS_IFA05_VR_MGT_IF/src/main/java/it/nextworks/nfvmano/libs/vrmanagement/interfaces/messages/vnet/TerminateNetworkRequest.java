package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.NetworkResourceType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to terminate a virtual network resource on the VIM
 * 
 * REF IFA 005 v2.3.1 - 7.4.1.5
 * 
 * @author nextworks
 *
 */
public class TerminateNetworkRequest implements InterfaceMessage {

	//Note: the standard version includes only a list of network resource ID
	//Since OS needs to know which kind of resource must be deleted, the resource type has been added
	
	private Map<String, NetworkResourceType> networkResourceId = new HashMap<>();
	
	public TerminateNetworkRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param networkResourceId Identifier of the virtualised network resource(s) to be terminated.
	 */
	public TerminateNetworkRequest(Map<String, NetworkResourceType> networkResourceId) {	
		if (networkResourceId != null) this.networkResourceId = networkResourceId;
	}
	
	

	/**
	 * @return the networkResourceId
	 */
	public Map<String, NetworkResourceType> getNetworkResourceId() {
		return networkResourceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((networkResourceId == null) || (networkResourceId.isEmpty()))
			throw new MalformattedElementException("Terminate network request without resource IDs");
	}

}
