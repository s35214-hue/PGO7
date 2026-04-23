public class GymMembershipPlan extends MembershipPlan implements Freezable {

    int entriesPerMonth;
    boolean saunaAccess;


    public GymMembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int entriesPerMonth, boolean saunaAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.entriesPerMonth = entriesPerMonth;
        this.saunaAccess = saunaAccess;
    }

    public int getEntriesPerMonth() {
        return entriesPerMonth;
    }

    public void setEntriesPerMonth(int entriesPerMonth) {
        this.entriesPerMonth = entriesPerMonth;
    }

    public boolean isSaunaAccess() {
        return saunaAccess;
    }

    public void setSaunaAccess(boolean saunaAccess) {
        this.saunaAccess = saunaAccess;
    }

    @Override
    public boolean canFreeze() {
        if (months <= 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPlanType() {
        return "standard plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = baseMonthlyFee + entriesPerMonth * 4;

        if (saunaAccess) {
            price += 25;
        } if (autoRenew) {
            price -= 10;
        }
        return price;
    }


}
