package it.nextworks.nfvmano.libs.ifa.descriptors.nsd;

import it.nextworks.nfvmano.libs.ifa.common.enums.RelationalOperation;

public class KpiCriteria {

    private String name;

    private int kpiThreshold;
    private RelationalOperation relationalsOperation;
    private String nsMonitoringParamRef;

    public KpiCriteria(String name, int kpiThreshold, RelationalOperation relationalsOperation, String nsMonitoringParamRef) {
        this.name = name;
        this.kpiThreshold = kpiThreshold;
        this.relationalsOperation = relationalsOperation;
        this.nsMonitoringParamRef = nsMonitoringParamRef;
    }

    public KpiCriteria() {
    }

    public String getName() {
        return name;
    }

    public int getKpiThreshold() {
        return kpiThreshold;
    }

    public RelationalOperation getRelationalsOperation() {
        return relationalsOperation;
    }

    public String getNsMonitoringParamRef() {
        return nsMonitoringParamRef;
    }
}
