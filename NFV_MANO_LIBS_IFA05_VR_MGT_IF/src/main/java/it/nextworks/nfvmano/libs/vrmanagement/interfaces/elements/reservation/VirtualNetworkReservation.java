package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.8.4.3
 * 
 * @author nextworks
 *
 */
public class VirtualNetworkReservation implements InterfaceInformationElement {

	private int numPublicIps;
	private VirtualNetworkAttributesReservationData networkAttributes;
	private List<VirtualNetworkPortReservationData> networkPorts = new ArrayList<>(); 
	
	public VirtualNetworkReservation() { }
	
	/**
	 * Constructor
	 * 
	 * @param numPublicIps Number of public IP addresses to be reserved.
	 * @param networkAttributes Information specifying additional attributes of the network resource to be reserved
	 * @param networkPorts List of specific network ports to be reserved
	 */
	public VirtualNetworkReservation(int numPublicIps,
			VirtualNetworkAttributesReservationData networkAttributes,
			List<VirtualNetworkPortReservationData> networkPorts) {
		this.numPublicIps = numPublicIps;
		this.networkAttributes = networkAttributes;
		if (networkPorts != null) this.networkPorts = networkPorts;
	}

	
	
	/**
	 * @return the numPublicIps
	 */
	public int getNumPublicIps() {
		return numPublicIps;
	}

	/**
	 * @return the networkAttributes
	 */
	public VirtualNetworkAttributesReservationData getNetworkAttributes() {
		return networkAttributes;
	}

	/**
	 * @return the networkPorts
	 */
	public List<VirtualNetworkPortReservationData> getNetworkPorts() {
		return networkPorts;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (networkAttributes != null) networkAttributes.isValid();
		for (VirtualNetworkPortReservationData vnprd : networkPorts) vnprd.isValid();
	}

}
