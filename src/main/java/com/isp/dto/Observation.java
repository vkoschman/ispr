public class Observation {
    private String title; // Дублирует ключ из Map. Например, "Risk Evaluation, Document: Sexually Transmitted Infection"
    private String observedAtTime; // Дата наблюдения

    public Observation(String title, String observedAtTime) {
        this.title = title;
        this.observedAtTime = observedAtTime;
    }

    public String getTitle() {
        return title;
    }

    public String getObservedAtTime() {
        return observedAtTime;
    }
}