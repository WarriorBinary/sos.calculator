package calculator.models;

import calculator.interfaces.Speedup;

public class NeutralSpeedup implements Speedup {
    private int oneMinute = 0;
    private int fiveMinute = 0;
    private int oneHour = 0;
    private int threeHour = 0;
    private int eightHour = 0;

    public NeutralSpeedup() {
    }

    public void setOneMinute(int oneMinute) {
        this.oneMinute = oneMinute;
    }

    public void setFiveMinute(int fiveMinute) {
        this.fiveMinute = fiveMinute;
    }

    public void setOneHour(int oneHour) {
        this.oneHour = oneHour;
    }

    public void setThreeHour(int threeHour) {
        this.threeHour = threeHour;
    }

    public void setEightHour(int eightHour) {
        this.eightHour = eightHour;
    }

    @Override
    public int getOneMinute() {
        return oneMinute;
    }

    @Override
    public int getFiveMinute() {
        return fiveMinute;
    }

    @Override
    public int getOneHour() {
        return oneHour;
    }

    @Override
    public int getThreeHour() {
        return threeHour;
    }

    @Override
    public int getEightHour() {
        return eightHour;
    }

    public int getTotalInMinute() {
        return oneMinute + (fiveMinute * 5) + (oneHour * 60) + (threeHour * 180) + (eightHour * 480);
    }

    @Override
    public String toString() {
        return "NeutralSpeedup{" +
                "oneMinute=" + oneMinute +
                ", fiveMinute=" + fiveMinute +
                ", oneHour=" + oneHour +
                ", threeHour=" + threeHour +
                ", eightHour=" + eightHour +
                '}';
    }
}
