public class MedicationPrescription {
    private String title;
    private String reason; // Причина назначения
    private String orderedAtTime; // Начало назначения

    public MedicationPrescription(String title, String reason, String orderedAtTime) {
        this.title = title;
        this.reason = reason;
        this.orderedAtTime = orderedAtTime;
    }

    public String getTitle() {
        return title;
    }

    public String getReason() {
        return reason;
    }

    public String getOrderedAtTime() {
        return orderedAtTime;
    }
}