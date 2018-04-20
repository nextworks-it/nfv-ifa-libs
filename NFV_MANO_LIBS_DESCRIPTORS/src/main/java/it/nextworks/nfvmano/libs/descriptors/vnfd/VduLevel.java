package it.nextworks.nfvmano.libs.descriptors.vnfd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VduLevel information element indicates for a given VDU 
 * in a given level the number of instances to deploy.
 * 
 *  REF. IFA-011 v2.3.1 - section 7.1.8.9
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VduLevel implements DescriptorInformationElement {

	private String vduId;
	private int numberOfInstances;
	
	public VduLevel() {	}
	
	/**
	 * Constructor
	 * 
	 * @param vduId Uniquely identifies a VDU.
	 * @param numberOfInstances Number of instances of VNFC based on this VDU to deploy for this level.
	 */
	public VduLevel(String vduId, int numberOfInstances) {	
		this.vduId = vduId;
		this.numberOfInstances = numberOfInstances;
	}
	
	

	/**
	 * @return the vduId
	 */
	@JsonProperty("vduId")
	public String getVduId() {
		return vduId;
	}

	/**
	 * @return the numberOfInstances
	 */
	@JsonProperty("numberOfInstances")
	public int getNumberOfInstances() {
		return numberOfInstances;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (vduId == null) throw new MalformattedElementException("VDU level without VDU ID");
	}

}
