package it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;


/**
 * Message sent to the VNFM (IFA008) or to the NFVO (IFA007) 
 * in reply to a request for a VNF indicator
 * 
 * REF IFA 007 v2.3.1 - 7.7.4
 * 
 * @author nextworks
 *
 */
public class GetIndicatorValueResponse implements InterfaceMessage {
	
	private List<IndicatorInformation> indicatorInformation = new ArrayList<>();
	
	public GetIndicatorValueResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param indicatorInformation  indicator values
	 */
	public GetIndicatorValueResponse(List<IndicatorInformation> indicatorInformation) {
		if (indicatorInformation != null) this.indicatorInformation = indicatorInformation;
	}

	/**
	 * 
	 * @return the list of requested indicators
	 */
	public List<IndicatorInformation> getIndicatorInformation() {
		return indicatorInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (IndicatorInformation ii : indicatorInformation) ii.isValid();
	}
	
}
