package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.OperativeState;
import it.nextworks.nfvmano.libs.common.enums.StopType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to change the state of a VNF
 * 
 * REF IFA 007 v2.3.1 - 7.2.11
 * 
 * @author nextworks
 *
 */
public class OperateVnfRequest implements InterfaceMessage {

	private String vnfInstanceId;
	private OperativeState changeStateTo;
	private StopType stopType;
	private int gracefulStopTimeout;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public OperateVnfRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance.
	 * @param changeStateTo The desired state to change the VNF to.
	 * @param stopType It signals whether forceful or graceful stop is requested.
	 * @param gracefulStopTimeout The time interval to wait for the VNF to be taken out of service during graceful stop, before stopping the VNF.
	 */
	public OperateVnfRequest(String vnfInstanceId,
			OperativeState changeStateTo,
			StopType stopType,
			int gracefulStopTimeout,
			Map<String, String> additionalParam) { 
		this.vnfInstanceId = vnfInstanceId;
		this.changeStateTo = changeStateTo;
		this.stopType = stopType;
		this.gracefulStopTimeout = gracefulStopTimeout;
		if (additionalParam != null) this.additionalParam = additionalParam;
	}

	
	
	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the changeStateTo
	 */
	public OperativeState getChangeStateTo() {
		return changeStateTo;
	}

	/**
	 * @return the stopType
	 */
	public StopType getStopType() {
		return stopType;
	}

	/**
	 * @return the gracefulStopTimeout
	 */
	public int getGracefulStopTimeout() {
		return gracefulStopTimeout;
	}
	
	

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Operate VNF request without ID");
	}

}
