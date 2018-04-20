package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Request to on-board a new application package.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.5
 * 
 * @author nextworks
 *
 */
public class OnboardAppPackageRequest implements InterfaceMessage {

	private String name;
	private String version;
	private String provider;
	private String checksum;
	private Map<String, String> userDefinedData = new HashMap<>();
	private String appPackagePath;
	
	public OnboardAppPackageRequest() {	}
	
	

	/**
	 * Constructor
	 * 
	 * @param name Name of the application package to be on-boarded.
	 * @param version Version of the application package to be on-boarded.
	 * @param provider Provider of the application package to be on-boarded.
	 * @param checksum Checksum of the on-boarded application package.
	 * @param userDefinedData User defined data for the application package.
	 * @param appPackagePath Address information based on which the application package may be obtained.
	 */
	public OnboardAppPackageRequest(String name, String version, String provider, String checksum,
			Map<String, String> userDefinedData, String appPackagePath) {
		this.name = name;
		this.version = version;
		this.provider = provider;
		this.checksum = checksum;
		if (userDefinedData != null) this.userDefinedData = userDefinedData;
		this.appPackagePath = appPackagePath;
	}

	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}



	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}



	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}



	/**
	 * @return the userDefinedData
	 */
	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}



	/**
	 * @return the appPackagePath
	 */
	public String getAppPackagePath() {
		return appPackagePath;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (name == null) throw new MalformattedElementException("On-board app package request without appD name.");
		if (version == null) throw new MalformattedElementException("On-board app package request without version.");
		if (provider == null) throw new MalformattedElementException("On-board app package request without provider.");
		if (checksum == null) throw new MalformattedElementException("On-board app package request without checksum.");
		if (appPackagePath == null) throw new MalformattedElementException("On-board app package request without app package path URL.");
	}

}
