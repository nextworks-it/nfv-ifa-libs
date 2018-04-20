package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.enums.DegreeHealing;

/**
 * This information element describes the information needed to heal an NS.
 * 
 *  REF IFA 013 v2.3.1 - 8.3.4.24
 * 
 * @author nextworks
 *
 */
public class HealNsData implements InterfaceInformationElement {

	private List<String> actionsHealing = new ArrayList<>();
	private DegreeHealing degreeHealing;
	private String healScript;
	
	public HealNsData() { }
	
	/**
	 * Constructor
	 * 
	 * @param degreeHealing Indicates the degree of healing
	 * @param actionsHealing May be used to specify dedicated healing actions in a particular order.
	 * @param healScript Provides a reference to a script from the NSD that shall be used to execute dedicate healing actions in a particular order.
	 */
	public HealNsData(DegreeHealing degreeHealing,
			List<String> actionsHealing,
			String healScript) {
		this.degreeHealing = degreeHealing;
		if (actionsHealing != null) this.actionsHealing = actionsHealing;
		this.healScript = healScript;
	}

	
	
	/**
	 * @return the healScript
	 */
	public String getHealScript() {
		return healScript;
	}

	/**
	 * @return the actionsHealing
	 */
	public List<String> getActionsHealing() {
		return actionsHealing;
	}

	/**
	 * @return the degreeHealing
	 */
	public DegreeHealing getDegreeHealing() {
		return degreeHealing;
	}

	@Override
	public void isValid() throws MalformattedElementException {}

}
