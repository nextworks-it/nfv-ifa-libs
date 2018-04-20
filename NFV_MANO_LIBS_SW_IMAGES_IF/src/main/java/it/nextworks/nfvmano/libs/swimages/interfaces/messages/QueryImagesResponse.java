package it.nextworks.nfvmano.libs.swimages.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.swimages.interfaces.elements.SoftwareImageInformation;

/**
 * Response to a query sw images request.
 * 
 * REF IFA 006 - v2.3.1 - 7.2.3.3
 * 
 * @author nextworks
 *
 */
public class QueryImagesResponse implements InterfaceMessage {

	private List<SoftwareImageInformation> softwareImageInformation = new ArrayList<>();
	
	public QueryImagesResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param softwareImageInformation The information of all software images matching the query.
	 */
	public QueryImagesResponse(List<SoftwareImageInformation> softwareImageInformation) {
		if (softwareImageInformation != null) this.softwareImageInformation = softwareImageInformation;
	}
	
	/**
	 * @return the softwareImageInformation
	 */
	public List<SoftwareImageInformation> getSoftwareImageInformation() {
		return softwareImageInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (SoftwareImageInformation sii : softwareImageInformation) sii.isValid();
	}
	
}
