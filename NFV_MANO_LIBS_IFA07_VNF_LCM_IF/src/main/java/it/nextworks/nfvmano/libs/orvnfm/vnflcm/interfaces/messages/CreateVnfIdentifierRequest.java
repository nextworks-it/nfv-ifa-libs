package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to create a VNF identifier
 * 
 * REF IFA 007 v2.3.1 - 7.2.2
 * 
 * @author nextworks
 *
 */
public class CreateVnfIdentifierRequest implements InterfaceMessage {

	private String vnfdId;
	private String vnfInstanceName;
	private String vnfInstanceDescription;
	
	public CreateVnfIdentifierRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfdId Identifier that identifies the VNFD which defines the VNF instance to be created.
	 * @param vnfInstanceName Human-readable name of the VNF instance to be created.
	 * @param vnfInstanceDescription Human-readable description of the VNF instance to be created.
	 */
	public CreateVnfIdentifierRequest(String vnfdId,
			String vnfInstanceName,
			String vnfInstanceDescription) {
		this.vnfdId = vnfdId;
		this.vnfInstanceDescription = vnfInstanceDescription;
		this.vnfInstanceName = vnfInstanceName;
	}
	
	

	/**
	 * @return the vnfdId
	 */
	public String getVnfdId() {
		return vnfdId;
	}

	/**
	 * @return the vnfInstanceName
	 */
	public String getVnfInstanceName() {
		return vnfInstanceName;
	}

	/**
	 * @return the vnfInstanceDescription
	 */
	public String getVnfInstanceDescription() {
		return vnfInstanceDescription;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfdId == null) throw new MalformattedElementException("Create VNF ID request without VNFD ID.");
	}

}
