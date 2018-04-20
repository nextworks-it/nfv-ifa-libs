package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualCompute;

/**
 * Response to a query request for a compute resource reservation
 * REF IFA 005 v2.3.1 - 7.8.1.3
 * 
 * @author nextworks
 *
 */
public class QueryComputeResourceReservationResponse implements InterfaceMessage {

	private List<ReservedVirtualCompute> queryResult = new ArrayList<>();
	
	public QueryComputeResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param queryResult Element containing information about the reserved resource.
	 */
	public QueryComputeResourceReservationResponse(List<ReservedVirtualCompute> queryResult) {
		if (queryResult != null) this.queryResult = queryResult;
	}
	
	

	/**
	 * @return the queryResult
	 */
	public List<ReservedVirtualCompute> getQueryResult() {
		return queryResult;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (ReservedVirtualCompute rvc : queryResult) rvc.isValid();
	}

}
