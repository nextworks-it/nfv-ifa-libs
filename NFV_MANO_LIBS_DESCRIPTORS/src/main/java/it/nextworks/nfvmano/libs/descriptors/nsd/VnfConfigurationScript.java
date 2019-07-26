package it.nextworks.nfvmano.libs.descriptors.nsd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class VnfConfigurationScript {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	

	@ManyToOne
	@JsonIgnore
	private VnfLCMScripts vnfLcmScripts;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> args = new HashMap<>();
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
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
