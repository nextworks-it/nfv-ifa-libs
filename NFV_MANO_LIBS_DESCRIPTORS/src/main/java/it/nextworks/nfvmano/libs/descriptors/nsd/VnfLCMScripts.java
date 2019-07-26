package it.nextworks.nfvmano.libs.descriptors.nsd;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VnfLCMScripts {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	
	@JsonIgnore
	@ManyToOne
	private VnfProfile vnfProfile;
	
	private String target;
	
	@OneToMany(mappedBy = "vnfLcmScripts", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Map<String, VnfConfigurationScript> scripts = new HashMap<>();
	
	
	
	
	public VnfLCMScripts() {
		//JPA Only
	}
	
	
	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 * @param target
	 */
	public VnfLCMScripts(String target) {
		super();
		this.target = target;
	}

	// Capture all other fields that Jackson do not match other members
    @JsonAnyGetter
    public Map<String, VnfConfigurationScript> getConfigurationScripts() {
        return scripts;
    }

	
	
    @JsonAnySetter
    public void addConfigurationSCript(String name, VnfConfigurationScript newScript) {
        scripts.put(name, newScript);
    }
	
	
	
}
