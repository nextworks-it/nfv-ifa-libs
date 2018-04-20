package it.nextworks.nfvmano.libs.descriptors.nsd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;


/**
 * The PnfProfile information element describes additional data for a given PNF instance used in a DF.
 * Ref. IFA 014 v2.3.1 - 6.3.6
 * 
 * @author nextworks
 *
 */
@Entity
public class PnfProfile implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private NsDf nsDf;
	
	private String pnfProfileId;
	private String pnfdId;
	
	//@OneToMany(fetch=FetchType.EAGER, mappedBy = "pnfProfile", cascade=CascadeType.ALL)
	@OneToMany(mappedBy = "pnfProfile", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<NsVirtualLinkConnectivity> nsVirtualLinkConnectivity = new ArrayList<>();
	
	public PnfProfile() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsDf NS deployment flavour this PNF profile belongs to
	 * @param pnfProfileId Identifier of this PnfProfile information element. It uniquely identifies a PnfProfile.
	 * @param pnfdId References a PNFD.
	 * @param nsVirtualLinkConnectivity Defines the connection information of the PNF, it contains connection relationship between a PNF connection point and a NS virtual Link.
	 */
	public PnfProfile(NsDf nsDf,
			String pnfProfileId,
			String pnfdId,
			List<NsVirtualLinkConnectivity> nsVirtualLinkConnectivity) {
		this.nsDf = nsDf;
		this.pnfdId = pnfdId;
		this.pnfProfileId = pnfProfileId;
		if (nsVirtualLinkConnectivity != null) this.nsVirtualLinkConnectivity = nsVirtualLinkConnectivity;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsDf NS deployment flavour this PNF profile belongs to
	 * @param pnfProfileId Identifier of this PnfProfile information element. It uniquely identifies a PnfProfile.
	 * @param pnfdId References a PNFD.
	 */
	public PnfProfile(NsDf nsDf,
			String pnfProfileId,
			String pnfdId) {
		this.nsDf = nsDf;
		this.pnfdId = pnfdId;
		this.pnfProfileId = pnfProfileId;
	}
	
	/**
	 * @return the pnfProfileId
	 */
	@JsonProperty("pnfProfileId")
	public String getPnfProfileId() {
		return pnfProfileId;
	}

	/**
	 * @return the pnfdId
	 */
	@JsonProperty("pnfdId")
	public String getPnfdId() {
		return pnfdId;
	}

	/**
	 * @return the nsVirtualLinkConnectivity
	 */
	@JsonProperty("pnfVirtualLinkConnectivity")
	public List<NsVirtualLinkConnectivity> getNsVirtualLinkConnectivity() {
		return nsVirtualLinkConnectivity;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.pnfdId == null) throw new MalformattedElementException("PNF profile without PNFD ID");
		if (this.pnfProfileId == null) throw new MalformattedElementException("PNF profile without profile ID");
		if ((this.nsVirtualLinkConnectivity == null) || (this.nsVirtualLinkConnectivity.isEmpty())) {
			throw new MalformattedElementException("PNF profile without NS VL connectivity");
		} else {
			for (NsVirtualLinkConnectivity vlc : this.nsVirtualLinkConnectivity) vlc.isValid();
		}
	}

}
