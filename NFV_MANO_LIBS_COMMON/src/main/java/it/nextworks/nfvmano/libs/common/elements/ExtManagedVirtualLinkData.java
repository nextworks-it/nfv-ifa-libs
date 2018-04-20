package it.nextworks.nfvmano.libs.common.elements;


import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides the information of an 
 * externally-managed internal VL to be used as a parameter
 * passed to multiple interfaces.
 * 
 * REF IFA 013 v2.3.1 - 8.3.4.28
 * REF IFA 007 v2.3.1 - 8.12.4
 * 
 * @author nextworks
 *
 */
public class ExtManagedVirtualLinkData implements InterfaceInformationElement {

	private String extManagedVirtualLinId;
	private String virtualLinkDescId;
	private String vimId;
	private String resourceProviderId;
	private String resourceId;
	
	public ExtManagedVirtualLinkData() { }

	/**
	 * Constructor
	 * 
	 * @param extManagedVirtualLinId Identifier of this externally-managed internal VL instance, if provided.
	 * @param virtualLinkDescId Identifier of the VLD in the VNFD for this VL.
	 * @param vimId Identifier of the VIM that manages this resource.
	 * @param resourceProviderId Identifies the entity responsible for the management of the resource.
	 * @param resourceId Identifier of the resource in the scope of the VIM or the resource provider.
	 */
	public ExtManagedVirtualLinkData(String extManagedVirtualLinId,
			String virtualLinkDescId,
			String vimId,
			String resourceProviderId,
			String resourceId) {
		this.extManagedVirtualLinId = extManagedVirtualLinId;
		this.vimId = vimId;
		this.virtualLinkDescId = virtualLinkDescId;
		this.resourceId = resourceId;
		this.resourceProviderId = resourceProviderId;
	}

	
	/**
	 * @return the extManagedVirtualLinId
	 */
	public String getExtManagedVirtualLinId() {
		return extManagedVirtualLinId;
	}

	/**
	 * @return the virtualLinkDescId
	 */
	public String getVirtualLinkDescId() {
		return virtualLinkDescId;
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

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceId == null) throw new MalformattedElementException("External managed VL data without resource ID");
		if (virtualLinkDescId == null) throw new MalformattedElementException("External managed VL data without VLD ID");
	}

}
