package it.nextworks.nfvmano.libs.vrmanagement.interfaces;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas.VirtualisedResourceQuotaChangeNotification;

/**
 * This interface allows to receive notification about operations on quotas for virtual resources.
 * 
 * It must be implemented by the NFVO and invoked by VIM plugins. 
 * 
 * REF IFA 005 v2.3.1 - 7.9.4
 * 
 * @author nextworks
 *
 */
public interface VirtualisedResourceQuotaManagementConsumerInterface {

	/**
	 * This operation distributes notifications to subscribers. 
	 * It is a one-way operation issued by the VIM that cannot be invoked as an 
	 * operation by the consumer (NFVO).
	 * 
	 * REF IFA 005 v2.3.1 - 7.9.4.3
	 * 
	 * @param notification notification
	 */
	public void notify(VirtualisedResourceQuotaChangeNotification notification);
	
}
