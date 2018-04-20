package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element contains a mapping between 
 * a software image definition the VNFD and the corresponding
 * software image managed by the NFVO in the VIM which is 
 * needed during compute resource instantiation.
 * 
 * REF IFA 007 v2.3.1 - 8.3.11
 * 
 * @author nextworks
 *
 */
public class VimSoftwareImage implements InterfaceInformationElement {

	private String vimId;
	private String resourceProviderId;
	private String vnfdSoftwareImageId;
	private String vimSoftwareImageId;
	
	public VimSoftwareImage() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vimId Identifier of the VIM that manages the assets listed in this information element. Shall be supported and present if VNF-related resource management in direct mode is applicable.
	 * @param resourceProviderId Identifier used by NFVO to determine the entity responsible for the management of the VIM asset.
	 * @param vnfdSoftwareImageId Identifier of the software image descriptor in the VNFD.
	 * @param vimSoftwareImageId Identifier of the software image in the resource management layer (i.e. VIM).
	 */
	public VimSoftwareImage(String vimId,
			String resourceProviderId,
			String vnfdSoftwareImageId,
			String vimSoftwareImageId) {
		this.vimId = vimId;
		this.resourceProviderId = resourceProviderId;
		this.vnfdSoftwareImageId = vnfdSoftwareImageId;
		this.vimSoftwareImageId = vimSoftwareImageId;
	}
	
	

	/**
	 * @return the vimId
	 */
	@JsonProperty("vimConnectionId")
	public String getVimId() {
		return vimId;
	}

	/**
	 * @return the resourceProviderId
	 */
	public String getResourceProviderId() {
		return resourceProviderId;
	}

	/**
	 * @return the vnfdSoftwareImageId
	 */
	public String getVnfdSoftwareImageId() {
		return vnfdSoftwareImageId;
	}

	/**
	 * @return the vimSoftwareImageId
	 */
	public String getVimSoftwareImageId() {
		return vimSoftwareImageId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfdSoftwareImageId == null) throw new MalformattedElementException("VIM sw image without VNFD sw image ID");
		if (vimSoftwareImageId == null) throw new MalformattedElementException("VIM sw image without VIM sw image ID");
	}

}
