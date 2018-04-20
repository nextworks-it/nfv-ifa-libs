package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;


/**
 * Reply to a VNF package info query
 * 
 * REF IFA 013 v2.3.1 - 7.7.6
 * 
 * @author nextworks
 *
 */
public class QueryOnBoardedVnfPkgInfoResponse implements InterfaceMessage {

	private List<OnboardedVnfPkgInfo> queryResult = new ArrayList<>();
	
	public QueryOnBoardedVnfPkgInfoResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Details of the on-boarded VNF Packages matching the input filter.
	 */
	public QueryOnBoardedVnfPkgInfoResponse(List<OnboardedVnfPkgInfo> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	/**
	 * @return the queryResult
	 */
	public List<OnboardedVnfPkgInfo> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (OnboardedVnfPkgInfo pkg : queryResult) pkg.isValid();
	}

}
