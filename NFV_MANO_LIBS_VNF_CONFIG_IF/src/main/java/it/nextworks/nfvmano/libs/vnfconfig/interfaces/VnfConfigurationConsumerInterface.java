package it.nextworks.nfvmano.libs.vnfconfig.interfaces;

import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;

public interface VnfConfigurationConsumerInterface {

	/**
	 * Method used to notify the results of the modification of a VNF configuration
	 * 
	 * @param respondeCode		result of the configuration modification
	 * @param responseMessage	configuration details
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public void notifySetConfigurationResult(ResponseCode respondeCode, 
			SetConfigurationResponse responseMessage)
					throws MethodNotImplementedException;
	
}
