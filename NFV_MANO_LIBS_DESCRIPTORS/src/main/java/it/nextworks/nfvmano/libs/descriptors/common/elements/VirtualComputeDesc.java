package it.nextworks.nfvmano.libs.descriptors.common.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.elements.VirtualCpuData;
import it.nextworks.nfvmano.libs.common.elements.VirtualMemoryData;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.appd.Appd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.RequestedAdditionalCapabilityData;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;

/**
 * The VirtualComputeDesc information element supports 
 * the specification of requirements related to virtual compute resources.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.9.2.2
 * 
 * @author nextworks
 *
 */
@Entity
public class VirtualComputeDesc implements InterfaceMessage {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Vnfd vnfd;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JsonIgnore
	@JoinColumn(name="appd_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Appd appd;
	
	private String virtualComputeDescId;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> logicalNode = new HashMap<>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<RequestedAdditionalCapabilityData> requestAdditionalCapabilities = new ArrayList<>();
	
	@Embedded
	private VirtualMemoryData virtualMemory;
	 
	@Embedded
	private VirtualCpuData virtualCpu;
	
	public VirtualComputeDesc() { }
	
	/**
	 * Constructor
	 * 
	 * @param vnfd VNFD this virtual compute descriptor belongs to
	 * @param virtualComputeDescId Unique identifier of this VirtualComputeDesc in the VNFD.
	 * @param logicalNode The logical Node requirements.
	 * @param requestAdditionalCapabilities Specifies requirements for additional capabilities.
	 * @param virtualCpu The virtual CPU(s) of the virtualised compute.
	 * @param virtualMemory The virtual memory of the virtualised compute.
	 */
	public VirtualComputeDesc(Vnfd vnfd,
			String virtualComputeDescId,
			Map<String, String> logicalNode,
			List<RequestedAdditionalCapabilityData> requestAdditionalCapabilities,
			VirtualCpuData virtualCpu,
			VirtualMemoryData virtualMemory) {
		this.vnfd = vnfd;
		this.virtualComputeDescId = virtualComputeDescId;
		if (logicalNode != null) this.logicalNode = logicalNode;
		if (requestAdditionalCapabilities != null) this.requestAdditionalCapabilities = requestAdditionalCapabilities;
		this.virtualCpu = virtualCpu;
		this.virtualMemory = virtualMemory;
	}
	
	/**
	 * Constructor
	 * 
	 * @param appd AppD this virtual compute descriptor belongs to
	 * @param virtualComputeDescId Unique identifier of this VirtualComputeDesc in the VNFD.
	 * @param logicalNode The logical Node requirements.
	 * @param requestAdditionalCapabilities Specifies requirements for additional capabilities.
	 * @param virtualCpu The virtual CPU(s) of the virtualised compute.
	 * @param virtualMemory The virtual memory of the virtualised compute.
	 */
	public VirtualComputeDesc(Appd appd,
			String virtualComputeDescId,
			Map<String, String> logicalNode,
			List<RequestedAdditionalCapabilityData> requestAdditionalCapabilities,
			VirtualCpuData virtualCpu,
			VirtualMemoryData virtualMemory) {
		this.appd = appd;
		this.virtualComputeDescId = virtualComputeDescId;
		if (logicalNode != null) this.logicalNode = logicalNode;
		if (requestAdditionalCapabilities != null) this.requestAdditionalCapabilities = requestAdditionalCapabilities;
		this.virtualCpu = virtualCpu;
		this.virtualMemory = virtualMemory;
	}
	
	

	/**
	 * @return the virtualComputeDescId
	 */
	@JsonProperty("virtualComputeDescId")
	public String getVirtualComputeDescId() {
		return virtualComputeDescId;
	}

	
	/**
	 * @return the logicalNode
	 */
	@JsonProperty("logicalNode")
	public Map<String, String> getLogicalNode() {
		return logicalNode;
	}

	/**
	 * @return the requestAdditionalCapabilities
	 */
	@JsonProperty("requestAdditionalCapabilities")
	public List<RequestedAdditionalCapabilityData> getRequestAdditionalCapabilities() {
		return requestAdditionalCapabilities;
	}

	/**
	 * @return the virtualMemory
	 */
	@JsonProperty("virtualMemory")
	public VirtualMemoryData getVirtualMemory() {
		return virtualMemory;
	}

	/**
	 * @return the virtualCpu
	 */
	@JsonProperty("virtualCpu")
	public VirtualCpuData getVirtualCpu() {
		return virtualCpu;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (virtualComputeDescId == null) throw new MalformattedElementException("Virtual compute descriptor without ID");
		if (virtualCpu == null) throw new MalformattedElementException("Virtual compute descriptor without vCPU data");
		if (virtualMemory == null) throw new MalformattedElementException("Virtual compute descriptor without virtual memory data");	
	}

}
