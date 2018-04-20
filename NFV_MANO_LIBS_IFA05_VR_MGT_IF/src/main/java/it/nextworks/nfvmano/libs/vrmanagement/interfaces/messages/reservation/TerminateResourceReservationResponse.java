package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to a terminate resource reservation request.
 * 
 * REF IFA 005 v2.3.1 - 7.8.1.5
 * REF IFA 005 v2.3.1 - 7.8.2.5
 * REF IFA 005 v2.3.1 - 7.8.3.5
 * 
 * @author nextworks
 *
 */
public class TerminateResourceReservationResponse implements InterfaceMessage {

	private List<String> reservationId = new ArrayList<>();
	
	public TerminateResourceReservationResponse() {	}
	
	public TerminateResourceReservationResponse(List<String> reservationId) {
		if (reservationId != null) this.reservationId = reservationId;
	}

	/**
	 * @return the reservationId
	 */
	public List<String> getReservationId() {
		return reservationId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((reservationId == null) || (reservationId.isEmpty())) throw new MalformattedElementException("Terminate resource reservation response withoud IDs");
	}

}
