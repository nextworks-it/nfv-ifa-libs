package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.AffinityScope;
import it.nextworks.nfvmano.libs.common.enums.AffinityType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request for the creation of a resource affinity or anti-affinity constraints group
 * 
 * REF IFA 005 v2.3.1 - sect. 7.3.1.9
 * REF IFA 005 v2.3.1 - sect. 7.4.1.6
 * 
 * @author nextworks
 *
 */
public class CreateResourceAffinityGroupRequest implements InterfaceMessage {

	private String groupName;
	private AffinityType type;
	private AffinityScope scope;
	
	public CreateResourceAffinityGroupRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param groupName Name of the group, given by the consumer
	 * @param type Indicates whether this is an affinity or anti-affinity group
	 * @param scope If applicable it qualifies the scope of the constraint,
	 */
	public CreateResourceAffinityGroupRequest(String groupName,
			AffinityType type,
			AffinityScope scope) {
		this.groupName = groupName;
		this.type = type; 
		this.scope = scope;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @return the type
	 */
	public AffinityType getType() {
		return type;
	}

	/**
	 * @return the scope
	 */
	public AffinityScope getScope() {
		return scope;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (groupName == null) throw new MalformattedElementException("Create affinity group without group name");
	}

}
