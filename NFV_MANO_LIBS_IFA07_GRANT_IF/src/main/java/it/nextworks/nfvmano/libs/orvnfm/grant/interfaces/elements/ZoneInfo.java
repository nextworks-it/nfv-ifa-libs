package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;


import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information regarding a resource zone.
 * 
 * REF IFA 007 v2.3.1 - 8.3.4
 * 
 * @author nextworks
 *
 */
public class ZoneInfo implements InterfaceInformationElement {

	private String zoneInfoId;
	private String zoneId;
	private String vimId;
	private String resourceProviderId;
	
	public ZoneInfo() {	}
	
	/**
	 * Constructor
	 * 
	 * @param zoneInfoId The identifier of this ZoneInfo instance, for the purpose of referencing it from other information elements.
	 * @param zoneId The identifier of the resource zone, as managed by the resource management layer (typically, the VIM).
	 * @param vimId The identifier of the VIM managing the resource zone.
	 * @param resourceProviderId Identifies the entity responsible for the management the resource zone.
	 */
	public ZoneInfo(String zoneInfoId,
			String zoneId,
			String vimId,
			String resourceProviderId) {	
		this.zoneId = zoneId;
		this.zoneInfoId = zoneInfoId;
		this.vimId = vimId;
		this.resourceProviderId = resourceProviderId;
	}

	
	
	/**
	 * @return the zoneInfoId
	 */
	public String getZoneInfoId() {
		return zoneInfoId;
	}

	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}

	/**
	 * @return the vimId
	 */
	@JsonProperty("vimConnectionId")
	public String getVimId() {
		return vimId;
	}

	/**
	 * @return the resourceProviderId
	 */
	public String getResourceProviderId() {
		return resourceProviderId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (zoneInfoId == null) throw new MalformattedElementException("Zone info without info ID");
		if (zoneId == null) throw new MalformattedElementException("Zone info without zone ID");
		if (vimId == null) throw new MalformattedElementException("Zone info without vim ID");
	}

}
