package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.enums.PnfChangeType;

/**
 * This information element provides information about added and removed PNFs from an NS.
 * 
 * REF IFA 013 v2.3.1 - 8.3.2.4
 * 
 * @author nextworks
 *
 */
public class AffectedPnf implements InterfaceInformationElement {

	private String pnfName;
	private String pnfdId;
	private String pnfProfileId;
	private PnfChangeType changeType;
	
	public AffectedPnf() {	}
	
	/**
	 * Constructor
	 * 
	 * @param pnfName Name of the PNF instance.
	 * @param pnfdId Identifier of the PNFD of the PNF instance.
	 * @param pnfProfileId Identifier of the PNF profile of the NSD.
	 * @param changeType Signals the type of lifecycle change.
	 */
	public AffectedPnf(String pnfName,
			String pnfdId,
			String pnfProfileId,
			PnfChangeType changeType) {	
		this.pnfName = pnfName;
		this.pnfdId = pnfdId;
		this.pnfProfileId = pnfProfileId;
		this.changeType = changeType;
	}
	
	/**
	 * @return the pnfName
	 */
	@JsonProperty("pnfName")
	public String getPnfName() {
		return pnfName;
	}

	/**
	 * @return the pnfdId
	 */
	@JsonProperty("pnfdId")
	public String getPnfdId() {
		return pnfdId;
	}

	/**
	 * @return the pnfProfileId
	 */
	@JsonProperty("pnfProfileId")
	public String getPnfProfileId() {
		return pnfProfileId;
	}

	/**
	 * @return the changeType
	 */
	@JsonProperty("changeType")
	public PnfChangeType getChangeType() {
		return changeType;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (pnfName == null) throw new MalformattedElementException("Affected PNF without PNF name");
		if (pnfdId == null) throw new MalformattedElementException("Affected PNF without PNFD ID");
		if (pnfProfileId == null) throw new MalformattedElementException("Affected PNF without PNF profile ID");
	}

}
