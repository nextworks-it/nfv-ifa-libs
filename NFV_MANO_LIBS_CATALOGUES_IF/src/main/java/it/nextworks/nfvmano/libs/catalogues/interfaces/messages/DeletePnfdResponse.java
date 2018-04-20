package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a delete PNFD request
 * REF IFA 013 v2.3.1 - 7.2.10
 * 
 * @author nextworks
 *
 */
public class DeletePnfdResponse implements InterfaceMessage {

	private List<String> deletedPnfdInfoId = new ArrayList<>();
	
	public DeletePnfdResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param deletedPnfdInfoId Identifier of the deleted PNFD version(s).
	 */
	public DeletePnfdResponse(List<String> deletedPnfdInfoId) {
		if (deletedPnfdInfoId != null) this.deletedPnfdInfoId = deletedPnfdInfoId;
	}
	
	
	/**
	 * @return the deletedPnfdInfoId
	 */
	public List<String> getDeletedPnfdInfoId() {
		return deletedPnfdInfoId;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {	}

}
