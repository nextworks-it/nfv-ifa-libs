package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Message to fetch the artifacts associated to an onboarded VNF package
 * 
 * REF IFA 013 v2.3.1 - 7.2.11
 * 
 * @author nextworks
 *
 */
public class FetchOnboardedVnfPackageArtifactsRequest implements InterfaceMessage {

	private String onboardedVnfPkgInfoId;
	private List<String> artifactAccessInformation = new ArrayList<String>();
	
	public FetchOnboardedVnfPackageArtifactsRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param onboardedVnfPkgInfoId Identifier of information held by the NFVO about the specific on-boarded VNF Package.
	 * @param artifactAccessInformation List of selectors to address individual package artifacts.
	 */
	public FetchOnboardedVnfPackageArtifactsRequest(String onboardedVnfPkgInfoId,
			List<String> artifactAccessInformation) {	
		this.onboardedVnfPkgInfoId = onboardedVnfPkgInfoId;
		if (artifactAccessInformation != null) this.artifactAccessInformation = artifactAccessInformation;
	}

	
	
	/**
	 * @return the onboardedVnfPkgInfoId
	 */
	public String getOnboardedVnfPkgInfoId() {
		return onboardedVnfPkgInfoId;
	}

	/**
	 * @return the artifactAccessInformation
	 */
	public List<String> getArtifactAccessInformation() {
		return artifactAccessInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (onboardedVnfPkgInfoId == null) throw new MalformattedElementException("Featch VNF package artifacts without VNF package ID");
		if ((artifactAccessInformation == null) || (artifactAccessInformation.isEmpty())) {
			throw new MalformattedElementException("Featch VNF package artifacts without access information");
		}

	}

}
