package it.nextworks.nfvmano.libs.descriptors.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines attributes that affect 
 * the invocation of the OperateVnf operation.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.5.7
 * 
 * 
 * @author nextworks
 *
 */
@Embeddable
public class TerminateVnfOpConfig implements DescriptorInformationElement {

	private String minGracefulStopTimeout;
	private String maxRecommendedGracefulStopTimeout;
	
	public TerminateVnfOpConfig() { }

	/**
	 * Constructor
	 * 
	 * @param minGracefulStopTimeout Minimum timeout value for graceful stop of a VNF instance.
	 * @param maxRecommendedGracefulStopTimeout Maximum recommended timeout value that can be needed to gracefully stop a VNF instance
	 */
	public TerminateVnfOpConfig(String minGracefulStopTimeout,
			String maxRecommendedGracefulStopTimeout) { 
		this.maxRecommendedGracefulStopTimeout = maxRecommendedGracefulStopTimeout;
		this.minGracefulStopTimeout = minGracefulStopTimeout;
	}
	
	/**
	 * @return the minGracefulStopTimeout
	 */
	@JsonProperty("minGracefulStopTimeout")
	public String getMinGracefulStopTimeout() {
		return minGracefulStopTimeout;
	}

	/**
	 * @return the maxRecommendedGracefulStopTimeout
	 */
	@JsonProperty("maxRecommendedGracefulStopTimeout")
	public String getMaxRecommendedGracefulStopTimeout() {
		return maxRecommendedGracefulStopTimeout;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (minGracefulStopTimeout == null) throw new MalformattedElementException("Operate VNF config data without minimum graceful stop timeout");
	}

}
