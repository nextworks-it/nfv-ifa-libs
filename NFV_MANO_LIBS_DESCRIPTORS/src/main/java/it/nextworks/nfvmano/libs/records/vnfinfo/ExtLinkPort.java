package it.nextworks.nfvmano.libs.records.vnfinfo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information about a port of an external VL, 
 * i.e. a port providing connectivity for the VNF to an NS VL.
 * 
 * REF IFA 007 v2.3.1 - 8.5.13
 * 
 * @author nextworks
 *
 */
@Entity
public class ExtLinkPort implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private ExtVirtualLinkInfo extVlInfo;
	
	private String extLinkPortId;
	
	@Embedded
	private ResourceHandle resourceHandle;
	
	private String cpInstanceId;
	
	public ExtLinkPort() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param extVlInfo External VL info this VNF link port belongs to
	 * @param extLinkPortId Identifier of this link port as provided by the entity that has created the link port.
	 * @param resourceHandle Identifier of the virtualised network resource realizing this link port.
	 * @param cpInstanceId External CP of the VNF to be connected to this link port.
	 */
	public ExtLinkPort(ExtVirtualLinkInfo extVlInfo,
			String extLinkPortId,
			ResourceHandle resourceHandle,
			String cpInstanceId) {
		this.extVlInfo = extVlInfo;
		this.extLinkPortId = extLinkPortId;
		this.resourceHandle = resourceHandle;
		this.cpInstanceId = cpInstanceId;
	}
	
	
	/**
	 * @return the resourceHandle
	 */
	public ResourceHandle getResourceHandle() {
		return resourceHandle;
	}
	
	

	/**
	 * @return the extLinkPortId
	 */
	public String getExtLinkPortId() {
		return extLinkPortId;
	}

	/**
	 * @return the cpInstanceId
	 */
	public String getCpInstanceId() {
		return cpInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (extLinkPortId == null) throw new MalformattedElementException("External link port without ID");
		if (resourceHandle == null) throw new MalformattedElementException("VNF link port without resource handle");
		else resourceHandle.isValid();
	}

}
