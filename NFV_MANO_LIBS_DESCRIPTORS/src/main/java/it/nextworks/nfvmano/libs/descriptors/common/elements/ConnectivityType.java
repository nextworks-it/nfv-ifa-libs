package it.nextworks.nfvmano.libs.descriptors.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The ConnectivityType information element specifies 
 * the protocol exposed by a VL and the flow pattern supported by the VL.
 * 
 * Ref. IFA 014 v2.3.1 - 6.5.3
 * Ref. IFA 013 v2.3.1 - 7.1.7.3
 * 
 * @author nextworks
 *
 */
@Embeddable
public class ConnectivityType implements DescriptorInformationElement {

	private LayerProtocol layerProtocol;
	private String flowPattern;
	
	public ConnectivityType() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param layerProtocol identifies the protocol that the VL supports
	 * @param flowPattern Identifies the flow pattern of the connectivity (Line, Tree, Mesh, etc.).
	 */
	public ConnectivityType(LayerProtocol layerProtocol,
			String flowPattern) {
		this.layerProtocol = layerProtocol;
		this.flowPattern = flowPattern;
	}

	
	
	/**
	 * @return the layerProtocol
	 */
	@JsonProperty("layerProtocol")
	public LayerProtocol getLayerProtocol() {
		return layerProtocol;
	}

	/**
	 * @return the flowPattern
	 */
	@JsonProperty("flowPattern")
	public String getFlowPattern() {
		return flowPattern;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
