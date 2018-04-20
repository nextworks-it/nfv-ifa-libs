package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.ReservedVirtualCompute;

/**
 * Response to a request to create a reservation for compute resources.
 * 
 *  REF IFA 005 v2.3.1 - 7.8.1.2
 * 
 * @author nextworks
 *
 */
public class CreateComputeResourceReservationResponse implements InterfaceMessage {

	private ReservedVirtualCompute reservationData;
	
	public CreateComputeResourceReservationResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationData Element containing information about the reserved resource.
	 */
	public CreateComputeResourceReservationResponse(ReservedVirtualCompute reservationData) {	
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
		if (reservationData == null) throw new MalformattedElementException("Create compute reservation response without reservation data");
		else reservationData.isValid();
	}

}
