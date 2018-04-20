package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;


import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualStorageQuota;

/**
 * Response to an update storage resource quota.
 * 
 * REF IFA 005 v2.3.1 - 7.9.3.4
 * 
 * @author nextworks
 *
 */
public class UpdateStorageResourceQuotaResponse implements InterfaceMessage {

	private VirtualStorageQuota quotaData;
	
	public UpdateStorageResourceQuotaResponse() { }

	/**
	 * Constructor
	 * 
	 * @param quotaData Element cntaining information about the updated quota resource.
	 */
	public UpdateStorageResourceQuotaResponse(VirtualStorageQuota quotaData) {
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
		if (quotaData != null) quotaData.isValid();
	}

}
