package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to terminate one or more resource reservation.
 * 
 * REF IFA 005 v2.3.1 - 7.8.1.5
 * REF IFA 005 v2.3.1 - 7.8.2.5
 * REF IFA 005 v2.3.1 - 7.8.3.5
 * 
 * @author nextworks
 *
 */
public class TerminateResourceReservationRequest implements InterfaceMessage {

	private List<String> reservationId = new ArrayList<>();
	
	public TerminateResourceReservationRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationId Identifier of the resource reservation(s) to terminate.
	 */
	public TerminateResourceReservationRequest(List<String> reservationId) {
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
		if ((reservationId == null) || (reservationId.isEmpty())) throw new MalformattedElementException("Terminate resource reservation request withoud IDs");
	}

}
