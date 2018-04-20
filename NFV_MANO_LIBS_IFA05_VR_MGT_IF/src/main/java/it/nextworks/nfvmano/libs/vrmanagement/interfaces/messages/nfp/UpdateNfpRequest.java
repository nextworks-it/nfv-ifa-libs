package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to update an NFP
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.6
 * 
 * @author nextworks
 *
 */
public class UpdateNfpRequest implements InterfaceMessage {

	private String nfpId;
	private String nfpRule;
	
	public UpdateNfpRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nfpId Identifier of the NFP to be modified.
	 * @param nfpRule NFP classification and selection rule
	 */
	public UpdateNfpRequest(String nfpId,
			String nfpRule) {
		this.nfpId = nfpId;
		this.nfpRule = nfpRule;
	}
	
	

	/**
	 * @return the nfpId
	 */
	public String getNfpId() {
		return nfpId;
	}

	/**
	 * @return the nfpRule
	 */
	public String getNfpRule() {
		return nfpRule;
	}

	@Override
	public void isValid() throws MalformattedElementException {	
		if (nfpId == null) throw new MalformattedElementException("NFP update request without NFP ID");
		if (nfpRule == null) throw new MalformattedElementException("NFP update request without NFP rule");
	}

}
