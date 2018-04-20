package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;

/**
 * Request to update an existing NSD
 * REF IFA 013 v2.3.1 - 7.2.9
 * 
 * @author nextworks
 *
 */
public class UpdatePnfdRequest implements InterfaceMessage {

	private String pnfdInfoId;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Pnfd pnfd;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> userDefinedData = new HashMap<>();
	
	public UpdatePnfdRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param pnfdInfoId Identifier of the on-boarded version of the PNFD.
	 * @param pnfd New PNFD to be created.
	 * @param userDefinedData User defined data to be updated. For existing Keys, the value is replaced.
	 */
	public UpdatePnfdRequest(String pnfdInfoId,
			Pnfd pnfd,
			Map<String, String> userDefinedData) {
		this.pnfdInfoId = pnfdInfoId;
		this.pnfd = pnfd;
		if (userDefinedData != null) this.userDefinedData = userDefinedData;
	}

	/**
	 * @return the pnfdInfoId
	 */
	public String getPnfdInfoId() {
		return pnfdInfoId;
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
		if (pnfdInfoId == null) throw new MalformattedElementException("Update PNFD request without PNFD info ID.");
		if (pnfd != null) this.pnfd.isValid();
	}
	
}
