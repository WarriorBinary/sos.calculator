package calculator.time;

import calculator.interfaces.IContainer;
import calculator.models.NeutralSpeedup;
import calculator.models.TrainingSpeedup;

public class SpeedupManager {
    private final IContainer container;

    public SpeedupManager(IContainer container) {
        this.container = container;
    }

    public void addSpeedups(TrainingSpeedup trainingSpeedup, NeutralSpeedup neutralSpeedup){
        container.addTrainingSpeedToContainer(trainingSpeedup);
        container.addNeutralSpeedToContainer(neutralSpeedup);
    }
}
