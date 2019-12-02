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

/**
 * See:
 *  3gpp Clause 6.4.1 of TS 28.541 (PerfReq)
 * and
 *  3ggp Table 7.1-1 of TS 22.261
 *
 * NOTE: scenario examples present in table 7.1-1 have not been reported in the implementation
 *        as suggested by TS 28.541
 */
public class EMBBPerfReq extends SlicePerfReq{

    private int expDataRateDL;
    private int expDataRateUL;
    private int areaTrafficCapDL;
    private int areaTrafficCapUL;
    private int userDensity;
    private int activityFactor;
    private int uESpeed;
    private String coverage;

    public EMBBPerfReq() { }

    public EMBBPerfReq(int expDataRateDL, int expDataRateUL, int areaTrafficCapDL, int areaTrafficCapUL,
                       int userDensity, int activityFactor, int uESpeed, String coverage) {
        this.expDataRateDL = expDataRateDL;
        this.expDataRateUL = expDataRateUL;
        this.areaTrafficCapDL = areaTrafficCapDL;
        this.areaTrafficCapUL = areaTrafficCapUL;
        this.userDensity = userDensity;
        this.activityFactor = activityFactor;
        this.uESpeed = uESpeed;
        this.coverage = coverage;
    }

    public int getExpDataRateDL() {
        return expDataRateDL;
    }

    public void setExpDataRateDL(int expDataRateDL) {
        this.expDataRateDL = expDataRateDL;
    }

    public int getExpDataRateUL() {
        return expDataRateUL;
    }

    public void setExpDataRateUL(int expDataRateUL) {
        this.expDataRateUL = expDataRateUL;
    }

    public int getAreaTrafficCapDL() {
        return areaTrafficCapDL;
    }

    public void setAreaTrafficCapDL(int areaTrafficCapDL) {
        this.areaTrafficCapDL = areaTrafficCapDL;
    }

    public int getAreaTrafficCapUL() {
        return areaTrafficCapUL;
    }

    public void setAreaTrafficCapUL(int areaTrafficCapUL) {
        this.areaTrafficCapUL = areaTrafficCapUL;
    }

    public int getUserDensity() {
        return userDensity;
    }

    public void setUserDensity(int userDensity) {
        this.userDensity = userDensity;
    }

    public int getActivityFactor() {
        return activityFactor;
    }

    public void setActivityFactor(int activityFactor) {
        this.activityFactor = activityFactor;
    }

    public int getuESpeed() {
        return uESpeed;
    }

    public void setuESpeed(int uESpeed) {
        this.uESpeed = uESpeed;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }
}
