package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to disable an NSD already on-boarded.
 * REF IFA 013 v2.3.1 - 7.2.4
 * 
 * @author nextworks
 *
 */
public class DisableNsdRequest implements InterfaceMessage {

	private String nsdInfoId;
	
	public DisableNsdRequest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor	  
	 * 
	 * @param nsdInfoId Identifier of the on-boarded instance of the NSD.
	 */
	public DisableNsdRequest(String nsdInfoId) {
		this.nsdInfoId = nsdInfoId;
	}
	
	/**
	 * @return the nsdInfoId
	 */
	public String getNsdInfoId() {
		return nsdInfoId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.nsdInfoId == null) throw new MalformattedElementException("Disable NSD request without NSD info ID");
	}

}
