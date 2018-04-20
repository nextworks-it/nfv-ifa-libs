package it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This data type provides the list of attributes associated to a CP instance address.
 * 
 * REF IFA 007 v2.3.1 - 9.2.5
 * 
 * @author nextworks
 *
 */
public class CpAddress implements InterfaceInformationElement {

	private String address;
	private boolean useDynamicAddress;
	private String port;
	
	public CpAddress() { }
	
	/**
	 * Constructor
	 * 
	 * @param address The address assigned to the CP instance (e.g. IP address, MAC address, etc.). It shall be provided for configuring a fixed address.
	 * @param useDynamicAddress It determines whether an address shall be assigned dynamically. It shall be provided if a dynamic address needs to be configured on the CP.
	 * @param port The port assigned to the CP instance (e.g. IP port number, Ethernet port number, etc.).
	 */
	public CpAddress(String address,
			boolean useDynamicAddress,
			String port) {
		this.address = address;
		this.useDynamicAddress = useDynamicAddress;
		this.port = port;
	}
	
	

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the useDynamicAddress
	 */
	public boolean isUseDynamicAddress() {
		return useDynamicAddress;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
