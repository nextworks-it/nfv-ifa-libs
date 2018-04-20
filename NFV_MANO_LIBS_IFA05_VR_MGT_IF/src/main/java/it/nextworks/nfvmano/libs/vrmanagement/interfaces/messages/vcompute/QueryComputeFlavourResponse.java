package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;

/**
 * Response to a query compute flavour
 * 
 * REF IFA 005 v2.3.1 - 7.3.5.3
 * 
 * @author nextworks
 *
 */
public class QueryComputeFlavourResponse implements InterfaceMessage {

	private List<VirtualComputeFlavour> flavours = new ArrayList<>();
	
	public QueryComputeFlavourResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param flavours A list of Compute Flavours matching the query.
	 */
	public QueryComputeFlavourResponse(List<VirtualComputeFlavour> flavours) {
		if (flavours != null) this.flavours = flavours;
	}

	
	
	/**
	 * @return the flavours
	 */
	public List<VirtualComputeFlavour> getFlavours() {
		return flavours;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualComputeFlavour vcf : flavours) vcf.isValid();
	}

}
