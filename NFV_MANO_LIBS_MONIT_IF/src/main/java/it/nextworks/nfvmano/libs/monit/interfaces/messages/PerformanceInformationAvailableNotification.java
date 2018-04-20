package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification informs the receiver that performance information is available.
 * 
 * REF IFA 013 v2.3.1 - 7.5.5 - 8.4.8
 * REF IFA 007 v2.3.1 - 7.4.5 - 8.7.8
 * 
 * @author nextworks
 *
 */
public class PerformanceInformationAvailableNotification implements InterfaceMessage {

	private List<String> objectInstanceId = new ArrayList<>();
	
	public PerformanceInformationAvailableNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param objectInstanceId Object instances for which performance information is available.
	 */
	public PerformanceInformationAvailableNotification(List<String> objectInstanceId) {
		if (objectInstanceId != null) this.objectInstanceId = objectInstanceId;
	}
	
	

	/**
	 * @return the objectInstanceId
	 */
	public List<String> getObjectInstanceId() {
		return objectInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((objectInstanceId == null) || (objectInstanceId.isEmpty())) throw new MalformattedElementException("Performance info available notification without object instance ID");
	}

}
