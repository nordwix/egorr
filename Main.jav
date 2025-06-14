#1
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[20]; 
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); 
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Масив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nКількість парних чисел: " + evenCount);
        System.out.println("Кількість непарних чисел: " + oddCount);
    }
}
#2
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість кутів багатокутника: ");
        int n = scanner.nextInt();

        int[] angles = new int[n];
        System.out.println("Введіть кути багатокутника:");
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Кут " + (i + 1) + ": ");
            angles[i] = scanner.nextInt();
            sum += angles[i];
        }

        int expectedSum = 180 * (n - 2);

        if (sum == expectedSum) {
            System.out.println("Багатокутник може існувати.");
        } else {
            System.out.println("Багатокутник не може існувати.");
        }
    }
}
#3
import java.util.Scanner;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Початковий масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.print("\nВведіть значення для пошуку: ");
        int findValue = scanner.nextInt();

        System.out.print("Введіть нове значення: ");
        int newValue = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            if (array[i] == findValue) {
                array[i] = newValue;
            }
        }

        System.out.println("Оновлений масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
#4
public class Task4 {
    public static void main(String[] args) {
        System.out.println("Таблиця синусів від 0 до 90 градусів:");
        int count = 0;

        for (int i = 0; i <= 90; i++) {
            double sinValue = Math.sin(Math.toRadians(i));
            System.out.printf("%.4f ", sinValue);
            count++;

            if (count % 10 == 0) {
                System.out.println(); 
            }
        }
    }
}
#5
import java.util.Scanner;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.print("\nОберіть тип перевірки (1 - зростання, 2 - спадання): ");
        int choice = scanner.nextInt();

        boolean isSorted = true;

        if (choice == 1) {
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    break;
                }
            }
            System.out.println(isSorted ? "Масив впорядкований за зростанням." : "Масив НЕ впорядкований за зростанням.");
        } else if (choice == 2) {
            for (int i = 0; i < size - 1; i++) {
                if (array[i] < array[i + 1]) {
                    isSorted = false;
                    break;
                }
            }
            System.out.println(isSorted ? "Масив впорядкований за спаданням." : "Масив НЕ впорядкований за спаданням.");
        } else {
            System.out.println("Невірний вибір.");
        }
    }
}



