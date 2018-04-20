package it.nextworks.nfvmano.libs.descriptors.common.elements;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.CpRole;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The Cpd information element specifies the characteristics of connection points 
 * attached to NFs and NSs. 
 * Ref. IFA 014 v2.3.1 - 6.6.3
 * Ref. IFA 011 v2.3.1 - 7.1.6.3
 * 
 * @author nextworks
 *
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="CONNPOINT_TYPE")
public class Cpd implements DescriptorInformationElement {

	@Id
	@GeneratedValue
	@JsonIgnore
	public Long id;
	
	private String cpdId;
	private LayerProtocol layerProtocol;		//Note: in IFA 14 there is a list of layer protocol, in IFA 11 a single one. IFA 14 is probably wrong.
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private CpRole cpRole;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<AddressData> addressData = new ArrayList<AddressData>();	//Note: this is in IFA 11, not in IFA 14
	
	public Cpd() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param cpdId Identifier of this Cpd information element.
	 * @param layerProtocol Identifies a protocol that the connection points corresponding to the CPD support for connectivity purposes (e.g. Ethernet, MPLS, ODU2, IPV4, IPV6, Pseudo-Wire, etc.).
	 * @param cpRole Identifies the role of the connection points corresponding to the CPD in the context of the traffic flow patterns in the VNF, PNF or NS.
	 * @param description Human-readable information on the purpose of the connection point
	 * @param addressData Provides information on the addresses to be assigned to the CP(s) instantiated from this CPD.
	 */
	public Cpd(String cpdId,
			LayerProtocol layerProtocol,
			CpRole cpRole,
			String description,
			List<AddressData> addressData) {
		this.cpdId = cpdId;
		this.layerProtocol = layerProtocol;
		this.cpRole = cpRole;
		this.description = description;
		if (addressData != null) this.addressData = addressData;
	}
	
	

	/**
	 * @return the cpdId
	 */
	@JsonProperty("cpdId")
	public String getCpdId() {
		return cpdId;
	}

	/**
	 * @return the layerProtocol
	 */
	@JsonProperty("layerProtocol")
	public LayerProtocol getLayerProtocol() {
		return layerProtocol;
	}

	/**
	 * @return the cpRole
	 */
	@JsonProperty("cpRole")
	public CpRole getCpRole() {
		return cpRole;
	}

	/**
	 * @return the description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	
	

	/**
	 * @return the addressData
	 */
	@JsonProperty("addressData")
	public List<AddressData> getAddressData() {
		return addressData;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.cpdId == null) throw new MalformattedElementException("CPD without ID");
		if (this.layerProtocol == null) throw new MalformattedElementException("CPD without layer protocol");
		for (AddressData a : addressData) a.isValid();
	}

}
