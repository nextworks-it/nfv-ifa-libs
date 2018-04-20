package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a delete NFP request
 * REF IFA 005 v2.3.1 - 7.4.5.4
 * 
 * @author nextworks
 *
 */
public class DeleteNfpResponse implements InterfaceMessage {

	private List<String> deletedNfpId = new ArrayList<String>();
	
	public DeleteNfpResponse() { }
	
	public DeleteNfpResponse(List<String> deletedNfpId) { 
		if (deletedNfpId != null) this.deletedNfpId = deletedNfpId;
	}
	
	/**
	 * @return the deletedNfpId
	 */
	public List<String> getDeletedNfpId() {
		return deletedNfpId;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
