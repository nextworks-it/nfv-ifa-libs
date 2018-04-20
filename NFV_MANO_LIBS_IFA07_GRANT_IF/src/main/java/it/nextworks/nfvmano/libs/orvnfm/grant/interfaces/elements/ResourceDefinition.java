package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information 
 * of an existing or proposed resource used by the VNF.
 * 
 * REF IFA 007 v2.3.1 - 8.3.2
 * 
 * @author nextworks
 *
 */
public class ResourceDefinition implements InterfaceInformationElement {

	private String resourceDefinitionId;
	private VimResourceType type;
	private String vduId;
	private String resourceTemplateId;
	private ResourceHandle resourceHandle;
	
	public ResourceDefinition() { }
	
	/**
	 * Constructor
	 * 
	 * @param resourceDefinitionId Identifier of this ResourceDefinition information element, unique at least within the scope of the grant request.
	 * @param type Type of the resource definition referenced
	 * @param vduId Reference to the related Vdu applicable to this resource in the VNFD.
	 * @param resourceTemplateId Reference to a resource template (VnfVirtualLinkDesc, VirtualComputeDesc, VnfExtCpd, VirtualStorageDesc) in the VNFD.
	 * @param resourceHandle Resource information for an existing resource. Shall be present for resources that are planned to be deleted or modified. Shall be absent otherwise.
	 */
	public ResourceDefinition(String resourceDefinitionId,
			VimResourceType type,
			String vduId,
			String resourceTemplateId,
			ResourceHandle resourceHandle) { 
		this.resourceDefinitionId = resourceDefinitionId;
		this.type = type;
		this.vduId = vduId;
		this.resourceTemplateId = resourceTemplateId;
		this.resourceHandle = resourceHandle;
	}
	
	

	/**
	 * @return the resourceDefinitionId
	 */
	public String getResourceDefinitionId() {
		return resourceDefinitionId;
	}

	/**
	 * @return the type
	 */
	public VimResourceType getType() {
		return type;
	}

	/**
	 * @return the vduId
	 */
	public String getVduId() {
		return vduId;
	}

	/**
	 * @return the resourceTemplateId
	 */
	public String getResourceTemplateId() {
		return resourceTemplateId;
	}

	/**
	 * @return the resourceHandle
	 */
	public ResourceHandle getResourceHandle() {
		return resourceHandle;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (resourceDefinitionId == null) throw new MalformattedElementException("Resource definition without ID");
		if (resourceHandle != null) resourceHandle.isValid();
	}

}
