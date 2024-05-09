package calculator.interfaces;

import calculator.models.NeutralSpeedup;
import calculator.models.TrainingSpeedup;

public interface IContainer extends Speedup {
    void addTrainingSpeedToContainer(TrainingSpeedup trainingSpeedup);

    void addNeutralSpeedToContainer(NeutralSpeedup neutralSpeedup);

    long getContainerMinutes();
}
