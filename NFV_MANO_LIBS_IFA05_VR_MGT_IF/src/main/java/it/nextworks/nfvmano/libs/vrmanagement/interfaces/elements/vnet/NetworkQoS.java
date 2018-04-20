package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * QoS options to be supported on the virtualised network, e.g. latency, jitter, etc.
 * REF IFA 005 v2.3.1 - 8.4.4.3
 * 
 * @author nextworks
 *
 */
public class NetworkQoS implements InterfaceInformationElement {

	private String qosName;
	private int qosValue;
	
	public NetworkQoS() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param qosName Name given to the QoS parameter.
	 * @param qosValue Value of the QoS parameter.
	 */
	public NetworkQoS(String qosName, int qosValue) {
		this.qosName = qosName;
		this.qosValue = qosValue;
	}
	
	

	/**
	 * @return the qosName
	 */
	public String getQosName() {
		return qosName;
	}

	/**
	 * @return the qosValue
	 */
	public int getQosValue() {
		return qosValue;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (qosName == null) throw new MalformattedElementException("Network QoS without name");
	}

}
