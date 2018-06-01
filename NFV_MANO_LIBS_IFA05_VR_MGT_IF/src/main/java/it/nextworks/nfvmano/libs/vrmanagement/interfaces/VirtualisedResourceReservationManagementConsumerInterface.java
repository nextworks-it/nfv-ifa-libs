/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.libs.vrmanagement.interfaces;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.reservation.VirtualisedResourceReservationChangeNotification;

/**
 * This interface allows an authorized consumer functional block to receive notifications about
 * changes on reservation of virtualised resources.
 * 
 * This interface provides the consumer side. It must be implemented by the NFVO and invoked
 * by the VIM plugins. 
 * 
 *  REF IFA 005 v2.3.1 - 7.8.4.3
 * 
 * @author nextworks
 *
 */
public interface VirtualisedResourceReservationManagementConsumerInterface {

	/**
	 * This operation distributes notifications to subscribers. 
	 * It is a one-way operation issued by the VIM that cannot be invoked as an operation by the consumer (NFVO).
	 * 
	 * REF IFA 005 v2.3.1 - 7.8.4.3
	 * 
	 * @param notification
	 */
	public void notify(VirtualisedResourceReservationChangeNotification notification);
	
}
