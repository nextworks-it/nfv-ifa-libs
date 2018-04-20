package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualNetworkQuotaData;

/**
 * Request to create a new network resource quota.
 * 
 * REF IFA 005 v2.3.1 - 7.9.2.2
 * 
 * @author nextworks
 *
 */
public class CreateNetworkResourceQuotaRequest implements InterfaceMessage {

	private String resourceGroupId;
	private VirtualNetworkQuotaData virtualNetworkQuota;
	
	public CreateNetworkResourceQuotaRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 * @param virtualNetworkQuota Type and configuration of virtualised network resources that need to be restricted by the quota
	 */
	public CreateNetworkResourceQuotaRequest(String resourceGroupId, VirtualNetworkQuotaData virtualNetworkQuota) {
		this.resourceGroupId = resourceGroupId;
		this.virtualNetworkQuota = virtualNetworkQuota;
	}



	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}



	/**
	 * @return the virtualNetworkQuota
	 */
	public VirtualNetworkQuotaData getVirtualNetworkQuota() {
		return virtualNetworkQuota;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceGroupId == null) throw new MalformattedElementException("Create network quota request without resource group ID.");
		if (virtualNetworkQuota == null) throw new MalformattedElementException("Create network quota request without quota description.");
		else virtualNetworkQuota.isValid();
	}

}
