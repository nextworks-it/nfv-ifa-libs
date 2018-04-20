package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualStorageQuotaData;

/**
 * Request to create a storage resource quota.
 * REF IFA 005 v2.3.1 - 7.9.3.2
 * 
 * @author nextworks
 *
 */
public class CreateStorageResourceQuotaRequest implements InterfaceMessage {

	private String resourceGroupId;
	private VirtualStorageQuotaData virtualStorageQuota;
	
	public CreateStorageResourceQuotaRequest() { }
	
	

	/**
	 * Constructor 
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 * @param virtualStorageQuota Type and configuration of virtualised storage that need to be restricted by the quota
	 */
	public CreateStorageResourceQuotaRequest(String resourceGroupId, VirtualStorageQuotaData virtualStorageQuota) {
		this.resourceGroupId = resourceGroupId;
		this.virtualStorageQuota = virtualStorageQuota;
	}



	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}



	/**
	 * @return the virtualStorageQuota
	 */
	public VirtualStorageQuotaData getVirtualStorageQuota() {
		return virtualStorageQuota;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceGroupId == null) throw new MalformattedElementException("Create storage quota request without resource group ID.");
		if (virtualStorageQuota == null) throw new MalformattedElementException("Create storage quota request without quota description.");
		else virtualStorageQuota.isValid();
	}

}
