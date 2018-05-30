package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.AppPackageInfo;
import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Reply to a MEC App package info query
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.2/8
 * 
 * @author nextworks
 *
 */
public class QueryOnBoadedAppPkgInfoResponse implements InterfaceMessage {

	private List<AppPackageInfo> queryResult = new ArrayList<AppPackageInfo>();
	
	public QueryOnBoadedAppPkgInfoResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param queryResult details of the on-boarded application packages matching the input filter
	 */
	public QueryOnBoadedAppPkgInfoResponse(List<AppPackageInfo> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	

	/**
	 * @return the queryResult
	 */
	public List<AppPackageInfo> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (AppPackageInfo api : queryResult) api.isValid();
	}

}
