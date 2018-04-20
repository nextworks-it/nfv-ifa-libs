package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to enable an NSD already on-boarded.
 * REF IFA 013 v2.3.1 - 7.2.3
 * 
 * @author nextworks
 *
 */
public class EnableNsdRequest implements InterfaceMessage {

	private String nsdInfoId;
	
	public EnableNsdRequest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsdInfoId Identifier of the on-boarded instance of the NSD.
	 */
	public EnableNsdRequest(String nsdInfoId) {
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
		if (this.nsdInfoId == null) throw new MalformattedElementException("Enable NSD request without NSD info ID");
	}

}
