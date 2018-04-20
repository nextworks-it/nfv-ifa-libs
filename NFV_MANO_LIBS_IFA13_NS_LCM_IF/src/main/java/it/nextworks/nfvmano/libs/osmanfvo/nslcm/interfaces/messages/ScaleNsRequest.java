package it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages;

import java.util.Date;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.enums.NsScaleType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.ScaleNsData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.ScaleVnfData;

/**
 * Message to request the scaling of a Network Service instance
 *  REF IFA 013 v2.3.1 - 7.3.4
 * 
 * @author nextworks
 *
 */
public class ScaleNsRequest implements InterfaceMessage {

	private String nsInstanceId;
	private NsScaleType scaleType;
	private ScaleNsData scaleNsData;
	private List<ScaleVnfData> scaleVnfData;
	private Date scaleTime;
	
	public ScaleNsRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * 
	 * @param nsInstanceId Identifier of the instance of the NS.
	 * @param scaleType Indicates the type of scaling to be performed.
	 * @param scaleNsData Provides the necessary information to scale the referenced NS instance.
	 * @param scaleVnfData Provides the information to scale a given VNF instance that is part of the referenced NS instance.
	 * @param scaleTime Timestamp indicating the scale time of the NS, i.e. the NS will be scaled at this timestamp.
	 */
	public ScaleNsRequest(String nsInstanceId,
			NsScaleType scaleType,
			ScaleNsData scaleNsData,
			List<ScaleVnfData> scaleVnfData,
			Date scaleTime) {
		this.nsInstanceId = nsInstanceId;
		this.scaleType = scaleType;
		this.scaleNsData = scaleNsData;
		if (scaleVnfData != null) this.scaleVnfData = scaleVnfData;
		this.scaleTime = scaleTime;
	}
	
	

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	/**
	 * @return the scaleType
	 */
	public NsScaleType getScaleType() {
		return scaleType;
	}

	/**
	 * @return the scaleNsData
	 */
	public ScaleNsData getScaleNsData() {
		return scaleNsData;
	}

	/**
	 * @return the scaleVnfData
	 */
	public List<ScaleVnfData> getScaleVnfData() {
		return scaleVnfData;
	}

	/**
	 * @return the scaleTime
	 */
	public Date getScaleTime() {
		return scaleTime;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (nsInstanceId == null) throw new MalformattedElementException("Scale NS request without NS instance ID");
		if (scaleNsData != null) scaleNsData.isValid();
		if (scaleVnfData != null) {
			for (ScaleVnfData v: scaleVnfData) v.isValid();
		}
	}

}
