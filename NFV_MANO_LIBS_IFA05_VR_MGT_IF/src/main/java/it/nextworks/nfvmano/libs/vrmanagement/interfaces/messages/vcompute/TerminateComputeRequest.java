package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to terminate one or more compute resources
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.5
 * 
 * @author nextworks
 *
 */
public class TerminateComputeRequest implements InterfaceMessage {

	private List<String> computeId = new ArrayList<>();
	
	public TerminateComputeRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param computeId Identifier(s) of the virtualised compute resource(s) to be terminated.
	 */
	public TerminateComputeRequest(List<String> computeId) {
		if (computeId != null) this.computeId = computeId;
	}
	
	

	/**
	 * @return the computeId
	 */
	public List<String> getComputeId() {
		return computeId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((computeId == null) || (computeId.isEmpty())) throw new MalformattedElementException("Terminate compute request without compute IDs"); 
	}

}
