package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to an update NS request
 * 
 * REF IFA 013 v2.3.1 - 7.3.5
 * 
 * @author nextworks
 *
 */
public class UpdateNsResponse implements InterfaceMessage {

	private String operationId;
	private List<String> vnfInstanceId = new ArrayList<>();
	private List<String> vnffgId = new ArrayList<>();
	private List<String> sapId = new ArrayList<>();
	
	public UpdateNsResponse() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param operationId The identifier of the NS lifecycle operation occurrence.
	 * @param vnfInstanceId Identifier of the instance of the instantiated VNF.
	 * @param vnffgId Identifier of the instance of the created VNFFG.
	 * @param sapId Identifier of the instance of the created SAP.
	 */
	public UpdateNsResponse(String operationId,
			List<String> vnfInstanceId,
			List<String> vnffgId,
			List<String> sapId) {
		this.operationId = operationId;
		if (vnfInstanceId != null) this.vnfInstanceId = vnfInstanceId;
		if (vnffgId != null) this.vnffgId = vnffgId;
		if (sapId != null) this.sapId = sapId;
	}
	
	

	/**
	 * @return the operationId
	 */
	@JsonProperty("lifecycleOperationOccurrenceId")
	public String getOperationId() {
		return operationId;
	}

	/**
	 * @return the vnfInstanceId
	 */
	public List<String> getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the vnffgId
	 */
	public List<String> getVnffgId() {
		return vnffgId;
	}

	/**
	 * @return the sapId
	 */
	public List<String> getSapId() {
		return sapId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (operationId == null) throw new MalformattedElementException("Update NS response without operation ID");
	}

}
