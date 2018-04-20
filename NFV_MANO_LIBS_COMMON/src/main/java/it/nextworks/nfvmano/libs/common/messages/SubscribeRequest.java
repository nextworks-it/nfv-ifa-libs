package it.nextworks.nfvmano.libs.common.messages;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;

/**
 * Generic message used for all the subscriptions
 * 
 * 
 * @author nextworks
 *
 */
public class SubscribeRequest implements InterfaceMessage {

	private Filter filter;
	private String callbackUri;
	
	public SubscribeRequest() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param filter Input filter for selecting the VNF Package(s) and the related change notifications to subscribe to.
	 * @param callbackUri  Uri to receive the notifications
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public SubscribeRequest(Filter filter, String callbackUri) throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		this.filter = filter;
		this.callbackUri = callbackUri;
	}
	
	

	/**
	 * @return the filter
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * @return the callbackUri
	 */
	public String getCallbackUri() {
		return callbackUri;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (callbackUri == null) 
			throw new MalformattedElementException("VNF package subscription request without callback URI");
		if (filter == null) 
			throw new MalformattedElementException("VNF package subscription request without filter");
	}

}
