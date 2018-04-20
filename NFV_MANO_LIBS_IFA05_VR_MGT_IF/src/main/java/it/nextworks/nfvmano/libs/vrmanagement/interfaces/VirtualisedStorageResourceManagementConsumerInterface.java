package it.nextworks.nfvmano.libs.vrmanagement.interfaces;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.VirtualisedResourceChangeNotification;

/**
 * This interface allows an authorized consumer functional block 
 * to perform operations on virtualised storage resources available 
 * to the consumer functional block. 
 * 
 * The interface includes operations for allocating, querying, updating and
 * terminating virtualised storage resources as well as operations for scaling, 
 * migrating and operating the administrative status of a virtualised resource.
 * 
 * This interface implements the consumer side; 
 * it must be implemented by a VIM consumer (i.e. NFVO (IFA 005) 
 * or VNFM (IFA 006)) and invoked by a VIM plugin.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.2
 * 
 * @author nextworks
 *
 */
public interface VirtualisedStorageResourceManagementConsumerInterface {

	/**
	 * This operation distributes notifications to subscribers. 
	 * It is a one-way operation issued by the VIM that cannot be
	 * invoked as an operation by the consumer (NFVO or VNFM).
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.5.2.3
	 * 
	 * @param notification notification
	 */
	public void notifyVirtualStorageResourceChange(VirtualisedResourceChangeNotification notification);
	
}
