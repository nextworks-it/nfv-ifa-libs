package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to heal a VNF
 * 
 * REF IFA 007 v2.3.1 - 7.2.10
 * 
 * @author nextworks
 *
 */
public class HealVnfRequest implements InterfaceMessage {

	private String vnfInstanceId;
	private String cause;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public HealVnfRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifies the VNF instance requiring a healing action.
	 * @param cause Indicates the reason why a healing procedure is required.
	 * @param additionalParam Additional parameters passed by the NFVO as input to the healing process, specific to the VNF being healed.
	 */
	public HealVnfRequest(String vnfInstanceId,
			String cause,
			Map<String,String> additionalParam) {
		this.vnfInstanceId = vnfInstanceId;
		this.cause = cause;
		if (additionalParam != null) this.additionalParam = additionalParam;
	}
	
	

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the cause
	 */
	public String getCause() {
		return cause;
	}

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.vnfInstanceId == null) throw new MalformattedElementException("VNF heal request without VNF instance ID");

	}

}
