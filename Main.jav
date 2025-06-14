import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Settings.loadSettings();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Нова гра");
            System.out.println("2. Налаштування");
            System.out.println("3. Показати статистику");
            System.out.println("4. Вихід");
            System.out.print("Ваш вибір: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> Game.playGame();
                case "2" -> Settings.configureSettings();
                case "3" -> Statistics.showStatistics();
                case "4" -> {
                    return;
                }
                default -> System.out.println("Невірний вибір.");
            }
        }
    }
}
