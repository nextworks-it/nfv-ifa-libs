package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;

/**
 * Request to on-board a PNFD in the NFVO.
 * 
 *  REF IFA 013 v2.3.1 - 7.2.8
 *
 * @author nextworks
 *
 */
public class OnboardPnfdRequest implements InterfaceMessage {
	
	private Pnfd pnfd;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> userDefinedData = new HashMap<>();

	public OnboardPnfdRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param pnfd PNFD to be on-boarded.
	 * @param userDefinedData User defined data for the PNFD.
	 */
	public OnboardPnfdRequest(Pnfd pnfd,
			Map<String, String> userDefinedData) {
		this.pnfd = pnfd;
		if (userDefinedData != null) this.userDefinedData = userDefinedData;
	}

	/**
	 * @return the pnfd
	 */
	public Pnfd getPnfd() {
		return pnfd;
	}

	/**
	 * @return the userDefinedData
	 */
	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (pnfd == null) {
			throw new MalformattedElementException("On board PNFD request without PNFD");
		}
		else pnfd.isValid();
	}

}
