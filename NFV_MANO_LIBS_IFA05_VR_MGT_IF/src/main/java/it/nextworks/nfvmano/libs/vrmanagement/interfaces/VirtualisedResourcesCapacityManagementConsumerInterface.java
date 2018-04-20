package it.nextworks.nfvmano.libs.vrmanagement.interfaces;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.CapacityChangeNotification;

/**
 * This interface allows an authorized consumer functional block 
 * to request operations related to capacity and usage reporting. 
 * The interface allows retrieval of information about:
 * 
 * 1. The available, allocated, reserved and total capacity of the 
 * compute resources managed by a VIM instance, globally or per resource zone.
 * 
 * 2. Utilization of the capacity, both on VIM global level but also per resource zone.
 * 
 * 3. The geographical location and network connectivity endpoints 
 * (e.g. network gateway) to the NFVI-PoP(s) administered by the VIM.
 * 
 * It must be implemented by the NFVO and invoked by the VIM plugin.
 * 
 * Note: this interface can be also used for network resources: REF IFA 005 v2.3.1 - 7.4.4.4
 * and for storage resources - REF IFA 005 v2.3.1 - 7.5.4.4
 * 
 * REF IFA 005 v2.3.1 - 7.3.4.4
 * 
 * 
 * @author nextworks
 *
 */
public interface VirtualisedResourcesCapacityManagementConsumerInterface {

	/**
	 * This operation distributes notifications to subscribers. 
	 * It is a one-way operation issued by the VIM that cannot be
	 * invoked as an operation by the consumer (NFVO).
	 * 
	 * REF IFA 005 v2.3.1 - 7.3.4.4 - 7.4.4.4
	 * 
	 * @param notification notification
	 */
	public void notify(CapacityChangeNotification notification);
	
}
