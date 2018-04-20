package it.nextworks.nfvmano.libs.swimages.interfaces.enums;

/**
 * REF IFA 006 - v2.3.1 - 7.2.2
 * 
 * @author nextworks
 *
 */
public enum SwImageVisibility {

	PRIVATE,	//the image is available only for the tenant assigned to the provided resourceGroupId and the administrator tenants of the VIM
	PUBLIC		//all tenants of the VIM can use the image
	
}
