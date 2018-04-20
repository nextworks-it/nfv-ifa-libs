package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.quotas;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification indicates a Quota change in a virtualised resource.
 * 
 * REF IFA 005 v2.3.1 - 7.9.4.3 and 8.11.5 
 * 
 * @author nextworks
 *
 */
public class VirtualisedResourceQuotaChangeNotification implements InterfaceMessage {

	private String changeId;
	private String resourceGroupId;
	private String vimId;
	private String changeType;
	private Map<String, String> changedQuotaData = new HashMap<>();
	
	public VirtualisedResourceQuotaChangeNotification() { }
	
	

	/**
	 * Constructor
	 * 
	 * @param changeId Unique identifier of the change on the virtualised resource Quota.
	 * @param resourceGroupId Unique identifier of the "infrastructure resource group", logical grouping of virtual resources assigned to a tenant within an Infrastructure Domain.
	 * @param vimId The VIM reporting the change.
	 * @param changeType It categorizes the type of change.
	 * @param changedQuotaData Details of the changes of the Quota.
	 */
	public VirtualisedResourceQuotaChangeNotification(String changeId, 
			String resourceGroupId, 
			String vimId,
			String changeType, 
			Map<String, String> changedQuotaData) {
		this.changeId = changeId;
		this.resourceGroupId = resourceGroupId;
		this.vimId = vimId;
		this.changeType = changeType;
		if (changedQuotaData != null) this.changedQuotaData = changedQuotaData;
	}



	/**
	 * @return the changeId
	 */
	public String getChangeId() {
		return changeId;
	}



	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}



	/**
	 * @return the vimId
	 */
	public String getVimId() {
		return vimId;
	}



	/**
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}



	/**
	 * @return the changedQuotaData
	 */
	public Map<String, String> getChangedQuotaData() {
		return changedQuotaData;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (changeId == null) throw new MalformattedElementException("Virtual resource quota change notification without ID");
		if (resourceGroupId == null) throw new MalformattedElementException("Virtual resource quota change notification without resource group ID");
		if (vimId == null) throw new MalformattedElementException("Virtual resource quota change notification without VIM ID");
		if (changeType == null) throw new MalformattedElementException("Virtual resource quota change notification without change type");
	}

}
