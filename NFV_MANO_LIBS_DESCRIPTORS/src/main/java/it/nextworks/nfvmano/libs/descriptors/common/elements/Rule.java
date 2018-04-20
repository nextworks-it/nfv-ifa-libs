package it.nextworks.nfvmano.libs.descriptors.common.elements;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nfpd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.records.nsinfo.Nfp;


@Entity
public class Rule implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Nsd nsd;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JsonIgnore
	@JoinColumn(name="nfpd_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Nfpd nfpd;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JsonIgnore
	@JoinColumn(name="nfp_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Nfp nfp;
	
	@JsonIgnore
	@ManyToOne
	private Vnfd vnfd;
	
	public Rule() {
		// JPA only
	}
	
	public Rule(Nsd nsd) {
		this.nsd = nsd;
	}
	
	public Rule(Nfpd nfpd) {
		this.nfpd = nfpd;
	}
	
	public Rule(Nfp nfp) {
		this.nfp = nfp;
	}
	
	public Rule(Vnfd vnfd) {
		this.vnfd = vnfd;
	}

	@Override
	public void isValid() throws MalformattedElementException { }

}
