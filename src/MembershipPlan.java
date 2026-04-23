public abstract class MembershipPlan implements Billable {

    String planCode;
    String clientName;
    int months;
    double baseMonthlyFee;
    boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonths() {
        return months;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public void setClientName(String clientName) {
        if (!(clientName == null)) {
            this.clientName = clientName.toUpperCase();
        }
    }

    public void setMonths(int months) {
        if (months > 0 && months <= 12) {
            this.months = months;
        }
    }

    @Override
    public double calculateMonthlyGrossPrice() {
        return baseMonthlyFee;
    }

    public void setBaseMonthlyFee(double baseMonthlyFee) {
        this.baseMonthlyFee = baseMonthlyFee;
    }

    public void setAutoRenew(boolean autoRenew) {
        this.autoRenew = autoRenew;
    }

    public double calculateTotalNetPrice() {
        return months*baseMonthlyFee;
    }

    final void printSummary() {
        System.out.println(planCode + "\t" + clientName + "\t" + "M: " + months + " BMF: " + baseMonthlyFee + " Renew?: " + autoRenew);
    }

    public abstract String getPlanType();

    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public String toString() {
        return "\n> Plan Code:" + getPlanCode() + "\n> Client: " + getClientName() +"\n> Duration (in months): " + getMonths() +"\n> Monthly Fee: " + calculateMonthlyGrossPrice() + "\n> Total: " + calculateTotalNetPrice() + "\n> Auto-renewal: " + isAutoRenew();
    }
}
