package calculator.enums;

public enum TroopTier {
    TIER_1(1,1),
    TIER_2(2,2),
    TIER_3(3,3),
    TIER_4(4,4),
    TIER_5(5,5),
    TIER_6(6,7),
    TIER_7(7,9),
    TIER_8(8,11),
    TIER_9(9,15),
    TIER_10(10,20),
    TIER_11(11,25),
    TIER_12(12,30);

    private final int troopTier;
    private final int tierPoint;

    public int getTroopTier() {
        return troopTier;
    }

    public int getTierPoint() {
        return tierPoint;
    }

    TroopTier(int troopTier, int tierPoint) {
        this.troopTier = troopTier;
        this.tierPoint = tierPoint;
    }
}
