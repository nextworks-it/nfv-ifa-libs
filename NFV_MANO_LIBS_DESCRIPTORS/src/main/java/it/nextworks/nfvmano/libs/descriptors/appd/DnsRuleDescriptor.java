package it.nextworks.nfvmano.libs.descriptors.appd;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.IpVersion;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * The DnsRuleDescriptor data type describes DNS rules associated with a ME application.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.2.1.13
 * 
 * @author nextworks
 *
 */
@Embeddable
public class DnsRuleDescriptor implements DescriptorInformationElement {

	private String dnsRuleId;
	private String domainName;
	private IpVersion ipAddressType;
	private String ipAddress;
	private int ttl;
	
	public DnsRuleDescriptor() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param dnsRuleId Identifies the DNS Rule
	 * @param domainName FQDN of the DNS rule
	 * @param ipAddressType Specifies the IP address type
	 * @param ipAddress IP address given by the DNS rule
	 * @param ttl Time-to-live value
	 */
	public DnsRuleDescriptor(String dnsRuleId,
							 String domainName,
							 IpVersion ipAddressType,
							 String ipAddress,
							 int ttl) {
		this.dnsRuleId = dnsRuleId;
		this.domainName = domainName;
		this.ipAddressType = ipAddressType;
		this.ipAddress = ipAddress;
		this.ttl = ttl;
	}
	
	
	
	/**
	 * @return the dnsRuleId
	 */
	@JsonProperty("dnsRuleId")
	public String getDnsRuleId() {
		return dnsRuleId;
	}

	/**
	 * @return the domainName
	 */
	@JsonProperty("domainName")
	public String getDomainName() {
		return domainName;
	}

	/**
	 * @return the ipAddressType
	 */
	@JsonProperty("ipAddressType")
	public IpVersion getIpAddressType() {
		return ipAddressType;
	}

	/**
	 * @return the ipAddress
	 */
	@JsonProperty("ipAddress")
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @return the ttl
	 */
	@JsonProperty("ttl")
	public int getTtl() {
		return ttl;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (dnsRuleId == null) throw new MalformattedElementException("DNS rule descriptor without ID");
		if (domainName == null) throw new MalformattedElementException("DNS rule descriptor without domain name");
		if (ipAddress == null) throw new MalformattedElementException("DNS rule descriptor without IP address");
	}

}
