package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.8.4.5
 * 
 * @author nextworks
 *
 */
public class VirtualNetworkPortReservationData implements InterfaceInformationElement {

	private String portId;
	private String portType;
	private String segmentId;
	private int bandwidth;
	private Map<String, String> metadata = new HashMap<>();
	
	public VirtualNetworkPortReservationData() { }
	
	/**
	 * Constructor
	 * 
	 * @param portId Identifier of the network port to reserve.
	 * @param portType Type of network port.
	 * @param segmentId The isolated segment the network port belongs to.
	 * @param bandwidth The bitrate of the virtual network port (in Mbps).
	 * @param metadata List of metadata key-value pairs used by the consumer to associate meaningful metadata to the related virtualised resource.
	 */
	public VirtualNetworkPortReservationData(String portId,
			String portType,
			String segmentId,
			int bandwidth,
			Map<String, String> metadata) {
		this.portId = portId;
		this.portType = portType;
		this.segmentId = segmentId;
		this.bandwidth = bandwidth;
		if (metadata != null) this.metadata = metadata;
	}
	
	

	/**
	 * @return the portId
	 */
	public String getPortId() {
		return portId;
	}

	/**
	 * @return the portType
	 */
	public String getPortType() {
		return portType;
	}

	/**
	 * @return the segmentId
	 */
	public String getSegmentId() {
		return segmentId;
	}

	/**
	 * @return the bandwidth
	 */
	public int getBandwidth() {
		return bandwidth;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (portId == null) throw new MalformattedElementException("Virtual network port reservation data without port ID");
		if (portType == null) throw new MalformattedElementException("Virtual network port reservation data without port type");
	}

}
