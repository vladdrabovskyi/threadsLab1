/**
 * Головний клас для запуску програми.
 */
public class Main {
    public static void main(String[] args) {
        // Створюємо керуючий потік для n потоків з кроком k і затримкою між зупинками x мс
        SequenceManager manager = new SequenceManager(3, 1, 100);
        manager.startThreads();
    }
}
