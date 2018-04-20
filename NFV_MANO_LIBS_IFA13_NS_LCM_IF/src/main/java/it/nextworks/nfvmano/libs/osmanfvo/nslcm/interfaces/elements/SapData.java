package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The SapData information element defines information related to a SAP of an NS.
 * Ref. IFA 013 v2.3.1 section 8.3.4.2
 * 
 * @author nextworks
 *
 */
public class SapData implements InterfaceInformationElement {

	private String sapdId; 
	private String sapName;
	private String description;
	private String address;
	
	public SapData() {	}
	
	/**
	 * Constructor
	 * 
	 * @param sapdId	Reference to the SAPD for this SAP.
	 * @param sapName Human readable name for the SAP.
	 * @param description Human readable description for the SAP.
	 * @param address Address for this SAP.
	 */
	public SapData(String sapdId, String sapName, String description, String address) {
		this.sapdId = sapdId;
		this.sapName = sapName;
		this.description = description;
		this.address = address;
	}
	
	

	/**
	 * @return the sapId
	 */
	public String getSapdId() {
		return sapdId;
	}

	/**
	 * @return the sapName
	 */
	public String getSapName() {
		return sapName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.sapdId == null) throw new MalformattedElementException("SAPD without SAP ID");
		if (this.sapName == null) throw new MalformattedElementException("SAPD without SAP name");
		if (this.description == null) throw new MalformattedElementException("SAPD without description");
	}

}
