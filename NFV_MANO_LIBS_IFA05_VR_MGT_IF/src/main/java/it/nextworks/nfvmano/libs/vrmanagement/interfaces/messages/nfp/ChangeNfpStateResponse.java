package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a change NFP request
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.5
 * 
 * @author nextworks
 *
 */
public class ChangeNfpStateResponse implements InterfaceMessage {

	private List<String> changedNfpId = new ArrayList<String>();
	
	public ChangeNfpStateResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param changedNfpId Identifiers of the NFPs that have successfully been changed.
	 */
	public ChangeNfpStateResponse(List<String> changedNfpId) { 
		if (changedNfpId != null) this.changedNfpId = changedNfpId;
	}
	
	

	/**
	 * @return the changedNfpId
	 */
	public List<String> getChangedNfpId() {
		return changedNfpId;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
