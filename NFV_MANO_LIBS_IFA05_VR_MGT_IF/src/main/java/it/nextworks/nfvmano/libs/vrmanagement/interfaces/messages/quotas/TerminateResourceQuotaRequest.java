package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to terminate a resource quota.
 * 
 * REF IFA 005 v2.3.1 - 7.9.1.5
 * REF IFA 005 v2.3.1 - 7.9.2.5
 * REF IFA 005 v2.3.1 - 7.9.3.5
 * 
 * 
 * @author nextworks
 *
 */
public class TerminateResourceQuotaRequest implements InterfaceMessage {

	private List<String> resourceGroupId = new ArrayList<>();
	
	public TerminateResourceQuotaRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 */
	public TerminateResourceQuotaRequest(List<String> resourceGroupId) {
		if (resourceGroupId != null) this.resourceGroupId = resourceGroupId;
	}
	
	

	/**
	 * @return the resourceGroupId
	 */
	public List<String> getResourceGroupId() {
		return resourceGroupId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceGroupId.isEmpty()) throw new MalformattedElementException("Terminate resource quota request without resource group IDs.");
	}

}
