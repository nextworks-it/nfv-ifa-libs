package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;

/**
 * Response to a VNF query
 * 
 * REF IFA 007 v2.3.1 - 7.2.9
 * 
 * @author nextworks
 *
 */
public class QueryVnfResponse implements InterfaceMessage {

	private List<VnfInfo> vnfInfo = new ArrayList<>();
	
	public QueryVnfResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInfo The information items about the selected VNF instance(s) that are returned.
	 */
	public QueryVnfResponse(List<VnfInfo> vnfInfo) {	
		if (vnfInfo != null) this.vnfInfo = vnfInfo;
	}
	
	

	/**
	 * @return the vnfInfo
	 */
	public List<VnfInfo> getVnfInfo() {
		return vnfInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VnfInfo vi : vnfInfo) vi.isValid();
	}

}
