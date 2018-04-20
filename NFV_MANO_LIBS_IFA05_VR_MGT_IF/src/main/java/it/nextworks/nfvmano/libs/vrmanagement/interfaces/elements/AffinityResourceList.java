package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The AffinityOrAntiAffinityResourceList information element 
 * defines an explicit list of resources to express affinity or
 * anti-affinity between these resources and a current resource.
 * 
 *  REF IFA 005 v2.3.1 - 8.4.8.3
 * 
 * @author nextworks
 *
 */
public class AffinityResourceList  implements InterfaceInformationElement {

	private List<String> resource = new ArrayList<>();
	
	public AffinityResourceList() {	}

	/**
	 * Constructor
	 * 
	 * @param resource List of identifiers of virtualised resources
	 */
	public AffinityResourceList(List<String> resource) {
		if (resource != null) this.resource = resource;
	}
	
	/**
	 * @return the resource
	 */
	public List<String> getResource() {
		return resource;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((resource == null) || (resource.isEmpty())) 
				throw new MalformattedElementException("Affinity resource list without resources");
	}
	
}
