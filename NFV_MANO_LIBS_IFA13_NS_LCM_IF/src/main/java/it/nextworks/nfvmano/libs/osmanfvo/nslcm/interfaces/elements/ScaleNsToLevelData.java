package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.records.nsinfo.NsScaleInfo;

/**
 * The ScaleNsToLevelData information element describes the information 
 * needed to scale an NS instance to a target size.
 * The target size is either expressed as an NS instantiation level or 
 * as a list of NS scale levels, one per NS scaling aspect,
 * of the current DF. The NS instantiation levels, the NS scaling aspects 
 * and their corresponding NS scale levels applicable to the NS instance 
 * are declared in the NSD.
 * 
 * REF IFA 013 v2.3.1 - 8.3.4.8
 * 
 * @author nextworks
 *
 */
public class ScaleNsToLevelData implements InterfaceInformationElement {

	private String nsInstantiationLevel;
	private List<NsScaleInfo> nsScaleInfo = new ArrayList<>();
	
	/**
	 * Constructor
	 * 
	 * @param nsInstantiationLevel Identifier of the target NS instantiation level of the current DF to which the NS instance is requested to be scaled.
	 * @param nsScaleInfo For each NS scaling aspect of the current DF, defines the target NS scale level to which the NS instance is to be scaled.
	 */
	public ScaleNsToLevelData(String nsInstantiationLevel,
			List<NsScaleInfo> nsScaleInfo) {
		if (nsScaleInfo != null) this.nsScaleInfo = nsScaleInfo;
		this.nsInstantiationLevel = nsInstantiationLevel;
	}
	
	public ScaleNsToLevelData() {	}

	
	
	/**
	 * @return the nsInstantiationLevel
	 */
	public String getNsInstantiationLevel() {
		return nsInstantiationLevel;
	}

	/**
	 * @return the nsScaleInfo
	 */
	public List<NsScaleInfo> getNsScaleInfo() {
		return nsScaleInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsScaleInfo != null) {
			for (NsScaleInfo i : nsScaleInfo) i.isValid();
		}
	}

}