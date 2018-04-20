package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualComputeQuota;

/**
 * Response to a query compute quotas request.
 * 
 * REF IFA 005 v2.3.1 - 7.9.1.3
 * 
 * @author nextworks
 *
 */
public class QueryComputeResourceQuotaResponse implements InterfaceMessage {

	private List<VirtualComputeQuota> queryResult = new ArrayList<>();
	
	public QueryComputeResourceQuotaResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the quota resource.
	 */
	public QueryComputeResourceQuotaResponse(List<VirtualComputeQuota> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	

	/**
	 * @return the queryResult
	 */
	public List<VirtualComputeQuota> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualComputeQuota qr : queryResult) qr.isValid();
	}

}
