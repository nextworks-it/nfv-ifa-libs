package it.nextworks.nfvmano.libs.descriptors.vnfd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VnfIndicator information element defines the indicator the VNF supports.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.11.2
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VnfIndicator implements DescriptorInformationElement {

	private String indicatorId;
	private String name;
	private String indicatorValue;
	private VnfIndicatorSource source;
	
	
	
	public VnfIndicator() {	}
	
	/**
	 * Construcotr
	 * 
	 * @param indicatorId Unique identifier.
	 * @param name The human readable name of the VnfIndicator.
	 * @param indicatorValue Defines the allowed values or value ranges of this indicator.
	 * @param source Describe the source of the indicator.
	 */
	public VnfIndicator(String indicatorId,
			String name,
			String indicatorValue,
			VnfIndicatorSource source) {
		this.indicatorId = indicatorId;
		this.name = name;
		this.indicatorValue = indicatorValue;
		this.source = source;
	}

	
	
	/**
	 * @return the indicatorId
	 */
	@JsonProperty("id")
	public String getIndicatorId() {
		return indicatorId;
	}

	/**
	 * @return the name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * @return the indicatorValue
	 */
	@JsonProperty("indicatorValue")
	public String getIndicatorValue() {
		return indicatorValue;
	}

	/**
	 * @return the source
	 */
	@JsonProperty("source")
	public VnfIndicatorSource getSource() {
		return source;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (indicatorId == null) throw new MalformattedElementException("VNF indicator without ID");
	}

}
