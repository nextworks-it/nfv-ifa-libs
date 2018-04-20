package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.InformationChangeType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification informs the receiver that 
 * information related to consumable virtualised resources has changed.
 * 
 * REF IFA 005 v2.3.1 - 8.3.2
 * 
 * @author nextworks
 *
 */
public class InformationChangeNotification implements InterfaceMessage {

	private String changeId;
	private String resourceTypeId;
	private String vimId;
	private InformationChangeType changeType;
	private Map<String, String> changedResourceData = new HashMap<String, String>();
	
	public InformationChangeNotification() { }

	/**
	 * Constructor
	 * 
	 * @param changeId Unique identifier of the change on the consumable virtualised resource type.
	 * @param resourceTypeId Identifier of the consumable virtualised resource type.
	 * @param vimId Identifier of the VIM reporting the change.
	 * @param changeType It categorizes the type of change.
	 * @param changedResourceData Details of the changes of consumable virtualised resource information.
	 */
	public InformationChangeNotification(String changeId,
			String resourceTypeId,
			String vimId,
			InformationChangeType changeType,
			Map<String, String> changedResourceData) { 
		this.changeId = changeId;
		this.resourceTypeId = resourceTypeId;
		this.vimId = vimId;
		this.changeType = changeType;
		if (changedResourceData != null) this.changedResourceData = changedResourceData;
	}
	
	

	/**
	 * @return the changeId
	 */
	public String getChangeId() {
		return changeId;
	}

	/**
	 * @return the resourceTypeId
	 */
	public String getResourceTypeId() {
		return resourceTypeId;
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
	public InformationChangeType getChangeType() {
		return changeType;
	}

	/**
	 * @return the changedResourceData
	 */
	public Map<String, String> getChangedResourceData() {
		return changedResourceData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (changeId == null) throw new MalformattedElementException("Info change notification without change ID");
		if (resourceTypeId == null) throw new MalformattedElementException("Info change notification without type ID");
		if (vimId == null) throw new MalformattedElementException("Info change notification without VIM ID");
	}

}
