package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.ResourceZone;


/**
 * Reponse to a query compute or storage resource zone request
 * 
 * Ref. IFA 005 v2.3.1 section 7.3.4.5 - 7.4.5.6
 * 
 * 
 * @author nextworks
 *
 */
public class QueryResourceZoneResponse implements InterfaceMessage {

	private List<ResourceZone> zoneInfo = new ArrayList<>();
	
	public QueryResourceZoneResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param zoneInfo The filtered information that has been retrieved about the Resource Zone
	 */
	public QueryResourceZoneResponse(List<ResourceZone> zoneInfo) {	
		this.zoneInfo = zoneInfo;
	}
	
	

	/**
	 * @return the zoneInfo
	 */
	public List<ResourceZone> getZoneInfo() {
		return zoneInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (ResourceZone rz: zoneInfo) rz.isValid();
	}

}
