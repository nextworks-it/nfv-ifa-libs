package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.StopType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to terminate a VNF
 * 
 * REF IFA 007 v2.3.1 - 7.2.7
 * 
 * @author nextworks
 *
 */
public class TerminateVnfRequest implements InterfaceMessage {

	private String vnfInstanceId;
	private StopType terminationType;
	private int gracefulTerminationTimeout;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public TerminateVnfRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance to be terminated
	 * @param terminationType Signals whether forceful or graceful termination is requested
	 * @param gracefulTerminationTimeout The time interval to wait for the VNF to be taken out of service during graceful termination, before shutting down the VNF and releasing the resources.
	 * @param additionalParam Additional parameters passed by the NFVO as input to the Terminate VNF operation, specific to the VNF being terminated as declared in the VNFD
	 */
	public TerminateVnfRequest(String vnfInstanceId,
			StopType terminationType,
			int gracefulTerminationTimeout,
			Map<String,String> additionalParam) {
		this.vnfInstanceId = vnfInstanceId;
		this.terminationType = terminationType;
		this.gracefulTerminationTimeout = gracefulTerminationTimeout;
		if (additionalParam != null) this.additionalParam = additionalParam;
	}

	
	
	
	/**
	 * @return the gracefulTerminationTimeout
	 */
	public int getGracefulTerminationTimeout() {
		return gracefulTerminationTimeout;
	}

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the terminationType
	 */
	public StopType getTerminationType() {
		return terminationType;
	}
	
	

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Terminate VNF request without VNF instance ID.");
	}

}
