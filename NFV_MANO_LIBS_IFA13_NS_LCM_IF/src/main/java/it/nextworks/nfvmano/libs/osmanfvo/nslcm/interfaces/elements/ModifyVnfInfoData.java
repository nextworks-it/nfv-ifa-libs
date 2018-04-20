package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The ModifyVnfInfoData information element specifies for a VNF 
 * instance the information that is requested to be modified. 
 * The information to be modified shall comply with the associated NSD
 * 
 * REF IFA 013 v2.3.1 - 8.3.4.17
 * 
 * @author nextworks
 *
 */
public class ModifyVnfInfoData implements InterfaceInformationElement {

	private String vnfInstanceId;
	private Map<String, String> newValues = new HashMap<>();
	
	public ModifyVnfInfoData() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance for which the writable attributes of VnfInfo are requested to be modified.
	 * @param newValues Contains the set of attributes to update. The key in the KeyValuePair indicates the name of an attribute that is writable through the interface whose value is to be updated. The value in the KeyValuePair indicates the new attribute value.
	 */
	public ModifyVnfInfoData(String vnfInstanceId, Map<String,String> newValues) {
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
		if (vnfInstanceId == null) throw new MalformattedElementException("Modify VNF info data without VNF instance ID");
		if ((newValues == null) || (newValues.isEmpty())) throw new MalformattedElementException("Modify VNF info data without new parameter values");
	}

}
