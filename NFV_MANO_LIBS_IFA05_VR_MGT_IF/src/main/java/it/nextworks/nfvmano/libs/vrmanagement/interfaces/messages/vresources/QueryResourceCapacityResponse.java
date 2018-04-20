package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.CapacityInformation;


/**
 * Query for VIM resource capacity
 * 
 * REF IFA 005 v2.3.1 - section 7.3.4.2, 7.4.4.2, 7.5.4.2
 * 
 * @author nextworks
 *
 */
public class QueryResourceCapacityResponse implements InterfaceMessage {
	
	private CapacityInformation capacityResponse;

	public QueryResourceCapacityResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param capacityResponse The capacity during the requested time period. The scope is according to parameter zoneId of the request during the time interval.
	 */
	public QueryResourceCapacityResponse(CapacityInformation capacityResponse) {	
		this.capacityResponse = capacityResponse;
	}
	
	

	/**
	 * @return the capacityResponse
	 */
	public CapacityInformation getCapacityResponse() {
		return capacityResponse;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (capacityResponse == null) throw new MalformattedElementException("Query capacity response without response element");

	}

}
