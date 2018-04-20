package it.nextworks.nfvmano.libs.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The ScaleInfo information element represents a scale level for a particular scaling aspect.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.8.8
 * 
 * @author nextworks
 *
 */
@Embeddable
public class ScaleInfo implements DescriptorInformationElement {

	private String aspectId;
	private int scaleLevel;
	
	public ScaleInfo() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param aspectId Identifier of the scaling aspect.
	 * @param scaleLevel The scale level, greater than or equal to 0.
	 */
	public ScaleInfo(String aspectId,
			int scaleLevel) {
		this.aspectId = aspectId;
		this.scaleLevel = scaleLevel;
	}
	
	

	/**
	 * @return the aspectId
	 */
	@JsonProperty("aspectId")
	public String getAspectId() {
		return aspectId;
	}

	/**
	 * @return the scaleLevel
	 */
	@JsonProperty("scaleLevel")
	public int getScaleLevel() {
		return scaleLevel;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (aspectId == null) throw new MalformattedElementException("Scale info without aspect ID");
	}

}
