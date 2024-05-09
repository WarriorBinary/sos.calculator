package calculator.time;

import calculator.contant.StringConstant;
import calculator.enums.TroopTier;
import calculator.interfaces.Calculate;
import calculator.interfaces.IContainer;
import calculator.models.NeutralSpeedup;
import calculator.models.TrainingMetric;
import calculator.models.TrainingSpeedup;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

public class CoreManager implements Calculate {

    private static final long VALUE_1440L = 1440L;
    private static final long VALUE_60L = 60L;
    private static final int VALUE_0 = 0;
    private static final int VALUE_1 = 1;
    private static final int VALUE_2 = 2;
    private static final int VALUE_3 = 3;

    private void readUserInput(TrainingSpeedup trainingSpeedup, NeutralSpeedup neutralSpeedup,
                               TrainingMetric trainingMetric) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the amount of 1 minute troop training speedups: ");
        trainingSpeedup.setOneMinute(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 5 minute troop training speedups: ");
        trainingSpeedup.setFiveMinute(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 1 hour troop training speedups: ");
        trainingSpeedup.setOneHour(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 3 hour troop training speedups: ");
        trainingSpeedup.setThreeHour(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 8 hour troop training speedups: ");
        trainingSpeedup.setEightHour(Integer.parseInt(userInput.nextLine()));

        System.out.println("Please enter the amount of 1 minute neutral speedups: ");
        neutralSpeedup.setOneMinute(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 5 minute neutral speedups: ");
        neutralSpeedup.setFiveMinute(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 1 hour neutral speedups: ");
        neutralSpeedup.setOneHour(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 3 hour neutral speedups: ");
        neutralSpeedup.setThreeHour(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the amount of 8 hour neutral speedups: ");
        neutralSpeedup.setEightHour(Integer.parseInt(userInput.nextLine()));

        System.out.println("Please enter the amount of troops you can train at once: ");
        trainingMetric.setTrainingAmount(Integer.parseInt(userInput.nextLine()));
        System.out.println("Please enter the time of training in format days:hours:minutes:seconds ");
        String temp = userInput.nextLine();
        String[] tempData = temp.split(":");
        trainingMetric.setTrainingDay(Integer.parseInt(tempData[VALUE_0]));
        trainingMetric.setTrainingHour(Integer.parseInt(tempData[VALUE_1]));
        trainingMetric.setTrainingMinute(Integer.parseInt(tempData[VALUE_2]));
        trainingMetric.setTrainingSeconds(Integer.parseInt(tempData[VALUE_3]));
        System.out.println("Please enter the troop tier");
        trainingMetric.setTroopTier(Integer.parseInt(userInput.nextLine()));
    }

    @Override
    public void calculate(TrainingSpeedup trainingSpeedup, NeutralSpeedup neutralSpeedup,
                          TrainingMetric trainingMetric) {
        readUserInput(trainingSpeedup, neutralSpeedup, trainingMetric);
        IContainer container = new Container();
        SpeedupManager speedupManager = new SpeedupManager(container);
        speedupManager.addSpeedups(trainingSpeedup, neutralSpeedup);
        printSpeedups(container.getContainerMinutes());
        trainingMetric.setTotalAmount(calculateTotalTroops(trainingMetric, container.getContainerMinutes()));
        trainingMetric.setTotalPoints(calculateTotalPoints(trainingMetric.getTotalAmount(), trainingMetric.getTroopTier()));
        System.out.println("Speedups: ");
        System.out.println("1 Minute: " + container.getOneMinute());
        System.out.println("5 Minute: " + container.getFiveMinute());
        System.out.println("1 Hour: " + container.getOneHour());
        System.out.println("3 Hours: " + container.getThreeHour());
        System.out.println("8 Hours: " + container.getEightHour());
        System.out.println(MessageFormat.format(StringConstant.TOTAL_TROOPS, trainingMetric.getTotalAmount(),
                trainingMetric.getTroopTier(), trainingMetric.getTotalPoints()));

    }

    private int calculateTotalPoints(int totalTroops, int tierTroop) {
        int tierPoints = findTierPoints(tierTroop);
        return totalTroops * tierPoints;
    }

    private int findTierPoints(int troopTier) {
        return Arrays.stream(TroopTier.values())
                .filter(tier -> tier.getTroopTier() == troopTier)
                .findFirst()
                .map(TroopTier::getTierPoint)
                .orElse(1);
    }

    private int calculateTotalTroops(TrainingMetric trainingMetric, long minutes) {
        long metricMinutes = (trainingMetric.getTrainingDay() * VALUE_1440L) + (trainingMetric.getTrainingHour() * VALUE_60L) +
                trainingMetric.getTrainingMinute() + trainingMetric.getTrainingSeconds();
        long minutesDiff = (minutes / metricMinutes);
        return (int) (minutesDiff * trainingMetric.getTrainingAmount());
    }

    private void printSpeedups(long minutes) {
        Duration duration = Duration.ofMinutes(minutes);
        long days = duration.toDays();
        long hour = duration.minusDays(days).toHours();
        long minute = duration.minusDays(days).minusHours(hour).toMinutes();

        System.out.println(MessageFormat.format(StringConstant.PRINT, "", days, hour, minute));
    }
}
