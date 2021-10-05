package it.nextworks.nfvmano.libs.ifa.descriptors.nsd;


//This is completely out of the standard. Developed for 5Growth compatibility
public class KeyPerformanceIndicator {

    private String ruleId;

    private KpiRuleCondition ruleCondition;

    public KeyPerformanceIndicator(String ruleId, KpiRuleCondition ruleCondition) {
        this.ruleId = ruleId;
        this.ruleCondition = ruleCondition;
    }

    public String getRuleId() {
        return ruleId;
    }

    public KpiRuleCondition getRuleCondition() {
        return ruleCondition;
    }
}
