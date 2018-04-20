package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VnfLocationConstraint information element defines the location 
 * constraints for the VNF to be instantiated.
 * 
 * Ref. IFA 013 v2.3.1 section 8.3.4.4
 * 
 * @author nextworks
 *
 */
public class VnfLocationConstraints implements InterfaceInformationElement {

	private String vnfProfileId;
	private String locationConstraints;
	
	public VnfLocationConstraints() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfProfileId Identifier (reference to) of a VnfProfile in the NSD used to manage the lifecycle of the VNF instance.
	 * @param locationConstraints Defines the location constraints for the VNF instance to be created.
	 */
	public VnfLocationConstraints(String vnfProfileId, String locationConstraints) {
		this.vnfProfileId = vnfProfileId;
		this.locationConstraints = locationConstraints;
	}

	
	
	/**
	 * @return the vnfProfileId
	 */
	public String getVnfProfileId() {
		return vnfProfileId;
	}

	/**
	 * @return the locationConstraints
	 */
	public String getLocationConstraints() {
		return locationConstraints;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.vnfProfileId == null) throw new MalformattedElementException("VNF location constraints without VNF profile ID");
		if (this.locationConstraints == null) throw new MalformattedElementException("VNF location constraints without constraints");
	}

}
