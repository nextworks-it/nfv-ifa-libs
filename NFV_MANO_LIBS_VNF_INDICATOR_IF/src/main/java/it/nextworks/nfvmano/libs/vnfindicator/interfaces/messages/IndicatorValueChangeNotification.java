package it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;

/**
 * This notification informs the receiver 
 * of a value change of an indicator related to the VNF.
 * 
 * REF IFA 007 v2.3.1 - 7.7.5 - 8.10.2
 * 
 * @author nextworks
 *
 */
public class IndicatorValueChangeNotification implements InterfaceMessage {

	private IndicatorInformation indicatorInformation;

	public IndicatorValueChangeNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param indicatorInformation information about the indicator that has changed
	 */
	public IndicatorValueChangeNotification(IndicatorInformation indicatorInformation) {
		this.indicatorInformation = indicatorInformation;
	}

	/**
	 * 
	 * @return the information about the indicator that has changed
	 */
	public IndicatorInformation getIndicatorInformation() {
		return indicatorInformation;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (indicatorInformation == null) throw new MalformattedElementException("Indicator value change notification without indicator");
		else indicatorInformation.isValid();
	}
	
}
