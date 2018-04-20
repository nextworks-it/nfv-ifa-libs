package it.nextworks.nfvmano.libs.common;

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Interface with common methods for checking the validity
 * of information elements in NFV MANO descriptors
 * 
 * @author nextworks
 *
 */
public interface InterfaceInformationElement {

	/**
	 * Method to verify if the information element is compliant with the 
	 * standard
	 * 
	 * @throws MalformattedElementException if the information element is not valid
	 */
	public void isValid() throws MalformattedElementException;
	
}
