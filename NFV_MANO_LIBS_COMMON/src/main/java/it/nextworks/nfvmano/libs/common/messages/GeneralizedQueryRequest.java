package it.nextworks.nfvmano.libs.common.messages;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * Generalized query request message
 * 
 * @author nextworks
 *
 */
public class GeneralizedQueryRequest implements InterfaceMessage {

	private Filter filter;
	private List<String> attributeSelector = new ArrayList<>();
	
	public GeneralizedQueryRequest() {	}
	
	/**
	 * Constructor
	 * 
	 * @param filter Filter defining the entities on which the query applies, based on their attributes or identifiers.
	 * @param attributeSelector Provides a list of attribute names of the entity. If present, only these attributes are returned.
	 */
	public GeneralizedQueryRequest(Filter filter,
			List<String> attributeSelector) {
		this.filter = filter;
		if (attributeSelector != null) this.attributeSelector = attributeSelector;
	}

	/**
	 * @return the filter
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * @return the attributeSelector
	 */
	public List<String> getAttributeSelector() {
		return attributeSelector;
	}
	
	@Override
	public void isValid() throws MalformattedElementException {
		if (this.filter == null) 
			throw new MalformattedElementException("NSD query request without filter");
	}

}
