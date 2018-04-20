package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.NetworkSegmentType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * REF IFA 005 v2.3.1 - 8.8.4.4
 * 
 * @author nextworks
 *
 */
public class VirtualNetworkAttributesReservationData implements InterfaceInformationElement {

	private int bandwidth;
	private NetworkSegmentType networkType;
	private String segmentType;
	private boolean isShared;
	private Map<String, String> metadata = new HashMap<>();
	
	public VirtualNetworkAttributesReservationData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param bandwidth Minimum network bitrate (in Mbps).
	 * @param networkType The type of network that maps to the virtualised network to be reserved
	 * @param segmentType The isolated segment for the virtualised network to be reserved.
	 * @param isShared It defines whether the virtualised network to be reserved is shared among consumers.
	 * @param metadata List of metadata key-value pairs used by the consumer to associate meaningful metadata to the related virtualised resource.
	 */
	public VirtualNetworkAttributesReservationData(int bandwidth,
			NetworkSegmentType networkType,
			String segmentType,
			boolean isShared,
			Map<String, String> metadata) {
		this.bandwidth = bandwidth;
		this.networkType = networkType;
		this.segmentType = segmentType;
		this.isShared = isShared;
		if (metadata != null) this.metadata = metadata;
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
	 * @return the segmentType
	 */
	public String getSegmentType() {
		return segmentType;
	}

	/**
	 * @return the isShared
	 */
	public boolean isShared() {
		return isShared;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
