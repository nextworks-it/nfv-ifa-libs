package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification informs the receiver of the creation 
 * of a new VNF instance identifier and the associated instance 
 * of a VnfInfo information element, identified by that identifier.
 * 
 * REF IFA 007 v2.3.1 - 8.6.7
 * 
 * @author nextworks
 *
 */
public class VnfIdentifierCreationNotification implements InterfaceMessage {

	private String vnfInstanceId;
	
	public VnfIdentifierCreationNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId The newly created VNF instance identifier.
	 */
	public VnfIdentifierCreationNotification(String vnfInstanceId) {
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
		if (vnfInstanceId == null) throw new MalformattedElementException("VNF ID creation notification without VNF ID");
	}

}
