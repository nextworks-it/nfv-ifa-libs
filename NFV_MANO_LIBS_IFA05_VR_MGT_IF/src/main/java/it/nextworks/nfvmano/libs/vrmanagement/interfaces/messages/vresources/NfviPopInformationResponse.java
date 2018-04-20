package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.NfviPop;

public class NfviPopInformationResponse implements InterfaceMessage {

	private List<NfviPop> nfviInfo = new ArrayList<>();
	
	public NfviPopInformationResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param nfviInfo The filtered information that has been retrieved
	 */
	public NfviPopInformationResponse(List<NfviPop> nfviInfo) {
		if (nfviInfo != null) this.nfviInfo = nfviInfo;
	}

	
	
	/**
	 * @return the nfviInfo
	 */
	public List<NfviPop> getNfviInfo() {
		return nfviInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (NfviPop nfvi : nfviInfo) nfvi.isValid();
	}

}
