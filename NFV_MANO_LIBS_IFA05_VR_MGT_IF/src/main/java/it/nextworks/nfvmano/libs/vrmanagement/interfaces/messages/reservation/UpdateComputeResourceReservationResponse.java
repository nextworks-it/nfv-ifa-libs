package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualCompute;

/**
 * Response to a request to update a reservation for a compute resource
 * REF IFA 005 v2.3.1 - 7.8.1.4
 * 
 * @author nextworks
 *
 */
public class UpdateComputeResourceReservationResponse implements InterfaceMessage {

	private ReservedVirtualCompute reservationData;
	
	public UpdateComputeResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationData Element containing information about the updated reserved resource.
	 */
	public UpdateComputeResourceReservationResponse(ReservedVirtualCompute reservationData) {
		this.reservationData = reservationData;
	}

	
	
	/**
	 * @return the reservationData
	 */
	public ReservedVirtualCompute getReservationData() {
		return reservationData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (reservationData == null) throw new MalformattedElementException("Update compute reservation request without data");
		else reservationData.isValid();
	}

}
