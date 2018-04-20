package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification informs the receiver of the creation of a new NS instance identifier 
 * and of the associated instance of an NsInfo information element, identified by that identifier.
 * 
 * REF IFA 013 v2.3.1 - 8.3.2.9
 * 
 * @author nextworks
 *
 */
public class NsIdentifierCreationNotification implements InterfaceMessage {

	private String nsInstanceId;
	
	public NsIdentifierCreationNotification() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId The newly created NS instance identifier.
	 */
	public NsIdentifierCreationNotification(String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
	}
	

	/**
	 * @return the nsInstanceId
	 */
	@JsonProperty("nsInstanceId")
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsInstanceId == null) throw new MalformattedElementException("NS ID creation notify without NS ID");
	}

}
