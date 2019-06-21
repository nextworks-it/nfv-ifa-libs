package it.nextworks.nfvmano.libs.descriptors.nsd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Information element defining a scaling rule for a NS.
 * This is not standard, since not specified in IFA so far.
 * This version is inspired by OSM information model.
 * 
 * @author nextworks
 *
 */
@Entity
public class NsAutoscalingRule implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Nsd nsd;
	
	private String ruleId;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy = "rule", cascade=CascadeType.ALL, orphanRemoval=true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AutoscalingRuleCondition ruleConditions;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "rule", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AutoscalingAction> ruleActions = new ArrayList<>();
	
	public NsAutoscalingRule() {
		// JPA only
	}
	
	public NsAutoscalingRule(Nsd nsd, String ruleId) {
		this.nsd = nsd;
		this.ruleId = ruleId;
	}

	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}

	/**
	 * @return the ruleConditions
	 */
	public AutoscalingRuleCondition getRuleConditions() {
		return ruleConditions;
	}

	/**
	 * @return the ruleActions
	 */
	public List<AutoscalingAction> getRuleActions() {
		return ruleActions;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (ruleId == null) throw new MalformattedElementException("Autoscaling rule without ID");
		if (this.ruleConditions == null) 
			throw new MalformattedElementException("Autoscaling rule without conditions"); 
			else ruleConditions.isValid();
		if ((this.ruleActions == null) || (this.ruleActions.isEmpty())) 
			throw new MalformattedElementException("Autoscaling rule without actions"); 
			else for (AutoscalingAction aa : ruleActions) aa.isValid();
	}

}
