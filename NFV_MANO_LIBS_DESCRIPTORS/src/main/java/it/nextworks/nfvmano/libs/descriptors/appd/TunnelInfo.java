package it.nextworks.nfvmano.libs.descriptors.appd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.TunnelType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The TunnelInfo data type supports the specification of ME application requirements related to traffic rules.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.2.1.12
 * 
 * @author nextworks
 *
 */
@Embeddable
public class TunnelInfo implements DescriptorInformationElement {

	private TunnelType tunnelType;
	
	private String tunnelDstAddress;
	
	private String tunnelSrcAddress;
	
	private String tunnelSpecificData;
	
	public TunnelInfo() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param tunnelType Type of tunnel
	 * @param tunnelDstAddress Destination address of the tunnel
	 * @param tunnelSrcAddress Source address of the tunnel 
	 * @param tunnelSpecificData Parameters specific to the tunnel
	 */
	public TunnelInfo(TunnelType tunnelType,
			String tunnelDstAddress,
			String tunnelSrcAddress,
			String tunnelSpecificData) {
		this.tunnelType = tunnelType;
		this.tunnelDstAddress = tunnelDstAddress;
		this.tunnelSrcAddress = tunnelSrcAddress;
		this.tunnelSpecificData = tunnelSpecificData;
	}
	
	
	
	/**
	 * @return the tunnelType
	 */
	@JsonProperty("tunnelType")
	public TunnelType getTunnelType() {
		return tunnelType;
	}

	/**
	 * @return the tunnelDstAddress
	 */
	@JsonProperty("tunnelDstAddress")
	public String getTunnelDstAddress() {
		return tunnelDstAddress;
	}

	/**
	 * @return the tunnelSrcAddress
	 */
	@JsonProperty("tunnelSrcAddress")
	public String getTunnelSrcAddress() {
		return tunnelSrcAddress;
	}

	/**
	 * @return the tunnelSpecificData
	 */
	@JsonProperty("tunnelSpecificData")
	public String getTunnelSpecificData() {
		return tunnelSpecificData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (tunnelDstAddress == null) throw new MalformattedElementException("Tunnel info without dst address");
		if (tunnelSrcAddress == null) throw new MalformattedElementException("Tunnel info without src address");
	}

}
