package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a create NFP request
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.2
 * 
 * @author nextworks
 *
 */
public class CreateNfpResponse implements InterfaceMessage {

	private List<String> nfpId = new ArrayList<>();
	
	public CreateNfpResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param nfpId The unique identification of the NFP(s) that has been created. This identification can be used to identify a particular NFP as and when required.
	 */
	public CreateNfpResponse(List<String> nfpId) {
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
		if ((nfpId == null) || (nfpId.isEmpty())) throw new MalformattedElementException("Create NFP response without NFP ID.");
	}

}
