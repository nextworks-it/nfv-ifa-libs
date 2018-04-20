package it.nextworks.nfvmano.libs.monit.interfaces.elements;

import java.util.ArrayList;
import java.util.List;


import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element provides the details of the PM Job.
 * 
 * REF IFA 013 v2.3.1 - 8.4.3
 * REF IFA 007 v2.3.1 - 8.7.3
 * REF IFA 005 v2.1.1 - 8.5.3
 * 
 * @author nextworks
 *
 */
public class PmJob implements InterfaceInformationElement {

	private String pmJobId;
	private ObjectSelection objectSelector;
	private List<String> performanceMetric = new ArrayList<>();
	private List<String> performanceMetricGroup = new ArrayList<>();
	private int collectionPeriod;
	private int reportingPeriod;
	private String reportingBoundary;
	
	public PmJob() { }
	
	/**
	 * Constructor
	 * 
	 * @param pmJobId ID of the PM job
	 * @param objectSelector Defines the object instances for which performance information is requested to be collected.
	 * @param performanceMetric This defines the type of performance metric(s) for the specified object instances.
	 * @param performanceMetricGroup Group of performance metrics.
	 * @param collectionPeriod Specifies the periodicity at which the producer will collect performance information
	 * @param reportingPeriod Specifies the periodicity at which the producer will report to the consumer about performance
	 * @param reportingBoundary Identifies a boundary after which the reporting will stop.
	 */
	public PmJob(String pmJobId,
			ObjectSelection objectSelector,
			List<String> performanceMetric,
			List<String> performanceMetricGroup,
			int collectionPeriod,
			int reportingPeriod,
			String reportingBoundary) {
		this.pmJobId = pmJobId;
		this.objectSelector = objectSelector;
		if (performanceMetric != null) this.performanceMetric = performanceMetric;
		if (performanceMetricGroup != null) this.performanceMetricGroup = performanceMetricGroup;
		this.collectionPeriod = collectionPeriod;
		this.reportingBoundary = reportingBoundary;
		this.reportingPeriod = reportingPeriod;
	}
	
	

	/**
	 * @return the pmJobId
	 */
	public String getPmJobId() {
		return pmJobId;
	}

	/**
	 * @return the objectSelector
	 */
	public ObjectSelection getObjectSelector() {
		return objectSelector;
	}

	/**
	 * @return the performanceMetric
	 */
	public List<String> getPerformanceMetric() {
		return performanceMetric;
	}

	/**
	 * @return the performanceMetricGroup
	 */
	public List<String> getPerformanceMetricGroup() {
		return performanceMetricGroup;
	}

	/**
	 * @return the collectionPeriod
	 */
	public int getCollectionPeriod() {
		return collectionPeriod;
	}

	/**
	 * @return the reportingPeriod
	 */
	public int getReportingPeriod() {
		return reportingPeriod;
	}

	/**
	 * @return the reportingBoundary
	 */
	public String getReportingBoundary() {
		return reportingBoundary;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (pmJobId==null) throw new MalformattedElementException("PM job without ID");
		if (objectSelector==null) throw new MalformattedElementException("PM job without object selector");
		else objectSelector.isValid();
	}

}
