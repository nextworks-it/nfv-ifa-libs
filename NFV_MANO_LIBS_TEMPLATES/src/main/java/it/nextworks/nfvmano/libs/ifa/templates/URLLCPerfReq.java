/*
 * Copyright (c) 2019 Nextworks s.r.l
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.nextworks.nfvmano.libs.ifa.templates;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * See:
 *  3gpp Clause 6.4.1 of TS 28.541 (PerfReq)
 * and
 *  3ggp Clause 7.2.2 of TS 22.261
 *
 */
@Entity
public class URLLCPerfReq extends SlicePerfReq {
/**
 * e2eLatency (Integer), jitter (Integer), survivalTime (Integer), cSAvailability (Float),
 * reliability (Float), expDataRate (Integer), payloadSize (String), trafficDensity (Integer),
 * connDensity (Integer), serviceAreaDimension (String)
 */
	@Id
    @GeneratedValue
    @JsonIgnore
	private Long id;
    private int e2eLatency;
    private int jitter;
    private int survivalTime;
    private float cSAvailability;
    private float reliability;
    private int expDataRate;
    private String payloadSize;
    private int trafficDensity;
    private int connDensity;
    private String serviceAreaDimension;

    public URLLCPerfReq() {
    }

    /**
     *
     * @param e2eLatency
     * @param jitter
     * @param survivalTime
     * @param cSAvailability
     * @param reliability
     * @param expDataRate
     * @param payloadSize
     * @param trafficDensity
     * @param connDensity
     * @param serviceAreaDimension
     */
    public URLLCPerfReq(int e2eLatency, int jitter, int survivalTime, float cSAvailability, float reliability,
                        int expDataRate, String payloadSize, int trafficDensity, int connDensity,
                        String serviceAreaDimension) {
        this.e2eLatency = e2eLatency;
        this.jitter = jitter;
        this.survivalTime = survivalTime;
        this.cSAvailability = cSAvailability;
        this.reliability = reliability;
        this.expDataRate = expDataRate;
        this.payloadSize = payloadSize;
        this.trafficDensity = trafficDensity;
        this.connDensity = connDensity;
        this.serviceAreaDimension = serviceAreaDimension;
    }

    public int getE2eLatency() {
        return e2eLatency;
    }

    public void setE2eLatency(int e2eLatency) {
        this.e2eLatency = e2eLatency;
    }

    public int getJitter() {
        return jitter;
    }

    public void setJitter(int jitter) {
        this.jitter = jitter;
    }

    public int getSurvivalTime() {
        return survivalTime;
    }

    public void setSurvivalTime(int survivalTime) {
        this.survivalTime = survivalTime;
    }

    public float getcSAvailability() {
        return cSAvailability;
    }

    public void setcSAvailability(float cSAvailability) {
        this.cSAvailability = cSAvailability;
    }

    public float getReliability() {
        return reliability;
    }

    public void setReliability(float reliability) {
        this.reliability = reliability;
    }

    public int getExpDataRate() {
        return expDataRate;
    }

    public void setExpDataRate(int expDataRate) {
        this.expDataRate = expDataRate;
    }

    public String getPayloadSize() {
        return payloadSize;
    }

    public void setPayloadSize(String payloadSize) {
        this.payloadSize = payloadSize;
    }

    public int getTrafficDensity() {
        return trafficDensity;
    }

    public void setTrafficDensity(int trafficDensity) {
        this.trafficDensity = trafficDensity;
    }

    public int getConnDensity() {
        return connDensity;
    }

    public void setConnDensity(int connDensity) {
        this.connDensity = connDensity;
    }

    public String getServiceAreaDimension() {
        return serviceAreaDimension;
    }

    public void setServiceAreaDimension(String serviceAreaDimension) {
        this.serviceAreaDimension = serviceAreaDimension;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
