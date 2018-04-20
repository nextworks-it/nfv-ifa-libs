package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 *The information element describes the information needed to heal
 *a VNF that is part of an NS. The NFVO shall then 
 *invoke the HealVNF operation towards the appropriate VNFM
 * 
 *  REF IFA 013 v2.3.1 - 8.3.4.25
 * 
 * @author nextworks
 *
 */
public class HealVnfData  implements InterfaceInformationElement {

	private String vnfInstanceId;
	private String cause;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public HealVnfData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifies the VNF instance, part of the NS, requiring a healing action.
	 * @param cause Indicates the reason why a healing procedure is required.
	 * @param additionalParam Additional parameters passed by the NFVO as input to the healing process, specific to the VNF being healed.
	 */
	public HealVnfData(String vnfInstanceId,
			String cause,
			Map<String, String> additionalParam) {
		this.vnfInstanceId = vnfInstanceId;
		this.cause = cause;
		this.additionalParam = additionalParam;
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
		if (vnfInstanceId != null) throw new MalformattedElementException("Heal VNF data without VNF instance ID");
	}

}
