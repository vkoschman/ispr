public class DiagnosticReport {
    private String title;
    private String observedAtTime; // Дата проведения
    private String value; // Результат

    public DiagnosticReport(String title, String observedAtTime, String value) {
        this.title = title;
        this.observedAtTime = observedAtTime;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getObservedAtTime() {
        return observedAtTime;
    }

    public String getValue() {
        return value;
    }
}