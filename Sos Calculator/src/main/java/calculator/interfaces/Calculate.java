package calculator.interfaces;

import calculator.models.NeutralSpeedup;
import calculator.models.TrainingMetric;
import calculator.models.TrainingSpeedup;

public interface Calculate {

    void calculate(TrainingSpeedup trainingSpeedup, NeutralSpeedup neutralSpeedup,
                   TrainingMetric trainingMetric);
}
