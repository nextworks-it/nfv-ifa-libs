package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualStorageQuota;

/**
 * Response to a create storage quota request.
 * REF IFA 005 v2.3.1 - 7.9.3.2
 * 
 * @author nextworks
 *
 */
public class CreateStorageResourceQuotaResponse implements InterfaceMessage {

	private VirtualStorageQuota quotaData;
	
	public CreateStorageResourceQuotaResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param quotaData Element containing information about the quota resource.
	 */
	public CreateStorageResourceQuotaResponse(VirtualStorageQuota quotaData) {
		this.quotaData = quotaData;
	}
	
	

	/**
	 * @return the quotaData
	 */
	public VirtualStorageQuota getQuotaData() {
		return quotaData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (quotaData == null) throw new MalformattedElementException("Create storage quota request without data.");
		else quotaData.isValid();
	}

}
