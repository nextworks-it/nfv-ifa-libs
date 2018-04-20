package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualNetworkQuota;


/**
 * Response to a create network quota request.
 * 
 * REF IFA 005 v2.3.1 - 7.9.2.2
 * 
 * @author nextworks
 *
 */
public class CreateNetworkResourceQuotaResponse implements InterfaceMessage {

	private VirtualNetworkQuota quotaData;
	
	public CreateNetworkResourceQuotaResponse() { }

	
	/**
	 * Constructor
	 * 
	 * @param quotaData Element containing information about the quota resource.
	 */
	public CreateNetworkResourceQuotaResponse(VirtualNetworkQuota quotaData) {
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
		if (quotaData == null) throw new MalformattedElementException("Create network quota response without quota description.");
		else quotaData.isValid();
	}

}
