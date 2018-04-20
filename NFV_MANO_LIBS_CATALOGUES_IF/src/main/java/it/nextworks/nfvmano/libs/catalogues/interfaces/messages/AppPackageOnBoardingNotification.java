package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification indicates the on-boarding of an App Package.
 * It is produced when a new App Package is on-boarded.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.4
 * Message not yet specified.
 * 
 * @author nextworks
 *
 */
public class AppPackageOnBoardingNotification implements InterfaceMessage {

	private String appdInfoId;
	private String appdId;
	
	public AppPackageOnBoardingNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param appdInfoId ID of the app package info.
	 * @param appdId ID of the app descriptor
	 */
	public AppPackageOnBoardingNotification(String appdInfoId,
			String appdId) {
		this.appdId = appdId;
		this.appdInfoId = appdInfoId;
	}
	
	

	/**
	 * @return the appdInfoId
	 */
	public String getAppdInfoId() {
		return appdInfoId;
	}

	/**
	 * @return the appdId
	 */
	public String getAppdId() {
		return appdId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (appdId == null) throw new MalformattedElementException("App package on-boarding notification without appD ID");
		if (appdInfoId == null) throw new MalformattedElementException("App package on-boarding notification without appD info ID");
	}

}
