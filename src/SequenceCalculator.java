/**
 * Клас SequenceCalculator для обчислення суми числової послідовності.
 */
public class SequenceCalculator extends Thread {
    private int step;
    private int threadNumber;
    private int sum = 0;
    private int elementCount = 0;
    private boolean running = true;

    public SequenceCalculator(int threadNumber, int step) {
        this.threadNumber = threadNumber;
        this.step = step;
    }

    @Override
    public void run() {
        int currentValue = 0;
        while (running) {
            sum += currentValue;        // додаємо поточне значення до суми
            currentValue += step;       // збільшуємо значення на крок
            elementCount++;             // збільшуємо лічильник елементів

            try {
                Thread.sleep(100);      // додаємо паузу для видимості роботи
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Виводимо результат, коли потік завершує роботу
        System.out.println("Потік #" + threadNumber + ": Сума = " + sum + ", Кількість елементів = " + elementCount);
    }

    public void stopCalculation() {
        running = false; // Зупиняємо обчислення
    }
}
