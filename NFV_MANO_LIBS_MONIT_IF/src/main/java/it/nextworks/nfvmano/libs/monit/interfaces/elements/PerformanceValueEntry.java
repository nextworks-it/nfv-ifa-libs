package it.nextworks.nfvmano.libs.monit.interfaces.elements;

import java.util.Date;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines a single performance value with its associated time stamp.
 * 
 * REF IFA 005 v2.1.1 - 8.5.7
 * REF IFA 013 v2.3.1 - 8.4.7
 * 
 * 
 * @author nextworks
 *
 */
public class PerformanceValueEntry implements InterfaceInformationElement {

	private Date timeStamp;
	private String performanceValue;
	
	public PerformanceValueEntry() { }
	
	/**
	 * Constructor
	 * 
	 * @param timeStamp Timestamp indicating when the data was collected.
	 * @param performanceValue Value of the metric collected.
	 */
	public PerformanceValueEntry(Date timeStamp,
			String performanceValue) {
		this.timeStamp = timeStamp;
		this.performanceValue = performanceValue;
	}

	
	
	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @return the performanceValue
	 */
	public String getPerformanceValue() {
		return performanceValue;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (timeStamp == null) throw new MalformattedElementException("Performance value without timestamp");
		if (performanceValue == null) throw new MalformattedElementException("Performance value without value");
	}

}
