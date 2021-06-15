/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.libs.ifa.descriptors.nsd;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import it.nextworks.nfvmano.libs.ifa.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.ifa.common.elements.MonitoringParameter;
import it.nextworks.nfvmano.libs.ifa.common.exceptions.MalformattedElementException;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashMap;
import java.util.Map;

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

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name="monitoring_parameter_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MonitoringParameter monitoringParameter;


	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)

	//Out of the standard
	private Map<String, String> metricMetadata= new HashMap<>();
	
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
	 * Constructor
	 *
	 * @param nsd Network Service Descriptor this Monitoring Data refers to.
	 * @param vnfIndicatorInfo Uniquely identifies this VNF Indicator information element.
	 * @param monitoringParameter Specifies the virtualised resource related performance metric to be monitored on an NS level or VNF level.
	 */
	public MonitoredData(Nsd nsd,
						 VnfIndicatorData vnfIndicatorInfo,
						 MonitoringParameter monitoringParameter, Map<String, String> metricMetadata) {
		this.nsd = nsd;
		this.vnfIndicatorInfo = vnfIndicatorInfo;
		this.monitoringParameter = monitoringParameter;
		if(metricMetadata!=null) this.metricMetadata=metricMetadata;
	}

	public Map<String, String> getMetricMetadata() {
		return metricMetadata;
	}

	public void setMetricMetadata(Map<String, String> metricMetadata) {
		this.metricMetadata = metricMetadata;
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

	public void setNsd(Nsd nsd) {
		this.nsd = nsd;
	}

	public void setVnfIndicatorInfo(VnfIndicatorData vnfIndicatorInfo) {
		this.vnfIndicatorInfo = vnfIndicatorInfo;
	}

	public void setMonitoringParameter(MonitoringParameter monitoringParameter) {
		this.monitoringParameter = monitoringParameter;
	}
}
