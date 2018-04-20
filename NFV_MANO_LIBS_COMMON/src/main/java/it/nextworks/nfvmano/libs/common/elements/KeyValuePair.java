package it.nextworks.nfvmano.libs.common.elements;

public class KeyValuePair {

	private String key;
	private String value;
	
	public KeyValuePair(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public KeyValuePair(){}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	
	
}
