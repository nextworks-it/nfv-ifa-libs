package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * A virtual interface represents the data of a virtual network interface specific 
 * to a Virtual Compute Resource instance.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.4.3.7
 * 
 * @author nextworks
 *
 */
public class VirtualInterfaceData implements InterfaceInformationElement {
	
	private List<String> ipAddress = new ArrayList<>();
	private String macAddress;

	public VirtualInterfaceData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param ipAddress The virtual network interface can be configured with specific IP address(es) associated to the network to be attached to. The cardinality can be 0 in the case that a network interface is created without being attached to any specific network, or when an IP address can be automatically configured, e.g. by DHCP.
	 * @param macAddress The MAC address desired for the virtual network interface. The cardinality can be 0 to allow for network interface without specific MAC address configuration.
	 */
	public VirtualInterfaceData(List<String> ipAddress,
			String macAddress) {	
		if (ipAddress != null) this.ipAddress = ipAddress;
		this.macAddress = macAddress;
	}
	
	

	/**
	 * @return the ipAddress
	 */
	public List<String> getIpAddress() {
		return ipAddress;
	}

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
