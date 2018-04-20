package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Message to request the deletion of one or more PNFDs
 * REF IFA 013 v2.3.1 - 7.2.10
 * 
 * @author nextworks
 *
 */
public class DeletePnfdRequest implements InterfaceMessage {

	private List<String> pnfdInfoId = new ArrayList<>();
	private boolean applyOnAllVersions;
	
	public DeletePnfdRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param pnfdInfoId Identifier of the on-boarded instance(s) of the PNFD to be deleted
	 * @param applyOnAllVersion Indicates if the delete operation is to be applied on all versions of this NSD. By default, if not present, it applies only on the current version.
	 */
	public DeletePnfdRequest(List<String> pnfdInfoId,
			boolean applyOnAllVersion) {
		this.applyOnAllVersions = applyOnAllVersion;
		if (pnfdInfoId != null) this.pnfdInfoId = pnfdInfoId;
	}
	
	

	/**
	 * @return the pnfdInfoId
	 */
	public List<String> getPnfdInfoId() {
		return pnfdInfoId;
	}

	/**
	 * @return the applyOnAllVersions
	 */
	public boolean isApplyOnAllVersions() {
		return applyOnAllVersions;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((this.pnfdInfoId == null) || (this.pnfdInfoId.isEmpty())) 
			throw new MalformattedElementException("Delete PNFD request without PNFD info IDs");
	}

}
