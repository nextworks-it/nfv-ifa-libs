package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;


/**
 * Response to an allocate compute request.
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.2
 * 
 * @author nextworks
 *
 */
public class AllocateComputeResponse implements InterfaceMessage {

	private VirtualCompute computeData;
	
	public AllocateComputeResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param computeData Element containing information of the newly instantiated virtualised compute resource.
	 */
	public AllocateComputeResponse(VirtualCompute computeData) { 
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
		if (computeData == null) throw new MalformattedElementException("Allocate compute response without compute data");
		else computeData.isValid();
	}

}
