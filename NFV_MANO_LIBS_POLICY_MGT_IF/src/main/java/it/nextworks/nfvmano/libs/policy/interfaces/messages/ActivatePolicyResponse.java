package it.nextworks.nfvmano.libs.policy.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to an activate policy request
 * 
 * REF IFA 013 v3.2.1 - 7.9.5
 * 
 * @author nextworks
 *
 */
public class ActivatePolicyResponse implements InterfaceMessage {

	private List<String> activatedPolicyInfoId = new ArrayList<>();
	
	public ActivatePolicyResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param activatedPolicyInfoId Identifier(s) of the activated NFV-MANO policy(ies)
	 */
	public ActivatePolicyResponse(List<String> activatedPolicyInfoId) {
		if (activatedPolicyInfoId != null) this.activatedPolicyInfoId = activatedPolicyInfoId;
	}

	
	
	
	/**
	 * @return the activatedPolicyInfoId
	 */
	public List<String> getActivatedPolicyInfoId() {
		return activatedPolicyInfoId;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
