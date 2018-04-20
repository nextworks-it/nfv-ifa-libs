package it.nextworks.nfvmano.libs.descriptors.vnfd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The ScalingAspect information element describes the details of an aspect used for horizontal scaling.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.10.2
 * 
 * @author nextworks
 *
 */
@Embeddable
public class ScalingAspect implements DescriptorInformationElement {

	private String saId;
	private String saName;
	private String saDescription;
	private String associatedGroup;
	private int maxScaleLevel;
	
	public ScalingAspect() { }
	
	/**
	 * Constructor
	 * 
	 * @param saId Unique identifier of this aspect in the VNFD.
	 * @param saName Human readable name of the aspect.
	 * @param saDescription Human readable description of the aspect.
	 * @param associatedGroup Reference to the group of Vnfd elements defining this aspect.
	 * @param maxScaleLevel The maximum scaleLevel for total number of scaling steps that can be applied w.r.t. this aspect.
	 */
	public ScalingAspect(String saId,
			String saName,
			String saDescription,
			String associatedGroup,
			int maxScaleLevel) { 
		this.saDescription = saDescription;
		this.saId = saId;
		this.saName = saName;
		this.associatedGroup = associatedGroup;
		this.maxScaleLevel = maxScaleLevel;
	}

	
	
	/**
	 * @return the saId
	 */
	@JsonProperty("id")
	public String getSaId() {
		return saId;
	}

	/**
	 * @return the saName
	 */
	@JsonProperty("name")
	public String getSaName() {
		return saName;
	}

	/**
	 * @return the saDescription
	 */
	@JsonProperty("description")
	public String getSaDescription() {
		return saDescription;
	}

	/**
	 * @return the associatedGroup
	 */
	@JsonProperty("associatedGroup")
	public String getAssociatedGroup() {
		return associatedGroup;
	}

	/**
	 * @return the maxScaleLevel
	 */
	@JsonProperty("maxScaleLevel")
	public int getMaxScaleLevel() {
		return maxScaleLevel;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (saId == null) throw new MalformattedElementException("Scaling aspect without ID");
		if (saName == null) throw new MalformattedElementException("Scaling aspect without name");
		if (saDescription == null) throw new MalformattedElementException("Scaling aspect without description");
	}

}
