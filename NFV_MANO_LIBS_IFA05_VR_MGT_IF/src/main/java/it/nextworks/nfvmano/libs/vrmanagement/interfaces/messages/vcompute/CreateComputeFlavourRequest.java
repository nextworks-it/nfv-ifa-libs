package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;

/**
 * Request to create a compute flavour
 * 
 * REF IFA 005 v2.3.1 - 7.3.5.2
 * 
 * @author nextworks
 *
 */
public class CreateComputeFlavourRequest implements InterfaceMessage {

	private VirtualComputeFlavour flavour;
	
	public CreateComputeFlavourRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param flavour The flavour provides information about the particular memory, CPU and disk resources for virtualised compute resource to allocate.
	 */
	public CreateComputeFlavourRequest(VirtualComputeFlavour flavour) {
		this.flavour = flavour;
	}
	
	

	/**
	 * @return the flavour
	 */
	public VirtualComputeFlavour getFlavour() {
		return flavour;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (flavour == null) throw new MalformattedElementException("Create compute flavour request without flavour");
		else flavour.isValid();
	}

}
