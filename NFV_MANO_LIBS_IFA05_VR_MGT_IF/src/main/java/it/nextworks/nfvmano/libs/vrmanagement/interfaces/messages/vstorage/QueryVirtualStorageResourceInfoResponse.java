package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorageResouceInformation;

/**
 * This message provides information for the various types of 
 * virtualised storage resources managed by the VIM.
 * 
 *  REF IFA 005 v2.3.1 - 7.5.3.4
 *  
 * @author nextworks
 *
 */
public class QueryVirtualStorageResourceInfoResponse implements InterfaceMessage {

	private List<VirtualStorageResouceInformation> virtualisedResourceInformation = new ArrayList<>();
	
	public QueryVirtualStorageResourceInfoResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param virtualisedResourceInformation Virtualised storage resources information in the VIM that satisfies the query condition.
	 */
	public QueryVirtualStorageResourceInfoResponse(List<VirtualStorageResouceInformation> virtualisedResourceInformation) {
		if (virtualisedResourceInformation != null) this.virtualisedResourceInformation = virtualisedResourceInformation;
	}
	
	

	/**
	 * @return the virtualisedResourceInformation
	 */
	public List<VirtualStorageResouceInformation> getVirtualisedResourceInformation() {
		return virtualisedResourceInformation;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (VirtualStorageResouceInformation vsri : virtualisedResourceInformation) vsri.isValid();
	}

}
