package it.nextworks.nfvmano.libs.descriptors.appd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The LatencyDescriptor data type describes latency requirements for a ME application.
 * NOTE: The meaning of latency will be decided in stage 3 specification.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.2.1.14
 * 
 * @author nextworks
 *
 */
@Embeddable
public class LatencyDescriptor implements DescriptorInformationElement {

	private int timeUnit;
	private int latency;
	
	public LatencyDescriptor() {
		// JPA only
	}
	
	/**
	 * Constructor
	 *  
	 * @param timeUnit Time unit, e.g. ms
	 * @param latency The value of the latency
	 */
	public LatencyDescriptor(int timeUnit,
			int latency) {
		this.timeUnit = timeUnit;
		this.latency = latency;
	}
	
	
	
	/**
	 * @return the timeUnit
	 */
	@JsonProperty("timeUnit")
	public int getTimeUnit() {
		return timeUnit;
	}

	/**
	 * @return the latency
	 */
	@JsonProperty("latency")
	public int getLatency() {
		return latency;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
