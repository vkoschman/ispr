public class Condition {
    private String title;
    private String effectiveTime; // Дата постановки состояния

    public Observation(String title, String effectiveTime) {
        this.title = title;
        this.effectiveTime = effectiveTime;
    }

    public String getTitle() {
        return title;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }
}