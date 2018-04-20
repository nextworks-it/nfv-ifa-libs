package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.nfp.Nfp;

/**
 * Response to an update NFP request
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.6
 * 
 * @author nextworks
 *
 */
public class UpdateNfpResponse implements InterfaceMessage {

	private Nfp nfpInfo;
	
	public UpdateNfpResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param nfpInfo Provide the updated NFP information of the NFP instance.
	 */
	public UpdateNfpResponse(Nfp nfpInfo) { 
		this.nfpInfo = nfpInfo;
	}

	/**
	 * @return the nfpInfo
	 */
	public Nfp getNfpInfo() {
		return nfpInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {	
		if (nfpInfo == null) throw new MalformattedElementException("Update NFP response without NFP info");
		else nfpInfo.isValid();
	}

}
