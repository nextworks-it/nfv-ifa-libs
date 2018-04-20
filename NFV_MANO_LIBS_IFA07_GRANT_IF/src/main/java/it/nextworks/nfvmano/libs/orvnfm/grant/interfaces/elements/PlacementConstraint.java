package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.AffinityScope;
import it.nextworks.nfvmano.libs.common.enums.AffinityType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information regarding a resource placement constraint. 
 * A set of such constraints may be sent by the VNFM to the NFVO to influence the resource 
 * placement decisions made by the NFVO as part of the granting process. 
 * A placement constraint defines a condition to the placement of new resources, considering 
 * other new resources as well as existing resources.
 * 
 * REF IFA 007 v2.3.1 - 8.3.6
 * 
 * @author nextworks
 *
 */
public class PlacementConstraint implements InterfaceInformationElement {

	private AffinityType affinityOrAntiAffinity;
	private AffinityScope scope;
	private List<ConstraintResourceRef> resource = new ArrayList<>();
	
	public PlacementConstraint() { }
	
	/**
	 * Constructor
	 * 
	 * @param affinityOrAntiAffinity The type of the constraint
	 * @param scope The scope of the placement constraint indicating the category of the "place" where the constraint applies.
	 * @param resource References to resources in the constraint rule.
	 */
	public PlacementConstraint(AffinityType affinityOrAntiAffinity,
			AffinityScope scope,
			List<ConstraintResourceRef> resource) {
		this.affinityOrAntiAffinity = affinityOrAntiAffinity;
		this.scope = scope;
		if (resource != null) this.resource = resource;
	}
	
	

	/**
	 * @return the affinityOrAntiAffinity
	 */
	public AffinityType getAffinityOrAntiAffinity() {
		return affinityOrAntiAffinity;
	}

	/**
	 * @return the scope
	 */
	public AffinityScope getScope() {
		return scope;
	}

	/**
	 * @return the resource
	 */
	public List<ConstraintResourceRef> getResource() {
		return resource;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (resource.isEmpty()) throw new MalformattedElementException("Placement constraint without resources");
		else for (ConstraintResourceRef ref : resource) ref.isValid();
	}

}
