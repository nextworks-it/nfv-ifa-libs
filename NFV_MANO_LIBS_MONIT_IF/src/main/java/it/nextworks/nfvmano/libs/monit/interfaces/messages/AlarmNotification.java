package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.Alarm;


/**
 * This notification informs the receiver of an alarm. 
 * 
 * REF IFA 005 v2.1.1 - 8.6.2
 * REF IFA 013 v2.3.1 - 7.6.3 - 8.5.2
 * REF IFA 007 v2.3.1 - 7.5.3 - 8.8.2
 * 
 * @author nextworks
 *
 */
public class AlarmNotification implements InterfaceMessage {

	private Alarm alarm;
	
	public AlarmNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param alarm Information about an alarm including AlarmId, affected virtualised resource identifier, and FaultDetails.
	 */
	public AlarmNotification(Alarm alarm) { 
		this.alarm = alarm;
	}
	
	/**
	 * @return the alarm
	 */
	public Alarm getAlarm() {
		return alarm;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (alarm == null) throw new MalformattedElementException("Alarm notification without alarm");
		else alarm.isValid();
	}

}
