package calculator.models;

public class TrainingMetric extends Record {
    private int trainingDay = 0;
    private int trainingHour = 0;
    private int trainingMinute = 0;
    private int trainingAmount = 0;
    private int trainingSeconds = 0;

    public int getTrainingSeconds() {
        return trainingSeconds;
    }

    public void setTrainingSeconds(int trainingSeconds) {
        this.trainingSeconds = trainingSeconds;
    }

    public int getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(int trainingDay) {
        this.trainingDay = trainingDay;
    }

    public int getTrainingHour() {
        return trainingHour;
    }

    public void setTrainingHour(int trainingHour) {
        this.trainingHour = trainingHour;
    }

    public int getTrainingMinute() {
        return trainingMinute;
    }

    public void setTrainingMinute(int trainingMinute) {
        this.trainingMinute = trainingMinute;
    }

    public int getTrainingAmount() {
        return trainingAmount;
    }

    public void setTrainingAmount(int trainingAmount) {
        this.trainingAmount = trainingAmount;
    }
}
