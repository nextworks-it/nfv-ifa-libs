package it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.InterfaceInformationElement;
import it.nextworks.nfvmano.libs.common.enums.CpuPinningPolicy;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * 
 * REF IFA 005 v2.3.1 - 8.4.3.4
 * 
 * @author nextworks
 *
 */
public class VirtualCpuPinning implements InterfaceInformationElement {

	private CpuPinningPolicy cpuPinningPolicy;
	private List<String> cpuPinningRules = new ArrayList<>();
	private Map<String, String> cpuPinningMap = new HashMap<String, String>();
	
	public VirtualCpuPinning() { }
	
	/**
	 * Constructor
	 * 
	 * @param cpuPinningPolicy The policy can take values of "static" or "dynamic".
	 * @param cpuPinningRules
	 * @param cpuPinningMap If CpuPinningPolicy is defined as "static", the CpuPinninMap provides the map of pinning virtual CPU cores to physical CPU cores/threads.
	 */
	public VirtualCpuPinning(CpuPinningPolicy cpuPinningPolicy,
			List<String> cpuPinningRules,
			Map<String, String> cpuPinningMap) {
		if (cpuPinningMap != null) this.cpuPinningMap = cpuPinningMap;
		if (cpuPinningRules != null) this.cpuPinningRules = cpuPinningRules;
		this.cpuPinningPolicy = cpuPinningPolicy;
	}
	
	

	/**
	 * @return the cpuPinningRules
	 */
	public List<String> getCpuPinningRules() {
		return cpuPinningRules;
	}

	/**
	 * @return the cpuPinningPolicy
	 */
	public CpuPinningPolicy getCpuPinningPolicy() {
		return cpuPinningPolicy;
	}

	/**
	 * @return the cpuPinningMap
	 */
	public Map<String, String> getCpuPinningMap() {
		return cpuPinningMap;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
