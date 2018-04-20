package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorage;

/**
 * Response to a virtual storage query.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.3
 * 
 * @author nextworks
 *
 */
public class QueryVirtualStorageResponse implements InterfaceMessage {

	public List<VirtualStorage> queryResult = new ArrayList<>();
	
	public QueryVirtualStorageResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the virtual storage resource(s) matching the filter.
	 */
	public QueryVirtualStorageResponse(List<VirtualStorage> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	

	/**
	 * @return the queryResult
	 */
	public List<VirtualStorage> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualStorage vs : queryResult) vs.isValid();
	}

}
