package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.PmJob;

/**
 * Query PM job response
 * 
 * REF IFA 013 v2.3.1 - 7.5.6
 * REF IFA 007 v2.3.1 - 7.4.6
 * 
 * 
 * @author nextworks
 *
 */
public class QueryPmJobResponse implements InterfaceMessage {

	private List<PmJob> pmJobDetails = new ArrayList<>();
	
	public QueryPmJobResponse() {	}
	
	/**
	 * Constructor 
	 *  
	 * @param pmJobDetails Details of PM jobs matching the input filter.
	 */
	public QueryPmJobResponse(List<PmJob> pmJobDetails) {
		if (pmJobDetails != null) this.pmJobDetails = pmJobDetails;
	}
	
	

	/**
	 * @return the pmJobDetails
	 */
	public List<PmJob> getPmJobDetails() {
		return pmJobDetails;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (pmJobDetails.isEmpty()) throw new MalformattedElementException("Query PM job response without PM jobs");
		for (PmJob pj : pmJobDetails) pj.isValid();
	}

}
