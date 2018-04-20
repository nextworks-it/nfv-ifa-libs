package it.nextworks.nfvmano.libs.catalogues.interfaces;

import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.AppPackageOnBoardingNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.AppPackageStateChangeNotification;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;

/**
 * Interface exposing the methods to notify the MEPM about
 * changes of App packages sent by the MEO.
 * It must be implemented by the plugins managing the interaction with 
 * MEO's external entities.
 * It must be invoked by the core components of the MEO.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.4
 * 
 * @author nextworks
 *
 */
public interface MecAppPackageManagementConsumerInterface {

	/**
	 * Method to notify the on-boarding of a new app package.
	 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.4 
	 * 
	 * @param notification notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(AppPackageOnBoardingNotification notification)
			throws MethodNotImplementedException;
	
	/**
	 * Method to notify a change in the status of an app package.
	 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.4
	 * 
	 * @param notification notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(AppPackageStateChangeNotification notification)
			throws MethodNotImplementedException;
}
