package it.nextworks.nfvmano.libs.catalogues.interfaces.messages;

import it.nextworks.nfvmano.libs.catalogues.interfaces.enums.AppdChangeType;
import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.OperationalState;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This notification indicates a change of status in an AppD.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.3.3.4
 * Message not yet specified.
 * 
 * @author nextworks
 *
 */
public class AppPackageStateChangeNotification implements InterfaceMessage {

	private String appdInfoId;
	private AppdChangeType changeType;
	private OperationalState operationalState;
	private boolean deletionPending; 
	
	public AppPackageStateChangeNotification() { }
	
	/**
	 * Constructor
	 * 
	 * @param appdInfoId ID of the appd info
	 * @param changeType type of change in the appd info
	 * @param operationalState operational state of the appd
	 * @param deletionPending indicates if the appd is the deletion pending status
	 */
	public AppPackageStateChangeNotification(String appdInfoId,
			AppdChangeType changeType,
			OperationalState operationalState,
			boolean deletionPending) {
		this.appdInfoId = appdInfoId;
		this.changeType = changeType;
		this.operationalState = operationalState;
		this.deletionPending = deletionPending;
	}
	
	

	/**
	 * @return the appdInfoId
	 */
	public String getAppdInfoId() {
		return appdInfoId;
	}

	/**
	 * @return the changeType
	 */
	public AppdChangeType getChangeType() {
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
		if (this.appdInfoId == null) 
			throw new MalformattedElementException("AppD change notification without AppD info ID");
	}

}
