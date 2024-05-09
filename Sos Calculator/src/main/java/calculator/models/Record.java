package calculator.models;

public class Record {
    private int totalAmount = 0;
    private int troopTier = 1;
    private long totalPoints = 0;

    public int getTroopTier() {
        return troopTier;
    }

    public void setTroopTier(int troopTier) {
        this.troopTier = troopTier;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
