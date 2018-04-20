package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualNetwork;

/**
 * Response to a request to create a reservation for network resources.
 * 
 * REF IFA 005 v2.3.1 - 7.8.2.2
 * 
 * @author nextworks
 *
 */
public class CreateNetworkResourceReservationResponse implements InterfaceMessage {

	private ReservedVirtualNetwork reservationData;
	
	public CreateNetworkResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationData Element containing information about the reserved resource.
	 */
	public CreateNetworkResourceReservationResponse(ReservedVirtualNetwork reservationData) {
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
		if (reservationData == null) throw new MalformattedElementException("Create network resource reservation response without data");
		else reservationData.isValid();
	}

}
