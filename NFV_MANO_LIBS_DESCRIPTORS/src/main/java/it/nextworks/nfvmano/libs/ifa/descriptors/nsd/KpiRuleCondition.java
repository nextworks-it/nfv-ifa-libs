package it.nextworks.nfvmano.libs.ifa.descriptors.nsd;


import it.nextworks.nfvmano.libs.ifa.descriptors.nsd.KpiCriteria;

import java.util.List;

//This is completely out of the standard. Developed for 5Growth compatibility
public class KpiRuleCondition {
    private String name;
    private boolean enabled;
    private int thresholdTime;
    private List<KpiCriteria> KpiCriteria;

    public KpiRuleCondition(String name, boolean enabled, int thresholdTime, List<it.nextworks.nfvmano.libs.ifa.descriptors.nsd.KpiCriteria> kpiCriteria) {
        this.name = name;
        this.enabled = enabled;
        this.thresholdTime = thresholdTime;
        KpiCriteria = kpiCriteria;
    }


    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getThresholdTime() {
        return thresholdTime;
    }

    public List<it.nextworks.nfvmano.libs.ifa.descriptors.nsd.KpiCriteria> getKpiCriteria() {
        return KpiCriteria;
    }
}
