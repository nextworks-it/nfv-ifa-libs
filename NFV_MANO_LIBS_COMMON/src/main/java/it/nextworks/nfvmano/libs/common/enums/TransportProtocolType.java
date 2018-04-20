package it.nextworks.nfvmano.libs.common.enums;

/**
 * The enumeration TransportTypes represents types of transports.
 * 
 * Ref. ETSI GS MEC 010-2 V1.1.1 (2017-07) - 6.6.4
 * 
 * @author nextworks
 *
 */
public enum TransportProtocolType {

	REST_HTTP,				//RESTful API using HTTP (as defined in IETF RFC 7230 [11] and related specifications)
	MB_TOPIC_BASED, 		//Topic-based message bus which routes messages to receivers based on subscriptions, if a pattern passed on subscription matches the topic of the message. Example: MQTT
	MB_ROUTING,				//Routing-based message bus which routes messages to receivers based on subscriptions, if a key passed on subscription is equal to the key of the message
	MB_PUBSUB,				//Publish-subscribe based message bus which distributes messages to all subscribers
	RPC,					//Remote procedure call. Example: GRPC
	RPC_STREAMING,			//Remote procedure call supporting streams of requests and responses. Example: GRPC
	WEBSOCKET				//Websockets as defined in IETF RFC 6455
	
}
