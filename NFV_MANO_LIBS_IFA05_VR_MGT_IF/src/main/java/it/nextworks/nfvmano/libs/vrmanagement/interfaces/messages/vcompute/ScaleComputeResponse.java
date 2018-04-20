package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;


/**
 * Response to a scale compute request
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.7
 * 
 * @author nextworks
 *
 */
public class ScaleComputeResponse implements InterfaceMessage {

	private VirtualCompute computeData;
	
	public ScaleComputeResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param computeData Element containing information of the scaled virtualised compute resource.
	 */
	public ScaleComputeResponse(VirtualCompute computeData) {
		this.computeData = computeData;
	}
	
	

	/**
	 * @return the computeData
	 */
	public VirtualCompute getComputeData() {
		return computeData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (computeData == null) throw new MalformattedElementException("Scale compute response without compute data");
		else computeData.isValid();
	}

}
