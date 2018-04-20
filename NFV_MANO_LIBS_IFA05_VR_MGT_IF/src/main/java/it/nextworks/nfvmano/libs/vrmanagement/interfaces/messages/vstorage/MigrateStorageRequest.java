package it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vstorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.AffinityConstraint;

/**
 * Request to migrate a virtual storage resource. 
 * 
 * REF IFA 005 v2.3.1 - sect. 7.5.1.8
 * 
 * @author nextworks
 *
 */
public class MigrateStorageRequest implements InterfaceMessage {

	private String storageId;
	private List<AffinityConstraint> affinityConstraint = new ArrayList<>();
	private List<AffinityConstraint> antiAffinityConstraint = new ArrayList<>();
	private Map<String, String> migrationConstraint = new HashMap<>();
	
	public MigrateStorageRequest() { }


	/**
	 * Constructor 
	 *  
	 * @param storageId Identifier of the virtualised storage resource to migrate.
	 * @param affinityConstraint Element with affinity information of the virtualised compute resource to migrate. This information is only necessary if the VIM needs to maintain affinity during the migration operation based on a list of resources.
	 * @param antiAffinityConstraint Element with anti-affinity information of the virtualised compute resource to migrate. This information is only necessary if the VIM needs to maintain anti-affinity during the migration operation based on a list of resources.
	 * @param migrationConstraint When present, the migration constraint parameter gives indications on where to migrate the virtualised storage resource, e.g. to a specific Resource Zone or to a specific host.
	 */
	public MigrateStorageRequest(String storageId, List<AffinityConstraint> affinityConstraint,
			List<AffinityConstraint> antiAffinityConstraint, Map<String, String> migrationConstraint) {
		this.storageId = storageId;
		if (affinityConstraint != null) this.affinityConstraint = affinityConstraint;
		if (antiAffinityConstraint != null) this.antiAffinityConstraint = antiAffinityConstraint;
		if (migrationConstraint != null) this.migrationConstraint = migrationConstraint;
	}



	/**
	 * @return the storageId
	 */
	public String getStorageId() {
		return storageId;
	}



	/**
	 * @return the affinityConstraint
	 */
	public List<AffinityConstraint> getAffinityConstraint() {
		return affinityConstraint;
	}



	/**
	 * @return the antiAffinityConstraint
	 */
	public List<AffinityConstraint> getAntiAffinityConstraint() {
		return antiAffinityConstraint;
	}



	/**
	 * @return the migrationConstraint
	 */
	public Map<String, String> getMigrationConstraint() {
		return migrationConstraint;
	}



	@Override
	public void isValid() throws MalformattedElementException {
		if (storageId == null) throw new MalformattedElementException("Migrate storage request without storage ID.");
	}

}
