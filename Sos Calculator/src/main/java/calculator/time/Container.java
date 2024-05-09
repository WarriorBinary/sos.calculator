package calculator.time;

import calculator.interfaces.IContainer;
import calculator.models.NeutralSpeedup;
import calculator.models.TrainingSpeedup;

public class Container implements IContainer {

    private long containerMinutes;
    private int oneMinute = 0;
    private int fiveMinute = 0;
    private int oneHour = 0;
    private int threeHour = 0;
    private int eightHour = 0;

    private void addToContainer(long minutes) {
        containerMinutes += minutes;
    }

    @Override
    public void addTrainingSpeedToContainer(TrainingSpeedup trainingSpeedup) {
        addToContainer(trainingSpeedup.getTotalInMinute());
        oneMinute += trainingSpeedup.getOneMinute();
        fiveMinute += trainingSpeedup.getFiveMinute();
        oneHour += trainingSpeedup.getOneHour();
        threeHour += trainingSpeedup.getThreeHour();
        eightHour += trainingSpeedup.getEightHour();
    }

    @Override
    public void addNeutralSpeedToContainer(NeutralSpeedup neutralSpeedup) {
        addToContainer(neutralSpeedup.getTotalInMinute());
        oneMinute += neutralSpeedup.getOneMinute();
        fiveMinute += neutralSpeedup.getFiveMinute();
        oneHour += neutralSpeedup.getOneHour();
        threeHour += neutralSpeedup.getThreeHour();
        eightHour += neutralSpeedup.getEightHour();
    }

    @Override
    public long getContainerMinutes() {
        return containerMinutes;
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
}
