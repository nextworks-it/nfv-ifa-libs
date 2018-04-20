package it.nextworks.nfvmano.libs.catalogues.interfaces;

import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.NsdChangeNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.NsdOnBoardingNotification;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;

/**
 * Interface exposing the methods to notify the OSS/BSS about
 * changes of NSD sent by the NFVO.
 * It must be implemented by the plugins managing the interaction with 
 * external OSS/BSS entities.
 * It must be invoked by the core components of the NFVO.
 * 
 * REF IFA 013 v2.3.1 - 7.2.13
 * 
 * @author nextworks
 *
 */
public interface NsdManagementConsumerInterface {

	/**
	 * This method is used to notify the consumer
	 * of a new NSD on-boarding
	 * 
	 * @param notification NSD on-boarding notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(NsdOnBoardingNotification notification)
			throws MethodNotImplementedException;
	
	/**
	 * This method is used to notify the consumer
	 * of an update in an existing NSD
	 * 
	 * @param notification NSD change notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(NsdChangeNotification notification)
			throws MethodNotImplementedException;
}
