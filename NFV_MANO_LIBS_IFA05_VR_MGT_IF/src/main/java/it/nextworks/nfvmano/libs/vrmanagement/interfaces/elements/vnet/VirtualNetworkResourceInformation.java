package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.NetworkSegmentType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines the characteristics of consumable virtualised compute resources.
 * 
 * REF IFA 005 v2.3.1 - 8.3.5
 * 
 * @author nextworks
 *
 */
public class VirtualNetworkResourceInformation implements InterfaceInformationElement {

	private String networkResourceTypeId;
	private int bandwidth;
	private NetworkSegmentType networkType;
	private List<NetworkQoS> networkQoS = new ArrayList<>();
	
	public VirtualNetworkResourceInformation() { }

	/**
	 * Constructor
	 * 
	 * @param networkResourceTypeId Identifier of the network resource type.
	 * @param bandwidth Minimum network bandwidth (in Mbps).
	 * @param networkType The type of network that maps to the virtualised network.
	 * @param networkQoS Element providing information about Quality of Service attributes that the network shall support.
	 */
	public VirtualNetworkResourceInformation(String networkResourceTypeId,
			int bandwidth,
			NetworkSegmentType networkType,
			List<NetworkQoS> networkQoS) { 
		this.networkResourceTypeId = networkResourceTypeId;
		this.bandwidth = bandwidth;
		this.networkType = networkType;
		if (networkQoS != null) this.networkQoS = networkQoS;
	}
	
	

	/**
	 * @return the networkResourceTypeId
	 */
	public String getNetworkResourceTypeId() {
		return networkResourceTypeId;
	}

	/**
	 * @return the bandwidth
	 */
	public int getBandwidth() {
		return bandwidth;
	}

	/**
	 * @return the networkType
	 */
	public NetworkSegmentType getNetworkType() {
		return networkType;
	}

	/**
	 * @return the networkQoS
	 */
	public List<NetworkQoS> getNetworkQoS() {
		return networkQoS;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (networkResourceTypeId == null) throw new MalformattedElementException("Virtual Network resource information without resource type ID.");
		for (NetworkQoS qos : networkQoS) {
			qos.isValid();
		}
	}

}
