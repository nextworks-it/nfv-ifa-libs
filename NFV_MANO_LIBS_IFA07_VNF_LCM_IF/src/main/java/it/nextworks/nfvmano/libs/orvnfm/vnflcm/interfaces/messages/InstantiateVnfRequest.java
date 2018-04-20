package it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.elements.ExtManagedVirtualLinkData;
import it.nextworks.nfvmano.libs.common.elements.ExtVirtualLinkData;
import it.nextworks.nfvmano.libs.common.elements.VnfExtCpData;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VimConnectionInfo;

/**
 * Request to instantiate a VNF
 * 
 * REF IFA 007 v2.3.1 - 7.2.3
 * 
 * @author nextworks
 *
 */
public class InstantiateVnfRequest implements InterfaceMessage {

	private String vnfInstanceId;
	private String flavourId;
	private String instantiationLevelId;
	private List<ExtVirtualLinkData> extVirtualLink = new ArrayList<>();
	private List<ExtManagedVirtualLinkData> extManagedVirtualLink = new ArrayList<>();
	private List<VimConnectionInfo> vimConnectionInfo = new ArrayList<>();
	private String localizationLanguage;
	private Map<String, String> additionalParam = new HashMap<>();
	
	public InstantiateVnfRequest() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfInstanceId Identifier of the VNF instance.
	 * @param flavourId Identifier of the VNF DF to be instantiated.
	 * @param instantiationLevelId Identifier of the instantiation level of the DF to be instantiated. If not present, the default instantiation level as declared in the VNFD shall be instantiated.
	 * @param extVirtualLink Information about external VLs to connect the VNF to.
	 * @param extManagedVirtualLink Information about internal VLs that are managed by other entities than the VNFM
	 * @param vimConnectionInfo Information about VIM connection(s) for managing resources for the VNF instance, or external/externally-managed virtual links.
	 * @param localizationLanguage Localization language of the VNF to be instantiated.
	 * @param additionalParam Additional parameters passed by the NFVO as input to the instantiation process, specific to the VNF being instantiated.
	 */
	public InstantiateVnfRequest(String vnfInstanceId,
			String flavourId,
			String instantiationLevelId,
			List<ExtVirtualLinkData> extVirtualLink,
			List<ExtManagedVirtualLinkData> extManagedVirtualLink,
			List<VimConnectionInfo> vimConnectionInfo,
			String localizationLanguage,
			Map<String, String> additionalParam) {
		this.vnfInstanceId = vnfInstanceId;
		this.flavourId = flavourId;
		this.instantiationLevelId = instantiationLevelId;
		if (extVirtualLink != null) this.extVirtualLink = extVirtualLink;
		if (extManagedVirtualLink != null) this.extManagedVirtualLink = extManagedVirtualLink;
		if (vimConnectionInfo != null) this.vimConnectionInfo = vimConnectionInfo;
		this.localizationLanguage = localizationLanguage;
		if (additionalParam != null) this.additionalParam = additionalParam;
	}

	
	
	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the flavourId
	 */
	public String getFlavourId() {
		return flavourId;
	}

	/**
	 * @return the instantiationLevelId
	 */
	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	/**
	 * @return the extVirtualLink
	 */
	public List<ExtVirtualLinkData> getExtVirtualLink() {
		return extVirtualLink;
	}

	/**
	 * @return the extManagedVirtualLink
	 */
	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLink() {
		return extManagedVirtualLink;
	}
	
	

	/**
	 * @return the vimConnectionInfo
	 */
	public List<VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	/**
	 * @return the localizationLanguage
	 */
	public String getLocalizationLanguage() {
		return localizationLanguage;
	}

	/**
	 * @return the additionalParam
	 */
	public Map<String, String> getAdditionalParam() {
		return additionalParam;
	}
	
	public ExtVirtualLinkData getExtVirtualLinkDataForExtCp(String externalCpId) throws NotExistingEntityException {
		for (ExtVirtualLinkData vl : extVirtualLink) {
			List<VnfExtCpData> extCps = vl.getExtCp();
			for (VnfExtCpData extCp : extCps) {
				if (extCp.getCpdId().equals(externalCpId)) return vl;
			}
		}
		throw new NotExistingEntityException("External VL data not found for external connection point " + externalCpId);
	}
	

	@Override
	public void isValid() throws MalformattedElementException {
		if (vnfInstanceId == null) throw new MalformattedElementException("Instantiate VNF request without VNF instance ID");
		if (flavourId == null) throw new MalformattedElementException("Instantiate VNF request without flavour ID");
		for (ExtVirtualLinkData vl : extVirtualLink) vl.isValid();
		for (ExtManagedVirtualLinkData vl : extManagedVirtualLink) vl.isValid();
		for (VimConnectionInfo vci : vimConnectionInfo) vci.isValid();
	}

}
