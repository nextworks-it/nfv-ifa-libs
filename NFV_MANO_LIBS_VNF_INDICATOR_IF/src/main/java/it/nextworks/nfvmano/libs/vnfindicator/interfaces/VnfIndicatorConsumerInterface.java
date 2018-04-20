package it.nextworks.nfvmano.libs.vnfindicator.interfaces;

import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.IndicatorValueChangeNotification;


/**
 * Interface exposing the methods to notify the VNFM (IFA 008)
 * or the NFVO (IFA 007) about changes of a VNF indicators.
 * 
 * It must be implemented by the VNFM (IFA 008) or the NFVO (IFA 007) 
 * to process the VNF indicators.
 * 
 * It must be invoked by the plug-ins implementing the actual 
 * interaction with the VNF (IFA 008) or the EM (IFA 008) or 
 * the VNFM (IFA 007) to send the notifications about VNF 
 * indicator changes.
 * 
 * REF IFA 007 v2.3.1 - 7.7.5
 * 
 * @author nextworks
 *
 */
public interface VnfIndicatorConsumerInterface {

	/**
	 * This method is used to notify 
	 * the receiver of a value change 
	 * of an indicator related to the VNF.
	 * 
	 * REF IFA 007 v2.3.1 - 7.7.5
	 * 
	 * @param notification 
	 */
	public void notify(IndicatorValueChangeNotification notification)
			throws MethodNotImplementedException;
	
}
