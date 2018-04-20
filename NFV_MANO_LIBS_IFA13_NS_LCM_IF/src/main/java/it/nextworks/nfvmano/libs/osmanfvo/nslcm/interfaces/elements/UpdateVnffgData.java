package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element specifies the parameters needed 
 * for the update of an existing VNFFG instance.
 *
 * REF IFA 013 v2.3.1 - 8.3.4.22
 * 
 * @author nextworks
 *
 */
public class UpdateVnffgData implements InterfaceInformationElement {

	private String vnffgId;
	private List<NfpData> nfp = new ArrayList<>();
	private List<String> nfpId = new ArrayList<>();
	
	
	public UpdateVnffgData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnffgId Identifier of an existing VNFFG information element to be updated for the NS Instance.
	 * @param nfp Indicate the desired new NFP(s) for a given VNFFG after the operations of addition/removal of NS components (e.g. VNFs, VLs, etc.) have been completed, or indicate the updated or newly created NFP classification and selection rule which applied to an existing NFP.
	 * @param nfpId Identifier(s) of the NFP to be deleted from a given VNFFG
	 */
	public UpdateVnffgData(String vnffgId,
			List<NfpData> nfp,
			List<String> nfpId) {
		this.vnffgId = vnffgId;
		if (nfp != null) this.nfp = nfp;
		if (nfpId != null) this.nfpId = nfpId;
	}
	
	

	/**
	 * @return the vnffgId
	 */
	public String getVnffgId() {
		return vnffgId;
	}

	/**
	 * @return the nfp
	 */
	public List<NfpData> getNfp() {
		return nfp;
	}

	/**
	 * @return the nfpId
	 */
	public List<String> getNfpId() {
		return nfpId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnffgId == null) throw new MalformattedElementException("Update VNFFG data without VNFFG ID");

	}

}
