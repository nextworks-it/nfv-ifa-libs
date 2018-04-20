package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualStorage;

/**
 * Response to a create storage resource reservation request.
 * 
 *  REF IFA 005 v2.3.1 - 7.8.3.2
 * 
 * @author nextworks
 *
 */
public class CreateStorageResourceReservationResponse implements InterfaceMessage {

	private ReservedVirtualStorage reservationData;
	
	public CreateStorageResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationData Element containing information about the reserved resource.
	 */
	public CreateStorageResourceReservationResponse(ReservedVirtualStorage reservationData) {
		this.reservationData = reservationData;
	}
	
	

	/**
	 * @return the reservationData
	 */
	public ReservedVirtualStorage getReservationData() {
		return reservationData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (reservationData == null) throw new MalformattedElementException("Create storage resource reservation response without reservation data");
		else reservationData.isValid();
	}

}
