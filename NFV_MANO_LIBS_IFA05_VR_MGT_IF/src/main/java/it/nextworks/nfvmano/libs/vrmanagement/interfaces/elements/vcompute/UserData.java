package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.enums.UserDataTransportMedia;

/**
 * REF IFA 005 v2.3.1 - sect. 8.4.10
 * 
 * @author nextworks
 *
 */
public class UserData implements InterfaceInformationElement {

	private String content;
	private UserDataTransportMedia method;
	
	public UserData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param content String containing the user data to customize a virtualised compute resource at boot-time.
	 * @param method Method used as transportation media to convey the content of the UserData to the virtualised compute resource.
	 */
	public UserData(String content,
			UserDataTransportMedia method) {
		this.content = content;
		this.method = method;
	}
	
	

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the method
	 */
	public UserDataTransportMedia getMethod() {
		return method;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (content == null) throw new MalformattedElementException("User Data without content");
	}

}
