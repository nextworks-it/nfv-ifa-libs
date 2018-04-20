package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to delete an NFP
 * REF IFA 005 v2.3.1 - 7.4.5.4
 * 
 * @author nextworks
 *
 */
public class DeleteNfpRequest implements InterfaceMessage {

	private List<String> nfpId = new ArrayList<String>();
	
	public DeleteNfpRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nfpId A unique identification of the NFP(s) to be deleted.
	 */
	public DeleteNfpRequest(List<String> nfpId) {	
		if (nfpId != null) this.nfpId = nfpId;
	}
	
	

	/**
	 * @return the nfpId
	 */
	public List<String> getNfpId() {
		return nfpId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((nfpId == null) || (nfpId.isEmpty())) throw new MalformattedElementException("Delete NFP request without IDs");
	}

}
