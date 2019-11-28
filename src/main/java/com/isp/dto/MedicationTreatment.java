public class MedicationTreatment {
    private String title;
    private String performanceTime; // Начало лечения

    public Observation(String title, String performanceTime) {
        this.title = title;
        this.performanceTime = performanceTime;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformanceTime() {
        return performanceTime;
    }
}