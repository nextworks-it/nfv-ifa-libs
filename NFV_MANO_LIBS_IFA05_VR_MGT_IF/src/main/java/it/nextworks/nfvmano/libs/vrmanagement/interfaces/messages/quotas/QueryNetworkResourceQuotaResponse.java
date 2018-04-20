package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualNetworkQuota;

/**
 * Query for a network resource quota.
 * 
 * REF IFA 005 v2.3.1 - 7.9.2.3
 * 
 * @author nextworks
 *
 */
public class QueryNetworkResourceQuotaResponse implements InterfaceMessage {
	
	private List<VirtualNetworkQuota> queryResult = new ArrayList<>();

	public QueryNetworkResourceQuotaResponse() { }

	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the quota resource(s) matching the filter.
	 */
	public QueryNetworkResourceQuotaResponse(List<VirtualNetworkQuota> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	
	
	/**
	 * @return the queryResult
	 */
	public List<VirtualNetworkQuota> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualNetworkQuota qr : queryResult) qr.isValid();
	}

}
