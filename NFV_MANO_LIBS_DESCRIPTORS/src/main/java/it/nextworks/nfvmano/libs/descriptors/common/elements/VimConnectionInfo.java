package it.nextworks.nfvmano.libs.descriptors.common.elements;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;

/**
 * This information element provides information regarding a VIM connection. 
 * 
 * REF IFA 007 v2.3.1 - 8.12.5
 * 
 * @author nextworks
 *
 */
@Entity
public class VimConnectionInfo implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private VnfInfo vnfInfo;
	
	private String vimConnectionInfoId;
	private String vimId;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> interfaceInfo = new ArrayList<>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> accessInfo = new ArrayList<>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> extra = new ArrayList<>();
	
	public VimConnectionInfo() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param vimConnectionInfoId The identifier of this VimConnectionInfo information element, for the purpose of referencing it from other information elements. This identifier is managed by the NFVO.
	 * @param vimId The identifier of the VIM. This identifier is managed by the NFVO.
	 * @param interfaceInfo Information about the interface(s) to the VIM, if available, including interface endpoint e.g. URL API version, and protocol type.
	 * @param accessInfo Authentication credentials for accessing the VIM. Examples can include those to support different authentication schemes, e.g. OAuth, Token, Username/password, etc.
	 * @param extra VIM type specific additional information, if applicable.
	 */
	public VimConnectionInfo(String vimConnectionInfoId, 
			String vimId,
			List<String> interfaceInfo,
			List<String> accessInfo,
			List<String> extra) {
		this.vimConnectionInfoId = vimConnectionInfoId;
		this.vimId = vimId;
		if (interfaceInfo != null) this.interfaceInfo = interfaceInfo;
		if (accessInfo != null) this.accessInfo = accessInfo;
		if (extra != null) this.extra = extra;
	}
	
	/**
	 * Constructor
	 * 
	 * @param vnfInfo VNF info this VIM connection info belongs to.
	 * @param vimConnectionInfoId The identifier of this VimConnectionInfo information element, for the purpose of referencing it from other information elements. This identifier is managed by the NFVO.
	 * @param vimId The identifier of the VIM. This identifier is managed by the NFVO.
	 * @param interfaceInfo Information about the interface(s) to the VIM, if available, including interface endpoint e.g. URL API version, and protocol type.
	 * @param accessInfo Authentication credentials for accessing the VIM. Examples can include those to support different authentication schemes, e.g. OAuth, Token, Username/password, etc.
	 * @param extra VIM type specific additional information, if applicable.
	 */
	public VimConnectionInfo(VnfInfo vnfInfo,
			String vimConnectionInfoId, 
			String vimId,
			List<String> interfaceInfo,
			List<String> accessInfo,
			List<String> extra) {
		this.vnfInfo = vnfInfo;
		this.vimConnectionInfoId = vimConnectionInfoId;
		this.vimId = vimId;
		if (interfaceInfo != null) this.interfaceInfo = interfaceInfo;
		if (accessInfo != null) this.accessInfo = accessInfo;
		if (extra != null) this.extra = extra;
	}
	
	/**
	 * @return the vimId
	 */
	public String getVimId() {
		return vimId;
	}
	
	

	/**
	 * @return the vimConnectionInfoId
	 */
	public String getVimConnectionInfoId() {
		return vimConnectionInfoId;
	}

	/**
	 * @return the interfaceInfo
	 */
	public List<String> getInterfaceInfo() {
		return interfaceInfo;
	}

	/**
	 * @return the accessInfo
	 */
	public List<String> getAccessInfo() {
		return accessInfo;
	}

	/**
	 * @return the extra
	 */
	public List<String> getExtra() {
		return extra;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vimConnectionInfoId == null) throw new MalformattedElementException("VIM Connection info without VIM connection info ID");
	}

}
