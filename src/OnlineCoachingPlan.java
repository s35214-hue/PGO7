public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess {

    int videoConsultations;
    boolean mealPlanIncluded;
    boolean recordedLibraryAccess;

    public OnlineCoachingPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int videoConsultations, boolean mealPlanIncluded, boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    public int getVideoConsultations() {
        return videoConsultations;
    }

    public void setVideoConsultations(int videoConsultations) {
        this.videoConsultations = videoConsultations;
    }

    public boolean isMealPlanIncluded() {
        return mealPlanIncluded;
    }

    public void setMealPlanIncluded(boolean mealPlanIncluded) {
        this.mealPlanIncluded = mealPlanIncluded;
    }

    public boolean isRecordedLibraryAccess() {
        return recordedLibraryAccess;
    }

    public void setRecordedLibraryAccess(boolean recordedLibraryAccess) {
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    @Override
    public String getPlanType() {
        return "online coaching plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = baseMonthlyFee + videoConsultations * 45;

        if(mealPlanIncluded){
            price += 60;
        } if(recordedLibraryAccess){
            price += 20;
        } if(autoRenew){
            price -= 12;
        }
        return price;
    }

    @Override
    public boolean hasOnlineAccess() {
        return true;
    }
}
