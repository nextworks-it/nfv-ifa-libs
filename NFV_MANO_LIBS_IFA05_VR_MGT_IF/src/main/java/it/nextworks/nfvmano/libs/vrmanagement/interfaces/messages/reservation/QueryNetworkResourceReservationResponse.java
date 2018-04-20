package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualNetwork;

/**
 * Response to a query request for a network resource reservation
 * REF IFA 005 v2.3.1 - 7.8.2.3
 * 
 * @author nextworks
 *
 */
public class QueryNetworkResourceReservationResponse implements InterfaceMessage {

	private List<ReservedVirtualNetwork> queryResult = new ArrayList<>();
	
	public QueryNetworkResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the reserved resource(s) matching the filter.
	 */
	public QueryNetworkResourceReservationResponse(List<ReservedVirtualNetwork> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	

	/**
	 * @return the queryResult
	 */
	public List<ReservedVirtualNetwork> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((queryResult == null) || (queryResult.isEmpty())) throw new MalformattedElementException("Query network resource reservation response without data");
		else for (ReservedVirtualNetwork qr : queryResult) qr.isValid();
	}

}
