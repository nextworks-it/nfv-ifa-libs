package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.VnfScaleType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to scale a VNF.
 * 
 * REF IFA 007 v2.3.1 - 7.2.4
 * 
 * @author nextworks
 *
 */
public class ScaleVnfRequest implements InterfaceMessage {

	private String vnfInstanceId;
	private VnfScaleType type;
	private String aspectId;
	private int numberOfSteps;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public ScaleVnfRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance to which this scaling request is related.
	 * @param type Defines the type of the scale operation requested
	 * @param aspectId Identifies the aspect of the VNF that is requested to be scaled, as declared in the VNFD.
	 * @param numberOfSteps Number of scaling steps to be executed as part of this ScaleVnf operation.
	 * @param addtionalParam Additional parameters passed by the NFVO as input to the scaling process, specific to the VNF being scaled.
	 */
	public ScaleVnfRequest(String vnfInstanceId,
			VnfScaleType type,
			String aspectId,
			int numberOfSteps,
			Map<String, String> addtionalParam) { 
		this.vnfInstanceId = vnfInstanceId;
		this.type = type;
		this.aspectId = aspectId;
		this.numberOfSteps = numberOfSteps;
		if (addtionalParam != null) this.additionalParam = addtionalParam;
	}
	
	

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the type
	 */
	public VnfScaleType getType() {
		return type;
	}

	/**
	 * @return the aspectId
	 */
	public String getAspectId() {
		return aspectId;
	}

	/**
	 * @return the numberOfSteps
	 */
	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Scale VNF request without VNF instance ID");
		if (aspectId == null) throw new MalformattedElementException("Scale VNF request without aspect ID");
	}

}
