package it.nextworks.nfvmano.libs.monit.interfaces.elements;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines the format of a performance report 
 * provided by the producer to the consumer on a specified object instance 
 * or a set of them. The object instances for this information element will 
 * be virtualised resources.
 * 
 * REF IFA 005 v2.1.1 - 8.5.5
 * REF IFA 013 v2.3.1 - 8.4.5
 * 
 * @author nextworks
 *
 */
public class PerformanceReport implements InterfaceInformationElement {

	private List<PerformanceReportEntry> performanceReportEntry = new ArrayList<>();
	
	public PerformanceReport() { }
	
	/**
	 * Constructor
	 * 
	 * @param performanceReportEntry List of performance information entries.
	 */
	public PerformanceReport(List<PerformanceReportEntry> performanceReportEntry) { 
		if (performanceReportEntry != null) this.performanceReportEntry = performanceReportEntry;
	}
	
	

	/**
	 * @return the performanceReportEntry
	 */
	public List<PerformanceReportEntry> getPerformanceReportEntry() {
		return performanceReportEntry;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if ( (performanceReportEntry == null) || (performanceReportEntry.isEmpty())) throw new MalformattedElementException("Performance report without entries");
		else {
			for (PerformanceReportEntry e : performanceReportEntry) e.isValid();
		}
	}

}
