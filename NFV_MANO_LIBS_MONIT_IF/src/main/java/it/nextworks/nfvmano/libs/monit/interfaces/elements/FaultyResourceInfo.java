package it.nextworks.nfvmano.libs.monit.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.enums.VirtualResourceType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The FaultyResourceInfo information element encapsulates information 
 * about faulty resource that has a negative impact on a VNF.
 * 
 * REF IFA 007 v2.3.1 - 8.8.5
 * 
 * @author nextworks
 *
 */
public class FaultyResourceInfo implements InterfaceInformationElement {

	private ResourceHandle faultyResource;
	private VirtualResourceType faultyResourceType;
	
	public FaultyResourceInfo() { }
	
	/**
	 * Constructor
	 * 
	 * @param faultyResource Information that identifies the faulty resource instance and its managing entity.
	 * @param faultResourceType Type of the faulty resource.
	 */
	public FaultyResourceInfo(ResourceHandle faultyResource,
			VirtualResourceType faultResourceType) { 
		this.faultyResource = faultyResource;
		this.faultyResourceType = faultResourceType;
	}
	
	

	/**
	 * @return the faultyResource
	 */
	public ResourceHandle getFaultyResource() {
		return faultyResource;
	}

	/**
	 * @return the faultyResourceType
	 */
	public VirtualResourceType getFaultyResourceType() {
		return faultyResourceType;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (faultyResource == null) throw new MalformattedElementException("Faulty resource info without resource handle");
		else faultyResource.isValid();
	}

}
