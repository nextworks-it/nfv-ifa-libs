package it.nextworks.nfvmano.libs.descriptors.nsd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VnfIndicatorData information identifies a VNF indicator in a VNFD.
 * Ref. IFA 014 v2.3.1 - 6.2.7
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VnfIndicatorData implements DescriptorInformationElement {

	private String vnfdId;
	private String vnfIndicator;
	
	public VnfIndicatorData() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfdId Reference to a VNFD
	 * @param vnfIndicator Reference to a VNF indicator within the VNFD
	 */
	public VnfIndicatorData(String vnfdId, 
			String vnfIndicator) {
		this.vnfdId = vnfdId;
		this.vnfIndicator = vnfIndicator;
	}
	
	/**
	 * @return the vnfdId
	 */
	@JsonProperty("vnfdId")
	public String getVnfdId() {
		return vnfdId;
	}

	/**
	 * @return the vnfIndicator
	 */
	@JsonProperty("vnfIndicator")
	public String getVnfIndicator() {
		return vnfIndicator;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.vnfdId == null) throw new MalformattedElementException("VNF indicator data without VNFD ID");
		if (this.vnfIndicator == null) throw new MalformattedElementException("VNF indicator data without VNF indicator ID");
	}

}
