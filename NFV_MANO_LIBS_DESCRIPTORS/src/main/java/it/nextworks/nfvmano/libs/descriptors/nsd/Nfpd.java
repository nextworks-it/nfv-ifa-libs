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
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.Rule;


/**
 * The Nfpd (Network Forwarding Path Descriptor) 
 * information element associates traffic 
 * flow criteria to a list of descriptors associated 
 * to the connection points and service access points 
 * to be visited by traffic flows matching these criteria.
 * 
 * Ref. IFA 014 v2.3.1 - 6.4.3
 * 
 * @author nextworks
 *
 */
@Entity
public class Nfpd implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Vnffgd fg;
	
	private String nfpId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(fetch=FetchType.EAGER, mappedBy = "nfpd", cascade=CascadeType.ALL, orphanRemoval=true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Rule nfpRule;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> cpd = new ArrayList<>();
	
	public Nfpd() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param fg NS forwarding graph this nfpd belongs to
	 * @param nfpId Identifies this nfpd information element within a VNFFGD.
	 * @param nfpRule Provides an NFP classification and selection rule. The rule may be expressed as a criteria constructed out of atomic assertions linked by Boolean operators AND, OR and NOT. Examples of atomic assertions are assertions on packet header fields’ values, date and time ranges, etc.
	 * @param cpd References the descriptor of a connection point to be traversed by the traffic flows matching the criteria. When multiple values are provided, the order is significant and specifies the sequence of connection points to be traversed
	 */
	public Nfpd(Vnffgd fg,
			String nfpId,
			Rule nfpRule,
			List<String> cpd) {
		this.fg  = fg;
		this.nfpId = nfpId;
		this.nfpRule = nfpRule;
		if (cpd != null) this.cpd = cpd;
	}
	
	/**
	 * Constructor
	 * 
	 * @param fg NS forwarding graph this nfpd belongs to
	 * @param nfpId Identifies this nfpd information element within a VNFFGD.
	 * @param cpd References the descriptor of a connection point to be traversed by the traffic flows matching the criteria. When multiple values are provided, the order is significant and specifies the sequence of connection points to be traversed
	 */
	public Nfpd(Vnffgd fg,
			String nfpId,
			List<String> cpd) {
		this.fg  = fg;
		this.nfpId = nfpId;
		if (cpd != null) this.cpd = cpd;
	}
	
	

	/**
	 * @return the nfpId
	 */
	@JsonProperty("nfpId")
	public String getNfpId() {
		return nfpId;
	}

	/**
	 * @return the nfpRule
	 */
	@JsonProperty("nfpRule")
	public Rule getNfpRule() {
		return nfpRule;
	}

	/**
	 * @return the cpd
	 */
	@JsonProperty("cpd")
	public List<String> getCpd() {
		return cpd;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.nfpId == null) throw new MalformattedElementException("NFDP without ID");
		if (this.nfpRule != null) this.nfpRule.isValid();
		if ((this.cpd == null) || (this.cpd.isEmpty())) {
			throw new MalformattedElementException("NFDP without CPD");
		}
	}

}
