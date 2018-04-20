package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualComputeQuota;

/**
 * Response to a create compute resource quota request. 
 *  REF IFA 005 v2.3.1 - 7.9.1.2
 * 
 * @author nextworks
 *
 */
public class CreateComputeResourceQuotaResponse implements InterfaceMessage {

	private VirtualComputeQuota quotaData;
	
	public CreateComputeResourceQuotaResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param quotaData Element containing information about the quota resource.
	 */
	public CreateComputeResourceQuotaResponse(VirtualComputeQuota quotaData) {
		this.quotaData = quotaData;
	}
	
	

	/**
	 * @return the quotaData
	 */
	public VirtualComputeQuota getQuotaData() {
		return quotaData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (quotaData == null) throw new MalformattedElementException("Create compute quota response without info.");
		else quotaData.isValid();
	}

}
