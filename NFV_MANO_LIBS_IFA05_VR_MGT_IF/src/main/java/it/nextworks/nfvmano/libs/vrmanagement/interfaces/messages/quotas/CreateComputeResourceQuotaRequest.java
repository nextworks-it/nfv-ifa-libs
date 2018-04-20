package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualComputeQuotaData;

/**
 * Request to create a new compute resource quota.
 *  REF IFA 005 v2.3.1 - 7.9.1.2
 * 
 * @author nextworks
 *
 */
public class CreateComputeResourceQuotaRequest implements InterfaceMessage {

	private String resourceGroupId;
	private VirtualComputeQuotaData virtualComputeQuota;
	
	public CreateComputeResourceQuotaRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 * @param virtualComputeQuota Amount of compute resources that need to be restricted by the quota, e.g. number of instances
	 */
	public CreateComputeResourceQuotaRequest(String resourceGroupId,
			VirtualComputeQuotaData virtualComputeQuota) {
		this.resourceGroupId = resourceGroupId;
		this.virtualComputeQuota = virtualComputeQuota;
	}
	
	

	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}

	/**
	 * @return the virtualComputeQuota
	 */
	public VirtualComputeQuotaData getVirtualComputeQuota() {
		return virtualComputeQuota;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceGroupId == null) throw new MalformattedElementException("Create compute quota request without resource group ID.");
		if (virtualComputeQuota == null) throw new MalformattedElementException("Create compute quota request without data");
		else virtualComputeQuota.isValid();
	}

}
