package it.nextworks.nfvmano.libs.descriptors.vnfd;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This information element defines the VNF-specific extension and 
 * metadata attributes of the VnfInfo that are writeable via the 
 * ModifyVnfInfo operation.
 * 
 * REF. IFA-011 v2.3.1 - section 7.1.14
 * 
 * @author nextworks
 *
 */
@Entity
public class VnfInfoModifiableAttributes implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JsonIgnore
	@JoinColumn(name="vnfd_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vnfd vnfd;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> extension = new HashMap<String, String>();
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> metadata = new HashMap<String, String>();
	
	public VnfInfoModifiableAttributes() {	}
	
	/**
	 * Constructor
	 *  
	 * @param vnfd VNFD this modifiable attributes belong to
	 * @param extension "Extension" attributes of VnfInfo that are writeable.
	 * @param metadata "Metadata" attributes of VnfInfo that are writeable.
	 */
	public VnfInfoModifiableAttributes(Vnfd vnfd,
			Map<String, String> extension,
			Map<String, String> metadata) {
		this.vnfd = vnfd;
		if (extension != null) this.extension = extension;
		if (metadata != null) this.metadata = metadata;
	}

	
	
	/**
	 * @return the extension
	 */
	public Map<String, String> getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Map<String, String> extension) {
		this.extension = extension;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {	}

}
