package it.nextworks.nfvmano.libs.swimages.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Update sw image request
 * 
 * REF IFA 006 - v2.3.1 - 7.2.5.2
 * 
 * @author nextworks
 *
 */
public class UpdateImageRequest implements InterfaceMessage {

	private String id;
	private Map<String, String> userMetadata = new HashMap<>();
	
	public UpdateImageRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param id The identifier of the software image to be updated.
	 * @param userMetadata User-defined metadata for the software image.
	 */
	public UpdateImageRequest(String id,
			Map<String, String> userMetadata) {	
		this.id = id;
		if (userMetadata != null) this.userMetadata = userMetadata;
	}

	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the userMetadata
	 */
	public Map<String, String> getUserMetadata() {
		return userMetadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (id == null) throw new MalformattedElementException("Update sw image request without image ID");
	}

}
