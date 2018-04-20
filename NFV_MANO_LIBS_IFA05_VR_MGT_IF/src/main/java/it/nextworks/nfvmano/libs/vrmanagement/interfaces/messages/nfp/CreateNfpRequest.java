package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.nfp;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Create NFP request
 * 
 * REF IFA 005 v2.3.1 - 7.4.5.2
 * 
 * @author nextworks
 *
 */
public class CreateNfpRequest implements InterfaceMessage {

	private List<String> virtualNetworkPort = new ArrayList<>();
	private int totalVnp;
	private String nfpRule;	// format still to be defined
	
	public CreateNfpRequest() {	}
	
	/**
	 * Classifier
	 * 
	 * @param virtualNetworkPort The identification of a virtual network port
	 * @param totalVnp Total number of virtual network ports in this NFP.
	 * @param nfpRule NFP classification and selection rule(s).
	 */
	public CreateNfpRequest(List<String> virtualNetworkPort,
			int totalVnp,
			String nfpRule) {	
		if (virtualNetworkPort != null) this.virtualNetworkPort = virtualNetworkPort;
		this.totalVnp = totalVnp;
		this.nfpRule = nfpRule;
	}
	
	

	/**
	 * @return the virtualNetworkPort
	 */
	public List<String> getVirtualNetworkPort() {
		return virtualNetworkPort;
	}

	/**
	 * @return the totalVnp
	 */
	public int getTotalVnp() {
		return totalVnp;
	}

	/**
	 * @return the nfpRule
	 */
	public String getNfpRule() {
		return nfpRule;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((virtualNetworkPort == null) || (virtualNetworkPort.isEmpty())) throw new MalformattedElementException("Create NFP request without network port");
		if (nfpRule == null) throw new MalformattedElementException("Create NFP request without classifier rule");
	}

}
