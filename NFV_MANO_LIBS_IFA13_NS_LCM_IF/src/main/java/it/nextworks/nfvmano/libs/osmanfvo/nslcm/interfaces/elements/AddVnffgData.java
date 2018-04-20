package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element specifies the parameters that are needed
 * for the creation of a new VNFFG instance.
 * 
 * REF IFA 013 v2.3.1 - 8.3.4.21
 * 
 * @author nextworks
 *
 */
public class AddVnffgData implements InterfaceInformationElement {

	private String vnffgdId;
	private String vnffgName;
	private String description;
	
	public AddVnffgData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vnffgdId Identifier of the VNFFGD which defines the VNFFG to be added
	 * @param vnffgName Human readable name for the VNFFG.
	 * @param description Human readable description for the VNFFG.
	 */
	public AddVnffgData(String vnffgdId,
			String vnffgName,
			String description) {
		this.vnffgdId = vnffgdId;
		this.vnffgName = vnffgName;
		this.description = description;
	}
	
	

	/**
	 * @return the vnffgdId
	 */
	public String getVnffgdId() {
		return vnffgdId;
	}

	/**
	 * @return the vnffgName
	 */
	public String getVnffgName() {
		return vnffgName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnffgdId == null) throw new MalformattedElementException("Add VNFFG data without VNFFGD ID");
		if (vnffgName == null) throw new MalformattedElementException("Add VNFFG data without VNFFG name");
		if (description == null) throw new MalformattedElementException("Add VNFFG data without VNFFG description");
	}

}
