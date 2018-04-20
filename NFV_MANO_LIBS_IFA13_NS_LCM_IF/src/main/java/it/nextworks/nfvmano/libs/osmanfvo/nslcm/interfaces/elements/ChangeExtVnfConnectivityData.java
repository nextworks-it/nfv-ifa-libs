package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ExtVirtualLinkData;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The ChangeExtVnfConnectivityData information element specifies the external connectivity 
 * to change for the VNF.
 * The types of changes that this operation supports are:
 * - Disconnect the external CPs that are connected to a particular external VL, 
 * and connect them to a different external VL.
 * - Change the connectivity parameters of the existing external CPs, including changing addresses.
 * 
 * REF IFA 013 v2.3.1 - 8.3.4.29
 * 
 * @author nextworks
 *
 */
public class ChangeExtVnfConnectivityData implements InterfaceInformationElement {

	private String vnfInstanceId;
	private List<ExtVirtualLinkData> extVirtualLink = new ArrayList<>();
	private Map<String, String> additionalParam = new HashMap<>();
	
	public ChangeExtVnfConnectivityData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance.
	 * @param extVirtualLink Information about external VLs to change (e.g. connect the VNF to).
	 * @param additionalParam Additional parameters passed by the OSS as input to the external connectivity change process, specific to the VNF being changed, as declared in the VNFD
	 */
	public ChangeExtVnfConnectivityData(String vnfInstanceId,
			List<ExtVirtualLinkData> extVirtualLink,
			Map<String, String> additionalParam) {	
		this.vnfInstanceId = vnfInstanceId;
		if (extVirtualLink != null) this.extVirtualLink = extVirtualLink;
		if (additionalParam != null) this.additionalParam = additionalParam;
	}
	
	

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the extVirtualLink
	 */
	public List<ExtVirtualLinkData> getExtVirtualLink() {
		return extVirtualLink;
	}

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Change ext VNF connectivity data without VNF ID.");
		if ((extVirtualLink == null) || (extVirtualLink.isEmpty())) throw new MalformattedElementException("Change ext VNF connectivity data without external virtual links.");
		else {
			for (ExtVirtualLinkData vl : extVirtualLink) vl.isValid();
		}
	}

}
