package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.NsdInfo;
import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;


/**
 * Message to provide information about an NSD
 * REF IFA 013 v2.3.1 - 7.2.7
 * 
 * @author nextworks
 *
 */
public class QueryNsdResponse implements InterfaceMessage {

	private List<NsdInfo> queryResult = new ArrayList<>();
	
	public QueryNsdResponse() {	}
	
	/**
	 * Constructor 
	 * 
	 * @param queryResult Details of the on-boarded NSD(s) matching the input filter.
	 */
	public QueryNsdResponse(List<NsdInfo> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	
	
	/**
	 * @return the queryResult
	 */
	public List<NsdInfo> getQueryResult() {
		return queryResult;
	}
	
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (this.queryResult != null) {
			for (NsdInfo i:this.queryResult) i.isValid();
		}
	}

}
