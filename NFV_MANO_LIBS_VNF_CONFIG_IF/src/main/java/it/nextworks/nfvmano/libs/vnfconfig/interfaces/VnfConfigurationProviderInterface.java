package it.nextworks.nfvmano.libs.vnfconfig.interfaces;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;

/**
 * Interface exposing the methods to configure a VNF.
 * It must be implemented by the plug-ins implementing the actual 
 * interaction with the VNF or the EM (via REST API).
 * It must be invoked by the VNFM to request the configuration
 * of a VNF.
 * 
 * REF IFA 007 v2.3.1 - 6.2
 * 
 * @author nextworks
 *
 */
public interface VnfConfigurationProviderInterface {

	/**
	 * This operation enables a VNFM to set the configuration parameters of a 
	 * VNF instance and its VNFC instance(s) or individual VNFC instances.
	 * 
	 * @param request configuration request
	 * @param consumer the entity that will receive a notification when the configuration has been applied
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public void setConfiguration(SetConfigurationRequest request, VnfConfigurationConsumerInterface consumer)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException;
	
}
