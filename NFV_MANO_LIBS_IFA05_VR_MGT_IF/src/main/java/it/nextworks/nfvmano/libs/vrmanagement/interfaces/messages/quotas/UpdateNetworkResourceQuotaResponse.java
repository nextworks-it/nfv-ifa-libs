package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualNetworkQuota;

/**
 * Response to an update network quota request.
 * 
 * REF IFA 005 v2.3.1 - 7.9.2.4
 * 
 * @author nextworks
 *
 */
public class UpdateNetworkResourceQuotaResponse implements InterfaceMessage {

	private VirtualNetworkQuota quotaData;
	
	public UpdateNetworkResourceQuotaResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param quotaData Element containing information about the updated quota resource.
	 */
	public UpdateNetworkResourceQuotaResponse(VirtualNetworkQuota quotaData) {
		this.quotaData = quotaData;
	}

	
	
	/**
	 * @return the quotaData
	 */
	public VirtualNetworkQuota getQuotaData() {
		return quotaData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (quotaData == null) throw new MalformattedElementException("Update network quota response without quota description");
		else quotaData.isValid();
	}

}
