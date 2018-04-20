package it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides information regarding a VIM selection constraint. 
 * A set of such constraints may be sent by the VNFM to the NFVO to influence the VIM 
 * selection decisions made by the NFVO as part of the granting process.
 * 
 * REF IFA 007 v2.3.1 - 8.3.7
 * 
 * @author nextworks
 *
 */
public class VimConstraint implements InterfaceInformationElement {

	private boolean sameResourceGroup;
	private List<ConstraintResourceRef> resource = new ArrayList<>();
	
	public VimConstraint() { }
	
	/**
	 * Constructor
	 * 
	 * @param sameResourceGroup If present and set to true, this signals that the constraint applies not only to the same VIM connection, but also to the same infrastructure resource group.
	 * @param resource References to resources in the constraint rule. The NFVO shall ensure that all resources in this list are managed by the same VIM.
	 */
	public VimConstraint(boolean sameResourceGroup,
			List<ConstraintResourceRef> resource) {
		this.sameResourceGroup = sameResourceGroup;
		if (resource != null) this.resource = resource;
	}

	
	
	/**
	 * @return the sameResourceGroup
	 */
	@JsonProperty("sameResourceGroup")
	public boolean isSameResourceGroup() {
		return sameResourceGroup;
	}

	/**
	 * @return the resource
	 */
	public List<ConstraintResourceRef> getResource() {
		return resource;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (resource.isEmpty()) throw new MalformattedElementException("VIM constraint without resources");
		else for (ConstraintResourceRef ref : resource) ref.isValid();
	}

}
