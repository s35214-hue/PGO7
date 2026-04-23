public class PersonalTrainingPlan extends MembershipPlan {

    int sessionsPerMonth;
    int trainerLevel;
    boolean dietConsultationIncluded;

    public PersonalTrainingPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int sessionsPerMonth, int trainerLevel, boolean dietConsultationIncluded) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.sessionsPerMonth = sessionsPerMonth;
        if (trainerLevel > 0 || trainerLevel < 4) {
            this.trainerLevel = trainerLevel;
        }
        this.dietConsultationIncluded = dietConsultationIncluded;
    }

    public int getSessionsPerMonth() {
        return sessionsPerMonth;
    }

    public void setSessionsPerMonth(int sessionsPerMonth) {
        this.sessionsPerMonth = sessionsPerMonth;
    }

    public int getTrainerLevel() {
        return trainerLevel;
    }

    public void setTrainerLevel(int trainerLevel) {
        this.trainerLevel = trainerLevel;
    }

    public boolean isDietConsultationIncluded() {
        return dietConsultationIncluded;
    }

    public void setDietConsultationIncluded(boolean dietConsultationIncluded) {
        this.dietConsultationIncluded = dietConsultationIncluded;
    }

    @Override
    public String getPlanType() {
        return "personal training plan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = baseMonthlyFee + sessionsPerMonth * 70;

        if (trainerLevel == 2) {
            price += 90;
        } else if (trainerLevel == 3) {
            price += 180;
        } if (dietConsultationIncluded) {
            price += 50;
        } if (autoRenew) {
            price -= 15;
        }
        return price;
    }
}
