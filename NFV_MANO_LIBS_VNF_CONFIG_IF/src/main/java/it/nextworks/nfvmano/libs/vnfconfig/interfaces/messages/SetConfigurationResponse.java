package it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements.VnfConfiguration;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements.VnfcConfiguration;

public class SetConfigurationResponse implements InterfaceMessage {

	private VnfConfiguration vnfConfigurationData;
	private List<VnfcConfiguration> vnfcConfigurationData = new ArrayList<>();
	
	public SetConfigurationResponse() {	}
	
	public SetConfigurationResponse(VnfConfiguration vnfConfigurationData,
			List<VnfcConfiguration> vnfcConfigurationData) {
		this.vnfConfigurationData = vnfConfigurationData;
		if (vnfcConfigurationData != null) this.vnfcConfigurationData = vnfcConfigurationData;
	}

	
	
	/**
	 * @return the vnfConfigurationData
	 */
	public VnfConfiguration getVnfConfigurationData() {
		return vnfConfigurationData;
	}

	/**
	 * @return the vnfcConfigurationData
	 */
	public List<VnfcConfiguration> getVnfcConfigurationData() {
		return vnfcConfigurationData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfConfigurationData != null) vnfConfigurationData.isValid();
		for (VnfcConfiguration vc : vnfcConfigurationData) vc.isValid();
	}

}
