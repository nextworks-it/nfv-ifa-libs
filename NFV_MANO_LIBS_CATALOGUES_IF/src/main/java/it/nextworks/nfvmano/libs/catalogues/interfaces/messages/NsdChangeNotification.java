package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.catalogues.interfaces.enums.NsdChangeType;
import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.OperationalState;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;


/**
 * This notification indicates a change of status in an NSD. 
 * Only changes in operational state and deletion pending attribute will be reported, 
 * change in usage state is not reported.
 * 
 * It is produced in case of: 
 * 1. Change of the status (operational state and deletion pending) of an on-boarded NSD
 * 2. Deletion of an NSD
 * 
 * Ref. IFA 013 v2.3.1 - 8.2.7
 * 
 * @author nextworks
 *
 */
public class NsdChangeNotification implements InterfaceMessage {

	private String nsdInfoId;
	private NsdChangeType changeType;
	private OperationalState operationalState;
	private boolean deletionPending;
	
	public NsdChangeNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param nsdInfoId Identifier of the on-boarded instance of the NSD.
	 * @param changeType It categorizes the type of change.
	 * @param operationalState New operational state of the NSD. Only present when changeType is "change of operational state".
	 * @param deletionPending Indicates if the deletion instance of the NSD has been requested but the NSD still being used by instantiated NSs. Only present when changeType is "NSD in deletion pending".
	 */
	public NsdChangeNotification(String nsdInfoId,
			NsdChangeType changeType,
			OperationalState operationalState,
			boolean deletionPending) {
		this.nsdInfoId = nsdInfoId;
		this.changeType = changeType;
		this.deletionPending = deletionPending;
		this.operationalState = operationalState;
	}
	
	

	/**
	 * @return the nsdInfoId
	 */
	public String getNsdInfoId() {
		return nsdInfoId;
	}

	/**
	 * @return the changeType
	 */
	public NsdChangeType getChangeType() {
		return changeType;
	}

	/**
	 * @return the operationalState
	 */
	public OperationalState getOperationalState() {
		return operationalState;
	}

	/**
	 * @return the deletionPending
	 */
	public boolean isDeletionPending() {
		return deletionPending;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.nsdInfoId == null) 
			throw new MalformattedElementException("NSD change notification without NSD info ID");
	}

}
