package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.HashMap;
import java.util.Map;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.OperativeState;
import it.nextworks.nfvmano.libs.common.enums.StopType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The OperateVnfData information element specifies the VNF instance 
 * for which the operational state needs to be changed and the requested new state.
 * 
 * REF IFA 013 v2.3.1 - 8.3.4.16
 * 
 * @author nextworks
 *
 */
public class OperateVnfData implements InterfaceInformationElement {

	private String vnfInstanceId;
	private OperativeState changeStateTo;
	private StopType stopType;
	private int gracefulStopTimeout;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public OperateVnfData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance.
	 * @param changeStateTo The desired state to change the VNF to.
	 * @param stopType It signals whether forceful or graceful stop is requested.
	 * @param gracefulStopTimeout The time interval to wait for the VNF to be taken out of service during graceful stop, before stopping the VNF.
	 * @param additionalParam additional parameters
	 */
	public OperateVnfData(String vnfInstanceId,
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
		if (vnfInstanceId == null) throw new MalformattedElementException("Operate VNF data without VNF instance ID");

	}

}
