package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.quotas.VirtualStorageQuota;

/**
 * Response to a storage quota query
 * REF IFA 005 v2.3.1 - 7.9.3.3
 * 
 * @author nextworks
 *
 */
public class QueryStorageResourceQuotaResponse implements InterfaceMessage {

	private List<VirtualStorageQuota> queryResult = new ArrayList<>();
	
	public QueryStorageResourceQuotaResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the quota resource(s) matching the filter.
	 */
	public QueryStorageResourceQuotaResponse(List<VirtualStorageQuota> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	

	/**
	 * @return the queryResult
	 */
	public List<VirtualStorageQuota> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualStorageQuota qr : queryResult) qr.isValid();
	}

}
