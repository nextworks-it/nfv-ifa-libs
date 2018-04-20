package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Delete PM job request
 * 
 * REF IFA 013 v2.3.1 - 7.5.3
 * 
 * 
 * @author nextworks
 *
 */
public class DeletePmJobRequest implements InterfaceMessage {

	private List<String> pmJobId = new ArrayList<>();
	
	public DeletePmJobRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param pmJobId Identifiers of the PM job to be deleted.
	 */
	public DeletePmJobRequest(List<String> pmJobId) {
		if (pmJobId != null) this.pmJobId = pmJobId;
	}

	
	
	/**
	 * @return the pmJobId
	 */
	public List<String> getPmJobId() {
		return pmJobId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((pmJobId == null) || (pmJobId.isEmpty())) throw new MalformattedElementException("Delete PM job request without IDs");
	}

}
