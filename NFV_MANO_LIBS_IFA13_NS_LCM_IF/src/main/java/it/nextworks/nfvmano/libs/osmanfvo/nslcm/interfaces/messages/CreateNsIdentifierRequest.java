package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to create a new NS identifier
 * 
 * REF IFA 013 v2.3.1 - 7.3.2
 * 
 * @author nextworks
 *
 */
public class CreateNsIdentifierRequest implements InterfaceMessage {

	private String nsdId;
	private String nsName;
	private String nsDescription;
	
	//This is not standard
	private String tenantId;
	
	public CreateNsIdentifierRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param nsdId Reference to the NSD used to create this NS instance.
	 * @param nsName Human readable name of the NS instance.
	 * @param nsDescription Human readable description of the NS instance.
	 * @param tenantId ID of the tenant requesting the installation of the Network Service
	 */
	public CreateNsIdentifierRequest(String nsdId, String nsName, String nsDescription, String tenantId) {
		this.nsdId = nsdId;
		this.nsName = nsName;
		this.nsDescription = nsDescription;
		this.tenantId = tenantId;
	}

	
	
	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @return the nsdId
	 */
	public String getNsdId() {
		return nsdId;
	}

	/**
	 * @return the nsName
	 */
	public String getNsName() {
		return nsName;
	}

	/**
	 * @return the nsDescription
	 */
	public String getNsDescription() {
		return nsDescription;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsdId == null)
			throw new MalformattedElementException("Create NS ID request without NSD ID");
		if (nsDescription == null)
			throw new MalformattedElementException("Create NS ID request without NS Description");
		if (nsName == null)
			throw new MalformattedElementException("Create NS ID request without NS Name");
		if (tenantId == null)
			throw new MalformattedElementException("Create NS ID request without tenant ID");
	}

}
