package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to enable a VNF package
 * 
 * REF IFA 013 v2.3.1 - 7.7.3
 * 
 * @author nextworks
 *
 */
public class EnableVnfPackageRequest implements InterfaceMessage {

	private String onboardedVnfPkgInfoId;
	
	public EnableVnfPackageRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param onboardedVnfPkgInfoId Identifier of information held by the NFVO about the specific on-boarded VNF Package. This identifier was allocated by the NFVO.
	 */
	public EnableVnfPackageRequest(String onboardedVnfPkgInfoId) {
		this.onboardedVnfPkgInfoId = onboardedVnfPkgInfoId;
	}
	
	

	/**
	 * @return the onboardedVnfPkgInfoId
	 */
	public String getOnboardedVnfPkgInfoId() {
		return onboardedVnfPkgInfoId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (onboardedVnfPkgInfoId == null) throw new MalformattedElementException("Enable VNF package request without package info ID.");
	}

}
