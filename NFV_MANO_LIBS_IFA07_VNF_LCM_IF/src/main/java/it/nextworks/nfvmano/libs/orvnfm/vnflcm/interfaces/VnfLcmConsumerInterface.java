package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces;

import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.VnfIdentifierCreationNotification;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.VnfIdentifierDeletionNotification;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.VnfLcmOperationOccurrenceNotification;

/**
 * This interface allows to notify a subscriber about events related to VNF lifecycle operation occurrences, 
 * as well as creation/deletion of VNF instance identifiers and the associated VnfInfo information element instances.
 * 
 * This operation distributes notifications to subscribers. 
 * It is a one-way operation issued by the producer (VNFM) that cannot be invoked as an operation by the consumer (NFVO). 
 * In order to receive notifications, the consumer (NFVO) has to perform an explicit Subscribe operation beforehand.
 * 
 * This interface must be implemented by the NFVO and invoked by a VNFM.
 * 
 * REF IFA 007 v2.3.1 - 7.2.15
 * 
 * @author nextworks
 *
 */
public interface VnfLcmConsumerInterface {

	/**
	 * This notification informs the receiver of changes in the VNF lifecycle 
	 * caused by VNF lifecycle management operation occurrences.
	 * 
	 * REF IFA 007 v2.3.1 - 8.6.2
	 * 
	 * @param notification notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(VnfLcmOperationOccurrenceNotification notification) throws MethodNotImplementedException;
	
	/**
	 * This notification informs the receiver of the creation of a 
	 * new VNF instance identifier and the associated instance of a
	 * VnfInfo information element, identified by that identifier.
	 * 
	 * REF IFA 007 v2.3.1 - 8.6.7
	 * 
	 * @param notification notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(VnfIdentifierCreationNotification notification) throws MethodNotImplementedException;
	
	/**
	 * This notification informs the receiver of the deletion of a VNF 
	 * instance identifier and the associated instance of a VnfInfo 
	 * information element identified by that identifier.
	 * 
	 * REF IFA 007 v2.3.1 - 8.6.8
	 * 
	 * @param notification notification
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notify(VnfIdentifierDeletionNotification notification) throws MethodNotImplementedException;
	
}
