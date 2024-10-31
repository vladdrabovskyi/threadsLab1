/**
 * Клас SequenceManager для запуску і керування потоками обчислення.
 */
public class SequenceManager {
    private SequenceCalculator[] calculators;
    private int delayBetweenStops;

    public SequenceManager(int numberOfThreads, int step, int delayBetweenStops) {
        this.delayBetweenStops = delayBetweenStops;
        calculators = new SequenceCalculator[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            calculators[i] = new SequenceCalculator(i + 1, step);
        }
    }

    public void startThreads() {
        for (SequenceCalculator calculator : calculators) {
            calculator.start(); // запускаємо обчислювальні потоки
        }

        new Thread(this::stopThreadsOneByOne).start(); // керуючий потік для зупинки
    }

    private void stopThreadsOneByOne() {
        for (SequenceCalculator calculator : calculators) {
            try {
                Thread.sleep(delayBetweenStops); // чекаємо перед зупинкою наступного потоку
                calculator.stopCalculation();    // зупиняємо потік
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
