package it.nextworks.nfvmano.libs.monit.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.monit.interfaces.enums.MonitoringObjectType;

/**
 * This information element allows to specify NFV entities on which 
 * performance information will be provided.
 * 
 * The ObjectSelection is a pattern to select object instances.
 * The pattern is used in multiple interfaces (IFA 13, IFA 5, ...).
 * 
 * In IFA-13, the ObjectSelection pattern is used to select NS instances.
 * 
 * The pattern proposes 2 exclusive options:
 * 1) Provide a list of object types and a filter to specify object properties.
 * 2) Provide a list of object instances.
 * 
 * In IFA-13, the object type will be NS and the filter based on some NS properties.
 * In IFA-07, the object type will be VNF and the filter based on some VNF properties.
 * 
 * REF IFA 005 v2.1.1 - 8.5.2
 * REF IFA 013 v2.3.1 - 8.4.2
 * REF IFA 007 v2.3.1 - 8.7.2
 * 
 * @author nextworks
 *
 */
public class ObjectSelection implements InterfaceInformationElement {

	private List<MonitoringObjectType> objectType = new ArrayList<>();
	private Filter objectFilter;
	private List<String> objectInstanceId = new ArrayList<>();
	
	public ObjectSelection() { }
	
	/**
	 * Constructor
	 * 
	 * @param objectType Provide the object type
	 * @param objectFilter The filter will apply on the object types to specify on which object instances the performance information is requested to be collected.
	 * @param objectInstanceId Identifies the object instances for which performance information is requested to be collected.
	 */
	public ObjectSelection(List<MonitoringObjectType> objectType,
			Filter objectFilter,
			List<String> objectInstanceId) {
		if (objectType != null) this.objectType = objectType;
		this.objectFilter = objectFilter;
		if (objectInstanceId != null) this.objectInstanceId = objectInstanceId;
	}

	
	
	/**
	 * @return the objectType
	 */
	public List<MonitoringObjectType> getObjectType() {
		return objectType;
	}

	/**
	 * @return the objectFilter
	 */
	public Filter getObjectFilter() {
		return objectFilter;
	}

	/**
	 * @return the objectInstanceId
	 */
	public List<String> getObjectInstanceId() {
		return objectInstanceId;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ((objectType == null) || (objectType.isEmpty())) throw new MalformattedElementException("Object selection without type");
		if ((objectFilter == null) && ((objectInstanceId == null) || (objectInstanceId.isEmpty()))) throw new MalformattedElementException("Object selection without filter and without IDs");
	}

}
