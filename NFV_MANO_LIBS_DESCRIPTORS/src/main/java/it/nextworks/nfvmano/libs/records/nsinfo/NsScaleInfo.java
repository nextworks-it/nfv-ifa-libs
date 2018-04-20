package it.nextworks.nfvmano.libs.records.nsinfo;

import javax.persistence.Embeddable;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Ref. IFA 013 v2.3.1 section 8.3.3.16
 * 
 * @author nextworks
 *
 */
@Embeddable
public class NsScaleInfo implements DescriptorInformationElement {

	private String nsScalingAspectId;
	private String nsScaleLevelId;
	
	public NsScaleInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsScalingAspectId Identifier of the NS scaling aspect.
	 * @param nsScaleLevelId Identifier of the NS scale level.
	 */
	public NsScaleInfo(String nsScalingAspectId,
			String nsScaleLevelId) {
		this.nsScalingAspectId = nsScalingAspectId;
		this.nsScaleLevelId = nsScaleLevelId;
	}
	
	

	/**
	 * @return the nsScalingAspectId
	 */
	public String getNsScalingAspectId() {
		return nsScalingAspectId;
	}

	/**
	 * @return the nsScaleLevelId
	 */
	public String getNsScaleLevelId() {
		return nsScaleLevelId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsScaleLevelId == null) throw new MalformattedElementException("NS scale info without scale level ID");
		if (nsScalingAspectId == null) throw new MalformattedElementException("NS scale info without scaling aspect ID");
	}

}