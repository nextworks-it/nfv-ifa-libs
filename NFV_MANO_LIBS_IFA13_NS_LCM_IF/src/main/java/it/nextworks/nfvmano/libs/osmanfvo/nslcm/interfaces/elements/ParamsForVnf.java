package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.HashMap;
import java.util.Map;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The ParamsForVnf specifies additional parameters for an NS instance on a per VNF instance basis.
 * Ref. IFA 013 v2.3.1 section 8.3.4.5
 * 
 * @author nextworks
 *
 */
public class ParamsForVnf implements InterfaceInformationElement {

	private String vnfProfileId;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public ParamsForVnf() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfProfileId Identifier of (reference to) a vnfProfile to which the additional parameters apply.
	 * @param additionalParam Additional parameters that are to be applied per VNF instance.
	 */
	public ParamsForVnf(String vnfProfileId, Map<String,String> additionalParam) {
		this.vnfProfileId = vnfProfileId;
		if (additionalParam != null) this.additionalParam = additionalParam;
	}
	
	

	/**
	 * @return the vnfProfileId
	 */
	public String getVnfProfileId() {
		return vnfProfileId;
	}

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		// TODO Auto-generated method stub

	}

}
