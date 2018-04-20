package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.enums.VnffgChangeType;

/**
 * This information element provides information about added, deleted or modified VNFFG instances.
 * 
 * REF IFA 013 v2.3.1 - 8.3.2.6
 * 
 * @author nextworks
 *
 */
public class AffectedVnffg implements InterfaceInformationElement {

	private String vnffgId;
	private String vnffgdId;
	private VnffgChangeType changeType;
	
	public AffectedVnffg() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnffgId Identifier of the VNFFG instance.
	 * @param vnffgdId Identifier of the VNFFGD of the VNFFG instance.
	 * @param changeType Signals the type of lifecycle change
	 */
	public AffectedVnffg(String vnffgId,
			String vnffgdId,
			VnffgChangeType changeType) {
		this.vnffgdId = vnffgdId;
		this.vnffgId = vnffgId;
		this.changeType = changeType;
	}
	
	

	/**
	 * @return the vnffgId
	 */
	@JsonProperty("vnffgId")
	public String getVnffgId() {
		return vnffgId;
	}

	/**
	 * @return the vnffgdId
	 */
	@JsonProperty("vnffgdId")
	public String getVnffgdId() {
		return vnffgdId;
	}

	/**
	 * @return the changeType
	 */
	@JsonProperty("changeType")
	public VnffgChangeType getChangeType() {
		return changeType;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnffgId == null) throw new MalformattedElementException("Affected VNFFG without ID");
		if (vnffgdId == null) throw new MalformattedElementException("Affected VNFFG without descriptor ID");
	}

}
