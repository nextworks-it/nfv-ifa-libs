package it.nextworks.nfvmano.libs.descriptors.nsd;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.elements.MonitoringParameter;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The MonitoredData information element identifies information to be monitored 
 * during the lifetime of a network service instance.
 * Ref. IFA 014 v2.3.1 - 6.2.6
 * 
 * @author nextworks
 *
 */
@Entity
public class MonitoredData implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Nsd nsd;
	
	@Embedded
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private VnfIndicatorData vnfIndicatorInfo;
	
	@Embedded
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MonitoringParameter monitoringParameter;
	
	public MonitoredData() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsd Network Service Descriptor this Monitoring Data refers to.
	 * @param vnfIndicatorInfo Uniquely identifies this VNF Indicator information element.
	 * @param monitoringParameter Specifies the virtualised resource related performance metric to be monitored on an NS level or VNF level.
	 */
	public MonitoredData(Nsd nsd,
			VnfIndicatorData vnfIndicatorInfo,
			MonitoringParameter monitoringParameter) {
		this.nsd = nsd;
		this.vnfIndicatorInfo = vnfIndicatorInfo;
		this.monitoringParameter = monitoringParameter;
	}
	
	/**
	 * @return the vnfIndicatorInfo
	 */
	@JsonProperty("vnfIndicatorInfo")
	public VnfIndicatorData getVnfIndicatorInfo() {
		return vnfIndicatorInfo;
	}

	/**
	 * @return the monitoringParameter
	 */
	@JsonProperty("monitoringParameter")
	public MonitoringParameter getMonitoringParameter() {
		return monitoringParameter;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		//One and only one of the attributes shall be included 
		//(i.e. there is a XOR relationship between the attributes).
		if ((this.vnfIndicatorInfo != null) && (this.monitoringParameter != null)) 
			throw new MalformattedElementException("Monitored data with both VNF Indicator info and Monitoring Parameter");
		if (this.vnfIndicatorInfo != null) this.vnfIndicatorInfo.isValid();
		if (this.monitoringParameter != null) this.monitoringParameter.isValid();
	}

}
