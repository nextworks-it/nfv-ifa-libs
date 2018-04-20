package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;


/**
 * Response to a migrate compute request
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.8
 * 
 * @author nextworks
 *
 */
public class MigrateComputeResponse implements InterfaceMessage {

	private VirtualCompute computeData;
	
	public MigrateComputeResponse() { }
	
	/**
	 * Constructor
	 *  
	 * @param computeData Element containing information of the new host of the migrated virtualised compute resource.
	 */
	public MigrateComputeResponse(VirtualCompute computeData) {
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
		if (computeData == null) throw new MalformattedElementException("Migrate compute response without data");
		else computeData.isValid();
	}

}
