package it.nextworks.nfvmano.libs.monit.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.Alarm;


/**
 * This operation enables the service consumer to query the active alarms.
 * 
 * REF IFA 013 v2.3.1 - 7.6.4
 * REF IFA 007 v2.3.1 - 7.5.4
 * REF IFA 005 v2.3.1 - 7.6.4
 * 
 * @author nextworks
 *
 */
public class GetAlarmListResponse implements InterfaceMessage {
	
	private List<Alarm> alarm = new ArrayList<>();

	public GetAlarmListResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param alarm Information about the alarms
	 */
	public GetAlarmListResponse(List<Alarm> alarm) {	
		if (alarm != null) this.alarm = alarm;
	}
	
	

	/**
	 * @return the alarm
	 */
	public List<Alarm> getAlarm() {
		return alarm;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (Alarm a : alarm) a.isValid();
	}

}
