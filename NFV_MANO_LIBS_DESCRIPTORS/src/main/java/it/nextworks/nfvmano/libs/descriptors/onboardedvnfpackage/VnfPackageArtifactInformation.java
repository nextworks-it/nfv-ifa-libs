package it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage;

import javax.persistence.Embeddable;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides identification information 
 * for artifacts (other than Software Images) which are contained in the VNF Package.
 * 
 * REF IFA 013 v2.3.1 - 8.6.6
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VnfPackageArtifactInformation implements DescriptorInformationElement {

	private String selector;
	private String metadata;
	
	public VnfPackageArtifactInformation() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param selector Information that identifies this artifact in the VNF Package.
	 * @param metadata Information (The metadata of the artifact that are available in the VNF Package, such as Content type, size, creation date, etc.) that allows to access a copy of this VNF Package artifact.
	 */
	public VnfPackageArtifactInformation(String selector,
			String metadata) {
		this.selector = selector;
		this.metadata = metadata;
	}
	
	

	/**
	 * @return the selector
	 */
	public String getSelector() {
		return selector;
	}

	/**
	 * @return the metadata
	 */
	public String getMetadata() {
		return metadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (selector == null) throw new MalformattedElementException("VNF package artifact information without selector");
		if (metadata == null) throw new MalformattedElementException("VNF package artifact information without metadata");
	}

}
