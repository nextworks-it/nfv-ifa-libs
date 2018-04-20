package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.PnfdInfo;
import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;


/**
 * Message to provide information about a PNFD
 * REF IFA 013 v2.3.1 - 7.2.11
 *  
 * @author nextworks
 *
 */
public class QueryPnfdResponse implements InterfaceMessage {

	private List<PnfdInfo> queryResult = new ArrayList<>();
	
	public QueryPnfdResponse() { }
	
	/**
	 * Constructor 
	 * 
	 * @param queryResult Details of the on-boarded PNFD(s) matching the input filter.
	 */
	public QueryPnfdResponse(List<PnfdInfo> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	
	
	/**
	 * @return the queryResult
	 */
	public List<PnfdInfo> getQueryResult() {
		return queryResult;
	}
	
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (this.queryResult != null) {
			for (PnfdInfo i:this.queryResult) i.isValid();
		}
	}

}
