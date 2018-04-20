package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to delete a VNF package
 * 
 * REF IFA 013 v2.3.1 - 7.7.5
 * 
 * @author nextworks
 *
 */
public class DeleteVnfPackageRequest implements InterfaceMessage {

	private String onboardedVnfPkgInfoId;
	
	public DeleteVnfPackageRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param onboardedVnfPkgInfoId Identifier of information held by the NFVO about the specific on-boarded VNF Package, which is to be deleted. This identifier was allocated by the NFVO.
	 */
	public DeleteVnfPackageRequest(String onboardedVnfPkgInfoId) {	
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
		if (onboardedVnfPkgInfoId == null) throw new MalformattedElementException("Delete VNF package request without package info ID.");
	}

}
