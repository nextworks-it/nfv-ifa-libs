package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification informs the receiver of the deletion 
 * of a VNF instance identifier and the associated instance 
 * of a VnfInfo information element identified by that identifier.
 * 
 * REF IFA 007 v2.3.1 - 8.6.8
 * 
 * @author nextworks
 *
 */
public class VnfIdentifierDeletionNotification implements InterfaceMessage {

	private String vnfInstanceId;
	
	public VnfIdentifierDeletionNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId The VNF instance identifier that has been deleted.
	 */
	public VnfIdentifierDeletionNotification(String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	
	
	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("VNF ID deletion notification without VNF ID");
	}

}
