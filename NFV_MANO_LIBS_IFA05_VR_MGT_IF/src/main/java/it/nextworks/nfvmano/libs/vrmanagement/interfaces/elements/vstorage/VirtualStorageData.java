package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage;

import javax.persistence.Embeddable;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * 
 * REF IFA 005 v2.3.1 - 8.4.6.3
 * 
 * @author nextworks
 *
 */
@Embeddable
public class VirtualStorageData implements DescriptorInformationElement {

	private String typeOfStorage;
	private int sizeOfStorage;
	
	public VirtualStorageData() { }
	
	/**
	 * Constructor
	 * 
	 * @param typeOfStorage Type of virtualised storage resource (e.g. volume, object)
	 * @param sizeOfStorage Size of virtualised storage resource (e.g. size of volume, in GB).
	 * 
	 */
	public VirtualStorageData(String typeOfStorage,
			int sizeOfStorage) { 
		this.typeOfStorage = typeOfStorage;
		this.sizeOfStorage = sizeOfStorage;
	}

	
	/**
	 * @return the typeOfStorage
	 */
	public String getTypeOfStorage() {
		return typeOfStorage;
	}

	/**
	 * @return the sizeOfStorage
	 */
	public int getSizeOfStorage() {
		return sizeOfStorage;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (typeOfStorage == null) throw new MalformattedElementException("Virtual Storage Data without type of storage");
	}

}
