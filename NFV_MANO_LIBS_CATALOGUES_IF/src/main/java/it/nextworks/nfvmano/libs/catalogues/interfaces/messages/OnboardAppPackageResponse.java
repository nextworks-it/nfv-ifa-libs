package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Response to an on-board application package request.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.5
 * 
 * @author nextworks
 *
 */
public class OnboardAppPackageResponse implements InterfaceMessage {

	private String onboardedAppPkgId;
	private String appDId;
	
	public OnboardAppPackageResponse() { }
	
	/**
	 * Constructor
	 * 
	 * @param onboardedAppPkgId Identifier of the on-boarded the Application package.
	 * @param appDId Identifier that identifies the application package in a globally unique way.
	 */
	public OnboardAppPackageResponse(String onboardedAppPkgId,
			String appDId) {
		this.onboardedAppPkgId = onboardedAppPkgId;
		this.appDId = appDId;
	}
	
	

	/**
	 * @return the onboardedAppPkgId
	 */
	public String getOnboardedAppPkgId() {
		return onboardedAppPkgId;
	}

	/**
	 * @return the appDId
	 */
	public String getAppDId() {
		return appDId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (onboardedAppPkgId == null) throw new MalformattedElementException("On-board app package response without app package ID");
		if (appDId == null) throw new MalformattedElementException("On-board app package response without appD ID");
	}

}
