package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.reservation;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;

/**
 * This clause describes the attributes for the VirtualisationContainerReservation information element.
 * 
 * REF IFA 005 v2.3.1 - 8.8.5.2
 * 
 * @author nextworks
 *
 */
public class VirtualisationContainerReservation implements InterfaceInformationElement {

	private String containerId;
	private VirtualComputeFlavour containerFlavour;
	
	public VirtualisationContainerReservation() {	}
	
	/**
	 * Constructor
	 * 
	 * @param containerId
	 * @param containerFlavour
	 */
	public VirtualisationContainerReservation(String containerId,
			VirtualComputeFlavour containerFlavour) {
		this.containerId = containerId;
		this.containerFlavour = containerFlavour;
	}

	
	
	/**
	 * @return the containerId
	 */
	public String getContainerId() {
		return containerId;
	}

	/**
	 * @return the containerFlavour
	 */
	public VirtualComputeFlavour getContainerFlavour() {
		return containerFlavour;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (containerId == null) throw new MalformattedElementException("Virtualisation container reservation without container ID");
		if (containerFlavour == null) throw new MalformattedElementException("Virtualisation container reservation without container flavour");
		else containerFlavour.isValid();
	}

}
