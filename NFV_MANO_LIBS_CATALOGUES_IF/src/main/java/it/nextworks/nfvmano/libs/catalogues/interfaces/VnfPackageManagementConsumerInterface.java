package it.nextworks.nfvmano.libs.catalogues.interfaces;

import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.VnfPackageChangeNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.VnfPackageOnboardingNotification;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;

/**
 * Interface exposing the methods to notify the OSS/BSS about
 * changes of VNF packages sent by the NFVO.
 * It must be implemented by the plugins managing the interaction with 
 * external OSS/BSS entities.
 * It must be invoked by the core components of the NFVO.
 * 
 * REF IFA 013 v2.3.1 - 7.7.8
 * 
 * @author nextworks
 *
 */
public interface VnfPackageManagementConsumerInterface {

	/**
	 *  This method is used to notify the consumer
	 * of a change in an existing VNF package
	 * 
	 * @param notification VNF package change notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(VnfPackageChangeNotification notification) 
		throws MethodNotImplementedException;
	
	/**
	 *  This method is used to notify the consumer
	 * of a new VNF package on-boarding
	 * 
	 * @param notification VNF package on-boarding notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(VnfPackageOnboardingNotification notification)
			throws MethodNotImplementedException;
	
}
