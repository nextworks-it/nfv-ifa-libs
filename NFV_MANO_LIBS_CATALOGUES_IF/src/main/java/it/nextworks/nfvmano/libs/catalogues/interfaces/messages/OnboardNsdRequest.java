package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;



import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;

/**
 * Request to on-board an NSD in the NFVO.
 * 
 *  REF IFA 013 v2.3.1 - 7.2.2
 *
 * @author nextworks
 *
 */
public class OnboardNsdRequest implements InterfaceMessage {

	private  Nsd nsd;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> userDefinedData = new HashMap<>();
	
	public OnboardNsdRequest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor
	 * 	
	 * @param nsd NSD to be on-boarded.
	 * @param userDefinedData User defined data for the NSD.
	 */
	public OnboardNsdRequest(Nsd nsd,
			 Map<String, String> userDefinedData) {
		this.nsd = nsd;
		if (userDefinedData != null) this.userDefinedData = userDefinedData;
	}
	
	/**
	 * @return the nsd
	 */
	public Nsd getNsd() {
		return nsd;
	}

	/**
	 * @return the userDefinedData
	 */
	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsd == null) {
			throw new MalformattedElementException("On board NSD request without NSD");
		}
		else nsd.isValid();
	}
	
}
