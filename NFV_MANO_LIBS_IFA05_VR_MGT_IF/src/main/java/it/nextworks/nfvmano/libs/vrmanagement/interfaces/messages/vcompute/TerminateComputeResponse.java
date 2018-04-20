package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a terminate compute request
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.5
 * 
 * @author nextworks
 *
 */
public class TerminateComputeResponse implements InterfaceMessage {

	private List<String> computeId = new ArrayList<>();
	
	public TerminateComputeResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param computeId Identifier(s) of the virtualised compute resource(s) successfully terminated.
	 */
	public TerminateComputeResponse(List<String> computeId) {
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
		if ((computeId == null) || (computeId.isEmpty())) throw new MalformattedElementException("Terminate compute response without compute IDs");
	}

}
