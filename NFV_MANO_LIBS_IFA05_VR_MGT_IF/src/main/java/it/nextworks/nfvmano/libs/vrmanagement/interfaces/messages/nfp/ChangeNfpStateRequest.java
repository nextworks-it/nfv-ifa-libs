package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.OperationalState;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to change the state of an NFP
 * REF IFA 005 v2.3.1 - 7.4.5.5
 * 
 * @author nextworks
 *
 */
public class ChangeNfpStateRequest implements InterfaceMessage {

	private List<String> nfpId = new ArrayList<>();
	private OperationalState desiredState;
	
	public ChangeNfpStateRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param nfpId Identification of the NFPs whose states are to be changed.
	 * @param desiredState The state into which the NFP(s) are requested to be changed.
	 */
	public ChangeNfpStateRequest(List<String> nfpId,
			OperationalState desiredState) { 
		if (nfpId != null) this.nfpId = nfpId;
		this.desiredState = desiredState;
	}
	
	

	/**
	 * @return the nfpId
	 */
	public List<String> getNfpId() {
		return nfpId;
	}

	/**
	 * @return the desiredState
	 */
	public OperationalState getDesiredState() {
		return desiredState;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((nfpId == null) || (nfpId.isEmpty())) throw new MalformattedElementException("Change NFP state request without IDs");
	}

}
