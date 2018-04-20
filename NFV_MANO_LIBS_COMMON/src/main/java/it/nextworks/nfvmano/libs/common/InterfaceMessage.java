package it.nextworks.nfvmano.libs.common;

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Interface with common methods for checking the validity
 * of a message exchanged on an external interface
 * of an NFV MANO entity 
 * 
 * @author nextworks
 *
 */
public interface InterfaceMessage {

	/**
	 * Method to verify if the information element is compliant with the 
	 * standard
	 * 
	 * @throws MalformattedElementException if the information element is not valid
	 */
	public void isValid() throws MalformattedElementException;
	
}
