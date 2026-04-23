public class CorporateWellnessPlan extends MembershipPlan implements RemoteAccess, Freezable {

    int employeeCount;
    int workshopsPerMonth;
    boolean onlineDashboard;

    public CorporateWellnessPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int employeeCount, int workshopsPerMonth, boolean onlineDashboard) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.employeeCount = employeeCount;
        this.workshopsPerMonth = workshopsPerMonth;
        this.onlineDashboard = onlineDashboard;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getWorkshopsPerMonth() {
        return workshopsPerMonth;
    }

    public void setWorkshopsPerMonth(int workshopsPerMonth) {
        this.workshopsPerMonth = workshopsPerMonth;
    }

    public boolean isOnlineDashboard() {
        return onlineDashboard;
    }

    public void setOnlineDashboard(boolean onlineDashboard) {
        this.onlineDashboard = onlineDashboard;
    }

    @Override
    public boolean canFreeze() {
        if(months >= 6 && workshopsPerMonth == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPlanType() {
        return "";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = baseMonthlyFee + employeeCount * 18 + workshopsPerMonth * 220;

        if (employeeCount >= 20) {
            price *= 0.88;
        } if (onlineDashboard) {
            price += 80;
        }
        return price;
    }

    @Override
    public boolean hasOnlineAccess() {
        return onlineDashboard;
    }
}
