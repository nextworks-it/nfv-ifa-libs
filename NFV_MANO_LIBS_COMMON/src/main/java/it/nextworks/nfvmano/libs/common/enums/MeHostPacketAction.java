package it.nextworks.nfvmano.libs.common.enums;

/**
 * Identifies the action of the ME host data plane, when a packet matches the trafficFilter
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.2.1.9 
 * 
 * @author nextworks
 *
 */
public enum MeHostPacketAction {

	DROP, 
	FORWARD, 
	DECAPSULATED,
	FORWARD_AS_IS, 
	PASSTHROUGH,
	DUPLICATED_DECAPSULATED, 
	DUPLICATE_AS_IS
	
}
