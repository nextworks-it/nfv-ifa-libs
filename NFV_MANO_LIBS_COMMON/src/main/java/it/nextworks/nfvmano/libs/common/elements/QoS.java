package it.nextworks.nfvmano.libs.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The QoS information element specifies quality of 
 * service parameters applicable to a VL.
 * 
 * Ref. IFA 014 v2.3.1 - 6.5.6
 * 
 * @author nextworks
 *
 */
@Embeddable
public class QoS implements DescriptorInformationElement {

	private int latency;
	private int packetDelayVariation;
	private int packetLossRatio;
	private int priority;
	
	public QoS() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param latency maximum latency in ms.
	 * @param packetDelayVariation maximum jitter in ms.
	 * @param packetLossRatio maximum packet loss ratio.
	 * @param priority priority level in case of congestion on the underlying physical links.
	 */
	public QoS(int latency,
			int packetDelayVariation,
			int packetLossRatio,
			int priority) {
		this.latency = latency;
		this.packetDelayVariation = packetDelayVariation;
		this.packetLossRatio = packetLossRatio;
		this.priority = priority;
	}
	
	

	/**
	 * @return the latency
	 */
	@JsonProperty("latency")
	public int getLatency() {
		return latency;
	}

	/**
	 * @return the packetDelayVariation
	 */
	@JsonProperty("packetDelayVariation")
	public int getPacketDelayVariation() {
		return packetDelayVariation;
	}

	/**
	 * @return the packetLossRatio
	 */
	@JsonProperty("packetLossRatio")
	public int getPacketLossRatio() {
		return packetLossRatio;
	}

	/**
	 * @return the priority
	 */
	@JsonProperty("priority")
	public int getPriority() {
		return priority;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
