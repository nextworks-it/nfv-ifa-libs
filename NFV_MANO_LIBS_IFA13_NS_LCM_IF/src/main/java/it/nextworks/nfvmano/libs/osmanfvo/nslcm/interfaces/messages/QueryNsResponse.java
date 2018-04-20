package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;


/**
 * Message to provide information about an NS
 * 
 * REF IFA 013 v2.3.1 - 7.3.6
 * 
 * @author nextworks
 *
 */
public class QueryNsResponse implements InterfaceMessage {

	private List<NsInfo> queryNsResult = new ArrayList<>();
	
	public QueryNsResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param responseCode result of the query
	 * @param queryNsResult Information on the NS and VNF instances part of the NS matching the input filter.
	 */
	public QueryNsResponse(ResponseCode responseCode, List<NsInfo> queryNsResult) {
		if (queryNsResult != null) this.queryNsResult = queryNsResult;
	}

	
	/**
	 * @return the queryNsResult
	 */
	public List<NsInfo> getQueryNsResult() {
		return queryNsResult;
	}


	@Override
	public void isValid() throws MalformattedElementException {
		if (queryNsResult != null) {
			for (NsInfo info : queryNsResult) info.isValid();
		}
	}

}
