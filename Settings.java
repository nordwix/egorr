import java.io.*;
import java.util.Scanner;

public class Settings {
    public static int boardSize = 3;
    public static String player1 = "Player1";
    public static String player2 = "Player2";

    public static void loadSettings() {
        try {
            File file = new File("settings.txt");
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);
            boardSize = Integer.parseInt(sc.nextLine());
            player1 = sc.nextLine();
            player2 = sc.nextLine();
            sc.close();
        } catch (Exception e) {
            System.out.println("Помилка читання налаштувань.");
        }
    }

    public static void saveSettings() {
        try (FileWriter writer = new FileWriter("settings.txt")) {
            writer.write(boardSize + "\n");
            writer.write(player1 + "\n");
            writer.write(player2 + "\n");
        } catch (IOException e) {
            System.out.println("Помилка збереження налаштувань.");
        }
    }

    public static void configureSettings() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть розмір поля (3-9): ");
        boardSize = Integer.parseInt(sc.nextLine());
        System.out.print("Ім'я першого гравця: ");
        player1 = sc.nextLine();
        System.out.print("Ім'я другого гравця: ");
        player2 = sc.nextLine();
        saveSettings();
    }
}

