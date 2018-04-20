package it.nextworks.nfvmano.libs.vrmanagement.interfaces;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.VirtualisedResourceChangeNotification;

/**
 * This interface allows to send and receive notifications related to 
 * virtual network resources.
 * 
 * This interface implements the consumer side; 
 * it must be implemented by a VIM consumer (i.e. NFVO (IFA 005) 
 * or VNFM (IFA 006)) and invoked by a VIM plugin.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.4.2
 * 
 * @author nextworks
 *
 */
public interface VirtualisedNetworkResourceManagementConsumerInterface {

	/**
	 * This operation distributes notifications to subscribers. 
	 * It is a one-way operation issued by the VIM that cannot be 
	 * invoked as an operation by the consumer (NFVO).
	 * 
	 * REF IFA 005 v2.3.1 - sect. 7.4.2.3
	 *  
	 * @param notification notification
	 */
	public void notifyVirtualComputeResourceChange(VirtualisedResourceChangeNotification notification);
	
}
