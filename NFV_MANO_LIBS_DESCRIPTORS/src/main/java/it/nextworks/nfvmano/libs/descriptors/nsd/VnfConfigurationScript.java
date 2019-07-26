package it.nextworks.nfvmano.libs.descriptors.nsd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VnfConfigurationScript {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	

	@ManyToOne
	@JsonIgnore
	private VnfLCMScripts vnfLcmScripts;
	
	private Map<String, String> args = new HashMap<>();
	
	private List<String> script = new ArrayList<String>();
	
	
	/**
	 * @return the args
	 */
	public Map<String, String> getArgs() {
		return args;
	}

	/**
	 * @return the script
	 */
	public List<String> getScript() {
		return script;
	}

}
