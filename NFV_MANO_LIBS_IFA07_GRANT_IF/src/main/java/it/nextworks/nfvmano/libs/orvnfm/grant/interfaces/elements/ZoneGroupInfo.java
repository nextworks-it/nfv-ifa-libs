package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information regarding a resource zone group. 
 * A resource zone group is a group of one or more related resource zones which 
 * can be used in resource placement constraints.
 * 
 * REF IFA 007 v2.3.1 - 8.3.5
 * 
 * @author nextworks
 *
 */
public class ZoneGroupInfo implements InterfaceInformationElement {

	private List<String> zoneId = new ArrayList<>();
	
	public ZoneGroupInfo() { }
	
	/**
	 * Constructor
	 * 
	 * @param zoneId References of identifiers of ZoneInfo instances, each of which provides information about a resource zone that belongs to this group.
	 */
	public ZoneGroupInfo(List<String> zoneId) {
		if (zoneId != null) this.zoneId = zoneId;
	}

	
	
	/**
	 * @return the zoneId
	 */
	public List<String> getZoneId() {
		return zoneId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((zoneId == null) || (zoneId.isEmpty())) throw new MalformattedElementException("Zone group info without zone ID");
	}

}
