package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualComputeQuota;

/**
 * Response to an update compute resource quota.
 * 
 * REF IFA 005 v2.3.1 - 7.9.1.4
 * 
 * @author nextworks
 *
 */
public class UpdateComputeResourceQuotaResponse implements InterfaceMessage {

	private VirtualComputeQuota quotaData;
	
	public UpdateComputeResourceQuotaResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param quotaData Element containing information about the updated quota resource.
	 */
	public UpdateComputeResourceQuotaResponse(VirtualComputeQuota quotaData) {
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
		if (quotaData == null) throw new MalformattedElementException("Update compute quota response without quota description");
		else quotaData.isValid();
	}

}
