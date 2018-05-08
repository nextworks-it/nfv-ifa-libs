package it.nextworks.nfvmano.libs.common.elements;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This data type provides the input filter for a selection
 * 
 * @author nextworks
 *
 */
public class Filter {

	//Supported keys: 
	//NSD_ID
	//NSD_VERSION
	//NSD_INFO_ID
	//NS_ID
	//RESOURCE_TYPE
	//RESOURCE_ID
	//VNF_PACKAGE_ID
	//VNF_PACKAGE_PRODUCT_NAME
	//VNF_PACKAGE_SW_VERSION
	//VNF_PACKAGE_PROVIDER
	//PNFD_ID
	//PNFD_VERSION
	//PNFD_INFO_ID
	//APP_PACKAGE_INFO_ID
	//APPD_ID
    //APPD_VERSION
	//FLAVOUR_ID
	//VSB_NAME & VSB_VERSION
	//VSB_ID
	//VSD_ID
	//VSI_ID
	//TENANT_ID
	private Map<String,String> parameters = new HashMap<>();
	
	public Filter() {}
	
	/**
	 * Constructor
	 * 
	 * @param parameters	Parameters of the filter
	 */
	@JsonCreator
	public Filter(@JsonProperty("parameters") Map<String,String> parameters) {
		if (parameters != null) this.parameters = parameters;
	}

	/**
	 * 
	 * @return the parameters of the filter
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}
	
	
	
}
