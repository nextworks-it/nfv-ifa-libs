package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.nfp.Nfp;

/**
 * Response to a query NFP request
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.3
 * 
 * @author nextworks
 *
 */
public class QueryNfpResponse implements InterfaceMessage {

	private List<Nfp> nfpResult = new ArrayList<>();
	
	public QueryNfpResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nfpResult Provide the result for the query.
	 */
	public QueryNfpResponse(List<Nfp> nfpResult) {	
		if (nfpResult != null) this.nfpResult = nfpResult;
	}
	
	

	/**
	 * @return the nfpResult
	 */
	public List<Nfp> getNfpResult() {
		return nfpResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (Nfp nfp : nfpResult) nfp.isValid();
	}

}
