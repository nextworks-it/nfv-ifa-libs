package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.enums.VnfVirtualLinkChangeType;

/**
 * This information element provides information about added, deleted, 
 * modified and temporary VLs, as well as about link port changes.
 * 
 * REF IFA 007 v2.3.1 - 8.6.4
 * 
 * @author nextworks
 *
 */
public class AffectedVirtualLink implements InterfaceInformationElement {

	private String virtualLinkInstanceId;
	private String virtualLinkDescId;
	private VnfVirtualLinkChangeType changeType;
	private ResourceHandle networkResource;
	
	public AffectedVirtualLink() { }
	
	/**
	 * Constructor
	 * 
	 * @param virtualLinkInstanceId Identifier of the VL instance.
	 * @param virtualLinkDescId Identifier of the VLD in the VNFD.
	 * @param changeType Signals the type of change
	 * @param networkResource Reference to the VirtualNetwork resource. Detailed information is (for new and modified resources) or has been (for removed resources) available from the Virtualised Network Resource Management interface.
	 */
	public AffectedVirtualLink(String virtualLinkInstanceId,
			String virtualLinkDescId,
			VnfVirtualLinkChangeType changeType,
			ResourceHandle networkResource) {
		this.virtualLinkInstanceId = virtualLinkInstanceId;
		this.virtualLinkDescId = virtualLinkDescId;
		this.changeType = changeType;
		this.networkResource = networkResource;
	}

	
	
	/**
	 * @return the virtualLinkInstanceId
	 */
	public String getVirtualLinkInstanceId() {
		return virtualLinkInstanceId;
	}

	/**
	 * @return the virtualLinkDescId
	 */
	public String getVirtualLinkDescId() {
		return virtualLinkDescId;
	}

	/**
	 * @return the changeType
	 */
	public VnfVirtualLinkChangeType getChangeType() {
		return changeType;
	}

	/**
	 * @return the networkResource
	 */
	public ResourceHandle getNetworkResource() {
		return networkResource;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (virtualLinkInstanceId == null) throw new MalformattedElementException("Affected virtual link without VL instance ID");
		if (virtualLinkDescId == null) throw new MalformattedElementException("Affected virtual link without VLD ID");
		if (networkResource == null) throw new MalformattedElementException("Affected virtual link without network resource");
		else networkResource.isValid();
	}

}
