package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;


/**
 * Request to update an existing NSD
 * REF IFA 013 v2.3.1 - 7.2.5
 * 
 * @author nextworks
 *
 */
public class UpdateNsdRequest implements InterfaceMessage {

	private String nsdInfoId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private  Nsd nsd;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> userDefinedData = new HashMap<>();
	
	public UpdateNsdRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param nsdInfoId Identifier of the on-boarded version of the NSD
	 * @param nsd New NSD to be created. Only present if the NSD itself is updated.
	 * @param userDefinedData User defined data to be updated. For existing keys, the value is replaced.
	 */
	public UpdateNsdRequest(String nsdInfoId,
			Nsd nsd,
			Map<String, String> userDefinedData) {
		this.nsdInfoId = nsdInfoId;
		this.nsd = nsd;
		if (userDefinedData != null) this.userDefinedData = userDefinedData;
	}
	
	

	/**
	 * @return the nsdInfoId
	 */
	public String getNsdInfoId() {
		return nsdInfoId;
	}

	/**
	 * @return the nsd
	 */
	public Nsd getNsd() {
		return nsd;
	}

	/**
	 * @return the userDefinedData
	 */
	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.nsdInfoId == null) throw new MalformattedElementException("Update NSD request without NSD  info ID.");
		if ((this.nsd == null) && ((this.userDefinedData == null) || (this.userDefinedData.isEmpty())))
				throw new MalformattedElementException("Update NSD request without NSD or user defined data");
	}

}
