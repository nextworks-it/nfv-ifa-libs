package it.nextworks.nfvmano.libs.descriptors.appd;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.NetworkInterfaceType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The InterfaceDescriptor data type describes an interface of a ME application.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.2.1.11
 * 
 * @author nextworks
 *
 */
@Entity
public class MeAppInterfaceDescriptor implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private TrafficRuleDescriptor trd;
	
	private NetworkInterfaceType interfaceType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Embedded
	private TunnelInfo tunnelInfo;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String srcMACAddress;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String dstMACAddress;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String dstIPAddress;
	
	public MeAppInterfaceDescriptor() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param trd Traffic rule descriptor this element belongs to 
	 * @param interfaceType Type of interface:
	 * @param tunnelInfo Included only if the destination address type is tunnel.
	 * @param srcMACAddress If the interface type is MAC, the source address identifies the MAC address of the interface.
	 * @param dstMACAddress If the interface type is MAC, the destination address identifies the MAC address of the destination. Only used for dstInterface.
	 * @param dstIPAddress If the interface type is IP, the destination address identifies the IP address of the destination. Only used for dstInterface.
	 */
	public MeAppInterfaceDescriptor(TrafficRuleDescriptor trd,
			NetworkInterfaceType interfaceType,
			TunnelInfo tunnelInfo,
			String srcMACAddress,
			String dstMACAddress,
			String dstIPAddress) {
		this.trd = trd;
		this.interfaceType = interfaceType;
		this.tunnelInfo = tunnelInfo;
		this.srcMACAddress = srcMACAddress;
		this.dstMACAddress = dstMACAddress;
		this.dstIPAddress = dstIPAddress;
	}
	
	
	
	/**
	 * @return the interfaceType
	 */
	@JsonProperty("interfaceType")
	public NetworkInterfaceType getInterfaceType() {
		return interfaceType;
	}

	/**
	 * @return the tunnelInfo
	 */
	@JsonProperty("tunnelInfo")
	public TunnelInfo getTunnelInfo() {
		return tunnelInfo;
	}

	/**
	 * @return the srcMACAddress
	 */
	@JsonProperty("srcMACAddress")
	public String getSrcMACAddress() {
		return srcMACAddress;
	}

	/**
	 * @return the dstMACAddress
	 */
	@JsonProperty("dstMACAddress")
	public String getDstMACAddress() {
		return dstMACAddress;
	}

	/**
	 * @return the dstIPAddress
	 */
	@JsonProperty("dstIPAddress")
	public String getDstIPAddress() {
		return dstIPAddress;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (tunnelInfo != null) tunnelInfo.isValid();
	}

}
