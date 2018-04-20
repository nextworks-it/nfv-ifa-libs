package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages;

import java.util.Date;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Message to request the termination of a NS.
 * 
 * REF IFA 013 v2.3.1 - 7.3.7
 * 
 * @author nextworks
 *
 */
public class TerminateNsRequest implements InterfaceMessage {

	private String nsInstanceId;
	private Date terminateTime;
	
	public TerminateNsRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId Identifier of the NS instance to terminate.
	 * @param terminateTime Timestamp indicating the end time of the NS, i.e. the NS will be terminated automatically at this timestamp. If not present the NS termination takes place immediately.
	 */
	public TerminateNsRequest(String nsInstanceId, Date terminateTime) {
		this.nsInstanceId  = nsInstanceId;
		this.terminateTime = terminateTime;
	}

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}



	/**
	 * @return the terminateTime
	 */
	public Date getTerminateTime() {
		return terminateTime;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (nsInstanceId == null) throw new MalformattedElementException("Terminate NS request without NS Instance ID");
	}
	
}
