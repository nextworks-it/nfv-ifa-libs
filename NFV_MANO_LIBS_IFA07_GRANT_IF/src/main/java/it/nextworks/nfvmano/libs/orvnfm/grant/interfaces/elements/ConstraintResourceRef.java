package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;


import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.enums.GrantIdType;

/**
 * This information element references a resource either 
 * by its VIM-level identifier for existing resources, or by the
 * identifier of a resourceDefinition information element 
 * in the grant request for new resources.
 * 
 * REF IFA 007 v2.3.1 - 8.3.8
 * 
 * @author nextworks
 *
 */
public class ConstraintResourceRef implements InterfaceInformationElement {

	private GrantIdType idType;
	private String resourceId;
	private String vimId;
	private String resourceProviderId;
	
	public ConstraintResourceRef() { }
	
	/**
	 * Constructor
	 * 
	 * @param idType The type of the identifier: "ResMgmt" (Resource-management-level identifier; this identifier is managed by the VIM in direct mode and is managed by the NFVO in indirect mode) or "Grant" (reference to identifier in the ResourceDefinition in the grant request).
	 * @param resourceId An actual resource-management-level identifier (idType=ResMgmt), or an identifier that references the ResourceDefinition in the grant request/response (idType=Grant).
	 * @param vimId Identifier of the VIM connection. It shall only be present when idType = ResMgmt.
	 * @param resourceProviderId Identifier of the resource provider. It shall only be present when idType = ResMgmt.
	 */
	public ConstraintResourceRef(GrantIdType idType,
			String resourceId,
			String vimId,
			String resourceProviderId) {
		this.idType = idType;
		this.resourceId = resourceId;
		this.vimId = vimId;
		this.resourceProviderId = resourceProviderId;
	}
	
	
	
	/**
	 * @return the idType
	 */
	public GrantIdType getIdType() {
		return idType;
	}

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
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
		if (resourceId == null) throw new MalformattedElementException("Constraint resource ref without resource ID");
	}

}
