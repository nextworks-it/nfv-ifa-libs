package it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides the indicator values of a VNF instance.
 * 
 * REF IFA 007 v2.3.1 - 8.10.3
 * 
 * @author nextworks
 *
 */
public class IndicatorInformation implements InterfaceInformationElement {

	private String vnfInstanceId;
	private String indicatorId;
	private String indicatorValue;
	private String indicatorName;
	
	public IndicatorInformation() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId		Identifies the VNF instance which provides the indicator value(s).
	 * @param indicatorId		Identifier of the indicator.
	 * @param indicatorValue	Provides the value of the indicator.
	 * @param indicatorName		Human readable name of the indicator.
	 */
	public IndicatorInformation(String vnfInstanceId,
			String indicatorId,
			String indicatorValue,
			String indicatorName) {
		this.vnfInstanceId = vnfInstanceId;
		this.indicatorId = indicatorId;
		this.indicatorValue = indicatorValue;
		this.indicatorName = indicatorName;
	}

	/**
	 * 
	 * @return the ID of the VNF instance which provides the indicator value(s). 
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * 
	 * @return the identifier of the indicator.
	 */
	public String getIndicatorId() {
		return indicatorId;
	}

	/**
	 * 
	 * @return the value of the indicator.
	 */
	public String getIndicatorValue() {
		return indicatorValue;
	}

	/**
	 * 
	 * @return the human readable name of the indicator.
	 */
	public String getIndicatorName() {
		return indicatorName;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Indicator information without VNF instance ID");
		if (indicatorId == null) throw new MalformattedElementException("Indicator information without indicator ID");
		if (indicatorValue == null) throw new MalformattedElementException("Indicator information without indicator value");
	}
}
