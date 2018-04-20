package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualStorage;

/**
 * Response to a query storage resource reservation.
 * 
 * REF IFA 005 v2.3.1 - 7.8.3.3
 * 
 * @author nextworks
 *
 */
public class QueryStorageResourceReservationResponse implements InterfaceMessage {

	private List<ReservedVirtualStorage> queryResult = new ArrayList<>();
	
	public QueryStorageResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the reserved resource(s) matching the filter.
	 */
	public QueryStorageResourceReservationResponse(List<ReservedVirtualStorage> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	

	/**
	 * @return the queryResult
	 */
	public List<ReservedVirtualStorage> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (ReservedVirtualStorage qr : queryResult) qr.isValid();
	}

}
