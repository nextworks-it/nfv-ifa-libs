package it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This data type provides the list of attributes for the configuration of a CP instance.
 * 
 * REF IFA 007 v2.3.1 - 9.2.4
 * 
 * @author nextworks
 *
 */
public class CpConfiguration implements InterfaceInformationElement {

	private String cpId;
	private String cpLabel;
	private List<CpAddress> address = new ArrayList<>();
	
	public CpConfiguration() { }
	
	/**
	 * Constructor
	 * 
	 * @param cpId Uniquely identifies a CP instance within the namespace of a specific VNF instance or VNFC instance.
	 * @param cpLabel Uniquely identifies a type of CP instance within the namespace of a VNFD.
	 * @param address Address and Port assigned to the CP.
	 */
	public CpConfiguration(String cpId, 
			String cpLabel,
			List<CpAddress> address) {
		this.cpId = cpId;
		this.cpLabel = cpLabel;
		if (address != null) this.address = address;
	}
	
	

	/**
	 * @return the cpId
	 */
	public String getCpId() {
		return cpId;
	}

	/**
	 * @return the cpLabel
	 */
	public String getCpLabel() {
		return cpLabel;
	}

	/**
	 * @return the address
	 */
	public List<CpAddress> getAddress() {
		return address;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (cpId == null) throw new MalformattedElementException("CP configuration without CP ID");
		if (cpLabel == null) throw new MalformattedElementException("CP configuration without CP label");
		for (CpAddress a : address) a.isValid();
	}

}
