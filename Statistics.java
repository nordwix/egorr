import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Statistics {
    public static void saveGameResult(String winner, int size) {
        try (FileWriter writer = new FileWriter("stats.txt", true)) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(time + "\n");
            writer.write(Settings.player1 + " (X) vs " + Settings.player2 + " (O)\n");
            writer.write("Переможець: " + winner + "\n");
            writer.write("Розмір поля: " + size + "\n");
            writer.write("---\n");
        } catch (IOException e) {
            System.out.println("Помилка збереження статистики.");
        }
    }

    public static void showStatistics() {
        try {
            File file = new File("stats.txt");
            if (!file.exists()) {
                System.out.println("Немає збереженої статистики.");
                return;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Помилка читання статистики.");
        }
    }
}

