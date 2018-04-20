package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a delete NSD request
 * REF IFA 013 v2.3.1 - 7.2.6
 * 
 * @author nextworks
 *
 */
public class DeleteNsdResponse implements InterfaceMessage {

	private List<String> nsdInfoId = new ArrayList<>();
	
	public DeleteNsdResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param nsdInfoId Identifier of the deleted NSD version(s).
	 */
	public DeleteNsdResponse(List<String> nsdInfoId) {
		if (nsdInfoId != null) this.nsdInfoId = nsdInfoId;
	}
	
	
	/**
	 * @return the nsdInfoId
	 */
	public List<String> getNsdInfoId() {
		return nsdInfoId;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {	}

}
