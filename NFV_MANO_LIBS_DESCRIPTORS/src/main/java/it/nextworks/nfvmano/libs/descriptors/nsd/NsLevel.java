package it.nextworks.nfvmano.libs.descriptors.nsd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The NsLevel information element describes the details of an NS level. 
 * 
 * An NS level consists of a list of involved entities, i.e. VNFs, VLs and/or nested NSs. 
 * For each involved VNF/nested NS, the number of instances required by the NS level is specified. 
 * For each involved VL, the bitrate requirements corresponding to the NS level are specified.
 * 
 * Ref. IFA 014 v2.3.1 - 6.3.9
 * 
 * 
 * @author nextworks
 *
 */
@Entity
public class NsLevel implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private NsDf nsDf;
	
	@JsonIgnore
	@ManyToOne
	private NsScalingAspect nsScale;
	
	private String nsLevelId;
	private String description;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<VnfToLevelMapping> vnfToLevelMapping = new ArrayList<>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<NsToLevelMapping> nsToLevelMapping = new ArrayList<>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "nsLevel", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<VirtualLinkToLevelMapping> virtualLinkToLevelMapping = new ArrayList<>();
	
	public NsLevel() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsScale NS scaling aspect this NS level belongs to
	 * @param nsLevelId Identifier of this NsLevel information element. It uniquely identifies an NS level within the DF.
	 * @param description Human readable description of the NS level.
	 * @param vnfToLevelMapping Specifies the profile of the VNFs involved in this NS level and, for each of them, the required number of instances.
	 * @param nsToLevelMapping Specifies the profile of the nested NSes involved in this NS level
	 * 
	 */
	public NsLevel(NsScalingAspect nsScale,
			String nsLevelId,
			String description,
			List<VnfToLevelMapping> vnfToLevelMapping,
			List<NsToLevelMapping> nsToLevelMapping) {
		this.nsScale = nsScale;
		this.nsLevelId = nsLevelId;
		this.description = description;
		if (vnfToLevelMapping != null) this.vnfToLevelMapping = vnfToLevelMapping;
		if (nsToLevelMapping != null) this.nsToLevelMapping = nsToLevelMapping;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsDf NS deployment flavour this NS level belongs to
	 * @param nsLevelId Identifier of this NsLevel information element. It uniquely identifies an NS level within the DF.
	 * @param description Human readable description of the NS level.
	 * @param vnfToLevelMapping Specifies the profile of the VNFs involved in this NS level and, for each of them, the required number of instances.
	 * @param nsToLevelMapping Specifies the profile of the nested NSes involved in this NS level
	 * 
	 */
	public NsLevel(NsDf nsDf,
			String nsLevelId,
			String description,
			List<VnfToLevelMapping> vnfToLevelMapping,
			List<NsToLevelMapping> nsToLevelMapping) {
		this.nsDf = nsDf;
		this.nsLevelId = nsLevelId;
		this.description = description;
		if (vnfToLevelMapping != null) this.vnfToLevelMapping = vnfToLevelMapping;
		if (nsToLevelMapping != null) this.nsToLevelMapping = nsToLevelMapping;
	}

	
	
	/**
	 * @return the nsLevelId
	 */
	@JsonProperty("nsLevelId")
	public String getNsLevelId() {
		return nsLevelId;
	}

	/**
	 * @return the description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	/**
	 * @return the vnfToLevelMapping
	 */
	@JsonProperty("vnfToLevelMapping")
	public List<VnfToLevelMapping> getVnfToLevelMapping() {
		return vnfToLevelMapping;
	}

	/**
	 * @return the nsToLevelMapping
	 */
	@JsonProperty("nsToLevelMapping")
	public List<NsToLevelMapping> getNsToLevelMapping() {
		return nsToLevelMapping;
	}

	/**
	 * @return the virtualLinkToLevelMapping
	 */
	@JsonProperty("virtualLinkToLevelMapping")
	public List<VirtualLinkToLevelMapping> getVirtualLinkToLevelMapping() {
		return virtualLinkToLevelMapping;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.nsLevelId == null) throw new MalformattedElementException("NS level without ID");
		if (this.description == null) throw new MalformattedElementException("NS level without description");
		boolean noVnfMap = false;
		boolean noNsMap = false;
		boolean noVlMap = false;
		if ((this.vnfToLevelMapping == null) || (this.vnfToLevelMapping.isEmpty())) {
			noVnfMap = true;
		} else {
			for (VnfToLevelMapping map : this.vnfToLevelMapping) map.isValid();
		}
		if ((this.nsToLevelMapping == null) || (this.nsToLevelMapping.isEmpty())) {
			noNsMap = true;
		} else {
			for (NsToLevelMapping map : this.nsToLevelMapping) map.isValid();
		}
		if ((this.virtualLinkToLevelMapping == null) || (this.virtualLinkToLevelMapping.isEmpty())) {
			noVlMap = true;
		} else {
			for (VirtualLinkToLevelMapping map : this.virtualLinkToLevelMapping) map.isValid();
		}
		if (noNsMap && noVnfMap && noVlMap) throw new MalformattedElementException("NS level without any mapping declared");
	}

}
