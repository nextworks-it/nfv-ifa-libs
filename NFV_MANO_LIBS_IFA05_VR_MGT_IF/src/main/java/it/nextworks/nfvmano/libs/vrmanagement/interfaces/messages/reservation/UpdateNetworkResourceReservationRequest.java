package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation;

import java.util.Date;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation.VirtualNetworkReservation;

/**
 * Request to update a reservation for a network resource
 * REF IFA 005 v2.3.1 - 7.8.2.4
 * 
 * @author nextworks
 *
 */
public class UpdateNetworkResourceReservationRequest implements InterfaceMessage {

	private String reservationId;
	private VirtualNetworkReservation networkReservation;
	private Date startTime;
	private Date endTime;
	private Date expiryTime;
	
	public UpdateNetworkResourceReservationRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param reservationId Identifier of the existing resource reservation to be updated
	 * @param networkReservation New amount of network resources to be reserved.
	 * @param startTime New timestamp to start the consumption of the resource. If not present, the original setting will not be changed. If present and the time value is 0, resources are reserved for immediate use.
	 * @param endTime Timestamp indicating the end time of the reservation (when the issuer of the request expects that the resources will no longer be needed) and used by the VIM to schedule the reservation.
	 * @param expiryTime New timestamp indicating the time the VIM can release the reservation in case no allocation request against this reservation was made.
	 */
	public UpdateNetworkResourceReservationRequest(String reservationId,
			VirtualNetworkReservation networkReservation,
			Date startTime,
			Date endTime,
			Date expiryTime) {
		this.reservationId = reservationId;
		this.networkReservation = networkReservation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.expiryTime = expiryTime;
	}
	
	

	/**
	 * @return the reservationId
	 */
	public String getReservationId() {
		return reservationId;
	}

	/**
	 * @return the networkReservation
	 */
	public VirtualNetworkReservation getNetworkReservation() {
		return networkReservation;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @return the expiryTime
	 */
	public Date getExpiryTime() {
		return expiryTime;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (reservationId == null) throw new MalformattedElementException("Update network reservation request without reservation ID");
		if (networkReservation != null) networkReservation.isValid();
	}

}
