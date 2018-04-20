package it.nextworks.nfvmano.libs.swimages.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.swimages.interfaces.elements.SoftwareImageInformation;

/**
 * Response to an addImage request
 * 
 * REF IFA 006 - v2.3.1 - 7.2.2
 * 
 * @author nextworks
 *
 */
public class AddImageResponse implements InterfaceMessage {

	private SoftwareImageInformation softwareImageMetadata;
	
	public AddImageResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param softwareImageMetadata Metadata about the Software Image that has been added or updated
	 */
	public AddImageResponse(SoftwareImageInformation softwareImageMetadata) {
		this.softwareImageMetadata = softwareImageMetadata;
	}

	
	
	/**
	 * @return the softwareImageMetadata
	 */
	public SoftwareImageInformation getSoftwareImageMetadata() {
		return softwareImageMetadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (softwareImageMetadata == null) throw new MalformattedElementException("Add sw image response without metadata");
		else softwareImageMetadata.isValid();

	}

}
