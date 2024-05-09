package calculator;

import calculator.models.NeutralSpeedup;
import calculator.models.TrainingMetric;
import calculator.models.TrainingSpeedup;
import calculator.time.CoreManager;

public class CalculatorRunner {

    public static void main(String[] args) {
        CoreManager coreManager = new CoreManager();
        TrainingSpeedup trainingSpeedup = new TrainingSpeedup();
        NeutralSpeedup neutralSpeedup = new NeutralSpeedup();
        TrainingMetric trainingMetric = new TrainingMetric();
        coreManager.calculate(trainingSpeedup, neutralSpeedup, trainingMetric);
    }
}
