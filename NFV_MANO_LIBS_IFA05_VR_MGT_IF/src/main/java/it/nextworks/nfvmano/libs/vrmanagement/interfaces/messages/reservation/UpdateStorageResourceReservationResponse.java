package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualStorage;

/**
 * Response to a request to update a reservation for a storage resource.
 * 
 * REF IFA 005 v2.3.1 - 7.8.3.4
 * 
 * @author nextworks
 *
 */
public class UpdateStorageResourceReservationResponse implements InterfaceMessage {

	private ReservedVirtualStorage reservationData;
	
	public UpdateStorageResourceReservationResponse() {	}

	
	
	/**
	 * Constructor
	 * 
	 * @param reservationData Element containing information about the updated reserved resource.
	 */
	public UpdateStorageResourceReservationResponse(ReservedVirtualStorage reservationData) {
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
		if (reservationData == null) throw new MalformattedElementException("Update storage resource reservation request without reservation data");
		else reservationData.isValid();
	}

}
