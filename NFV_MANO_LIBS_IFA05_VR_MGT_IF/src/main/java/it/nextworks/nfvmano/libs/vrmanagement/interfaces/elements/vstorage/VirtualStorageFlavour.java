package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The VirtualStorageFlavour information element encapsulates information 
 * for storage flavours. A storage flavour includes information about the 
 * size of the storage, and the type of storage.
 * 
 *  REF IFA 005 v2.3.1 - sect. 8.4.6.2
 * 
 * @author nextworks
 *
 */
public class VirtualStorageFlavour implements InterfaceInformationElement {

	private String flavourId;
	private VirtualStorageData storageAttributes;
	
	public VirtualStorageFlavour() { }
	
	/**
	 * Constructor
	 * 
	 * @param flavourId Identifier of the storage flavour.
	 * @param storageAttributes Element containing information about the size of virtualised storage resource (e.g. size of volume, in GB), the type of storage (e.g. volume, object), and support for RDMA
	 */
	public VirtualStorageFlavour(String flavourId, 
			VirtualStorageData storageAttributes) {
		this.flavourId = flavourId;
		this.storageAttributes = storageAttributes;
	}



	/**
	 * @return the flavourId
	 */
	public String getFlavourId() {
		return flavourId;
	}

	/**
	 * @return the storageAttributes
	 */
	public VirtualStorageData getStorageAttributes() {
		return storageAttributes;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (flavourId == null) throw new MalformattedElementException("Virtual storage flavour without ID");
		if (storageAttributes == null) throw new MalformattedElementException("Virtual storage flavour without attributes");
		else storageAttributes.isValid();
	}

}
