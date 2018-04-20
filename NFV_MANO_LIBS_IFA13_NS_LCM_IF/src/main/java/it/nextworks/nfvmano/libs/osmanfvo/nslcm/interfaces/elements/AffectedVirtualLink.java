package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.enums.NsVlChangeType;

/**
 * This information element provides information about added, deleted or modified VLs of an NS.
 * 
 * REF IFA 013 v2.3.1 - 8.3.2.5
 * 
 * 
 * @author nextworks
 *
 */
public class AffectedVirtualLink implements InterfaceInformationElement {

	private String nsVirtualLinkId;
	private String nsVirtualLinkDescId;
	private String vlProfileId;
	private NsVlChangeType changeType;
	
	public AffectedVirtualLink() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nsVirtualLinkId Identifier of the VL instance.
	 * @param nsVirtualLinkDescId Identifier of the VLD in the NSD for this VL.
	 * @param vlProfileId Identifier of the VL profile of the NSD.
	 * @param changeType Signals the type of lifecycle change.
	 */
	public AffectedVirtualLink(String nsVirtualLinkId,
			String nsVirtualLinkDescId,
			String vlProfileId,
			NsVlChangeType changeType) {
		this.nsVirtualLinkDescId = nsVirtualLinkDescId;
		this.nsVirtualLinkId = nsVirtualLinkId;
		this.vlProfileId = vlProfileId;
		this.changeType = changeType;
	}
	
	

	/**
	 * @return the nsVirtualLinkId
	 */
	@JsonProperty("nsVirtualLinkId")
	public String getNsVirtualLinkId() {
		return nsVirtualLinkId;
	}

	/**
	 * @return the nsVirtualLinkDescId
	 */
	@JsonProperty("nsVirtualLinkDescId")
	public String getNsVirtualLinkDescId() {
		return nsVirtualLinkDescId;
	}

	/**
	 * @return the vlProfileId
	 */
	@JsonProperty("vlProfileId")
	public String getVlProfileId() {
		return vlProfileId;
	}

	/**
	 * @return the changeType
	 */
	@JsonProperty("changeType")
	public NsVlChangeType getChangeType() {
		return changeType;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsVirtualLinkId == null) throw new MalformattedElementException("Affected VL without VL ID");
		if (nsVirtualLinkDescId == null) throw new MalformattedElementException("Affected VL without VLD ID");
		if (vlProfileId == null) throw new MalformattedElementException("Affected VL without VL profile ID");
	}

}
