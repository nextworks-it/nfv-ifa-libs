package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element contains references to the asset 
 * which are defined in VNFD and managed in the VIM by the
 * NFVO, such as compute resource flavours and/or software images.
 * 
 * REF IFA 007 v2.3.1 - 8.3.9
 * 
 * @author nextworks
 *
 */
public class VimAssets implements InterfaceInformationElement {

	private List<VimComputeResourceFlavour> computeResourceFlavour = new ArrayList<>();
	private List<VimSoftwareImage> softwareImage = new ArrayList<>();
	
	public VimAssets() { }
	
	/**
	 * Constructor
	 * 
	 * @param computeResourceFlavour Mappings between virtual compute descriptors defined in the VNFD and compute resource flavours managed in the VIM.
	 * @param softwareImage Mappings between software images defined in the VNFD and software images managed in the VIM.
	 */
	public VimAssets(List<VimComputeResourceFlavour> computeResourceFlavour,
			List<VimSoftwareImage> softwareImage) { 
		if (computeResourceFlavour != null) this.computeResourceFlavour = computeResourceFlavour;
		if (softwareImage != null) this.softwareImage = softwareImage;
	}
	
	

	/**
	 * @return the computeResourceFlavour
	 */
	public List<VimComputeResourceFlavour> getComputeResourceFlavour() {
		return computeResourceFlavour;
	}

	/**
	 * @return the softwareImage
	 */
	public List<VimSoftwareImage> getSoftwareImage() {
		return softwareImage;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VimComputeResourceFlavour crf : computeResourceFlavour) crf.isValid();
		for (VimSoftwareImage si : softwareImage) si.isValid();
	}

}
