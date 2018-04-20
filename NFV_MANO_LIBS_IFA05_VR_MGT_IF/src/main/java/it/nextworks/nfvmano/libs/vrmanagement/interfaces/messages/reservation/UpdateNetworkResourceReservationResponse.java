package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualNetwork;

/**
 * Response to a request to update a reservation for a network resource
 * REF IFA 005 v2.3.1 - 7.8.2.4
 * 
 * @author nextworks
 *
 */
public class UpdateNetworkResourceReservationResponse implements InterfaceMessage {

	private ReservedVirtualNetwork reservationData;
	
	public UpdateNetworkResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationData Element containing information about the updated reserved resource
	 */
	public UpdateNetworkResourceReservationResponse(ReservedVirtualNetwork reservationData) {
		this.reservationData = reservationData;
	}
	
	

	/**
	 * @return the reservationData
	 */
	public ReservedVirtualNetwork getReservationData() {
		return reservationData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (reservationData == null) throw new MalformattedElementException("Update network reservation without data");
		else reservationData.isValid();
	}

}
