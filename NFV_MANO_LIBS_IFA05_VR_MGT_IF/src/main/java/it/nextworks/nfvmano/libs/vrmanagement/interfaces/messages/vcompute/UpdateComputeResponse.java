package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;


/**
 * Response to an update compute request
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.3
 * 
 * @author nextworks
 *
 */
public class UpdateComputeResponse implements InterfaceMessage {

	private String computeId;
	private VirtualCompute computeData;
	
	public UpdateComputeResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param computeId The identifier of the virtualised compute resource that has been updated. This parameter has the same value as the input parameter.
	 * @param computeData Element containing information of the updated attributes of the instantiated virtualised compute resource.
	 */
	public UpdateComputeResponse(String computeId,
			VirtualCompute computeData) {
		this.computeId = computeId;
		this.computeData = computeData;
	}
	
	

	/**
	 * @return the computeId
	 */
	public String getComputeId() {
		return computeId;
	}

	/**
	 * @return the computeData
	 */
	public VirtualCompute getComputeData() {
		return computeData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (computeId == null) throw new MalformattedElementException("Update compute response without compute ID");
		if (computeData == null) throw new MalformattedElementException("Update compute response without compute data");
		else computeData.isValid();
	}

}
