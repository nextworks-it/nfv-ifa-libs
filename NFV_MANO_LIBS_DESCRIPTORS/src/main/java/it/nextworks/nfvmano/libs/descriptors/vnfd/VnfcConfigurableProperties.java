package it.nextworks.nfvmano.libs.descriptors.vnfd;

import javax.persistence.Embeddable;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines the configurable properties of a VNFC. 
 * For a VNFC instance, the value of these properties can be modified through the VNFM.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.6.7
 * 
 * Just a placeholder for the moment.
 * Format still to be defined in the standard.
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VnfcConfigurableProperties implements DescriptorInformationElement {

	public VnfcConfigurableProperties() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void isValid() throws MalformattedElementException {
		// TODO Auto-generated method stub

	}

}
