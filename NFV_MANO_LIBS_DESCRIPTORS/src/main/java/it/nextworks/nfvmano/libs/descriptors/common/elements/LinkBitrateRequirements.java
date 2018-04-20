package it.nextworks.nfvmano.libs.descriptors.common.elements;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The LinkBitrateRequirements information element 
 * describes the requirements in terms of bitrate for a VL.
 * 
 * Ref. IFA 014 v2.3.1 - 6.5.5
 * 
 * @author nextworks
 *
 */
@Embeddable
public class LinkBitrateRequirements implements DescriptorInformationElement {

	private String root;
	private String leaf;
	
	public LinkBitrateRequirements() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param root Specifies the throughput requirement of the link (e.g. bitrate of E-Line, root bitrate of E-Tree, aggregate capacity of E-LAN).
	 * @param leaf Specifies the throughput requirement of leaf connections to the link when applicable to the connectivity type (e.g. for E-Tree andE-LAN branches).
	 */
	public LinkBitrateRequirements(String root, String leaf) {
		this.root = root;
		this.leaf = leaf;
	}

	
	
	/**
	 * @return the root
	 */
	@JsonProperty("root")
	public String getRoot() {
		return root;
	}

	/**
	 * @return the leaf
	 */
	@JsonProperty("leaf")
	public String getLeaf() {
		return leaf;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
