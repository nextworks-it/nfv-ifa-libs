package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to modify a VNF
 * 
 * REF IFA 007 v2.3.1 - 7.2.12
 * 
 * @author nextworks
 *
 */
public class ModifyVnfInformationRequest implements InterfaceMessage {

	private String vnfInstanceId;
	private Map<String, String> newValues = new HashMap<>();
	
	public ModifyVnfInformationRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance for which the writeable attributes of VnfInfo are requested to be modified.
	 * @param newValues Contains the set of attributes to update.
	 */
	public ModifyVnfInformationRequest(String vnfInstanceId,
			Map<String, String> newValues) {	
		this.vnfInstanceId = vnfInstanceId;
		if (newValues != null) this.newValues = newValues;
	}

	
	
	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the newValues
	 */
	public Map<String, String> getNewValues() {
		return newValues;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Modify VNF request without ID");
		if ((newValues == null) || (newValues.isEmpty())) throw new MalformattedElementException("Modify VNF request without new values");
	}

}
