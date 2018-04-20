package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VnfInstanceData specifies an existing VNF instance 
 * to be used in the NS instance and if needed, the VNF Profile
 * to use for this VNF instance.
 * Ref. IFA 013 v2.3.1 section 8.3.4.3
 * 
 * @author nextworks
 *
 */
public class VnfInstanceData implements InterfaceInformationElement {

	private String vnfInstanceId;
	private String vnfProfileId;
	
	public VnfInstanceData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the existing VNF instance to be used in the NS.
	 * @param vnfProfileId Identifier of (Reference to) a vnfProfile defined in the NSD which the existing VNF instance shall be matched with.
	 */
	public VnfInstanceData(String vnfInstanceId, String vnfProfileId) {
		this.vnfInstanceId = vnfInstanceId;
		this.vnfProfileId = vnfProfileId;
	}

	
	
	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the vnfProfileId
	 */
	public String getVnfProfileId() {
		return vnfProfileId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.vnfInstanceId == null) throw new MalformattedElementException("VNF Instance Data without VNF instance ID");
	}

}
