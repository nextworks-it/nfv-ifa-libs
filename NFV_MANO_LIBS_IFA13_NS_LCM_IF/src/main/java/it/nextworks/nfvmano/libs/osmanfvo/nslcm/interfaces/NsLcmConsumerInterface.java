package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces;

import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.NsIdentifierCreationNotification;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.NsIdentifierDeletionNotification;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.NsLifecycleChangeNotification;

/**
 * Interface with methods to distribute to subscribers notifications about NS lifecycle changes, 
 * as well as the creation/deletion of NS instance identifiers and the associated NsInfo information element instances. 
 * It is a one-way operation issued by the producer (NFVO) that cannot be invoked as an operation by the consumer (OSS/BSS). 
 * In order to receive notifications, the consumer (OSS/BSS) has to perform an explicit Subscribe operation beforehand.
 * 
 * It must be implemented by the plugins managing the interaction with external OSS/BSS entities.
 * It must be invoked by the core components of the NFVO.
 * 
 * REF IFA 013 v2.3.1 - 7.3.12
 * 
 * @author nextworks
 *
 */
public interface NsLcmConsumerInterface {
	
	/**
	 * This method informs the receiver of changes in the NS lifecycle.
	 * REF IFA 013 v2.3.1 - 8.3.2.2
	 * 
	 * @param notification notification about a change in the NS lifecycle
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notifyNsLifecycleChange(NsLifecycleChangeNotification notification) throws MethodNotImplementedException;
	
	/**
	 * This method informs the receiver of the creation of a new NS instance identifier 
	 * and of the associated instance of an NsInfo information element, identified by that identifier.
	 * REF IFA 013 v2.3.1 - 8.3.2.9
	 * 
	 * @param notification notification about the creation of a new NS ID
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notifyNsIdentifierCreation(NsIdentifierCreationNotification notification) throws MethodNotImplementedException;
	
	/**
	 * This method informs the receiver of the deletion of an NS instance identifier 
	 * and of the associated instance of an NsInfo information element identified by that identifier.
	 * REF IFA 013 v2.3.1 - 8.3.2.10
	 * 
	 * @param notification notification about the deletion of an existing NS ID
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notifyNsIdentifierObjectDeletion(NsIdentifierDeletionNotification notification) throws MethodNotImplementedException;

}
