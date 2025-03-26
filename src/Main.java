import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;

    public static void rotateColors(int[][] colors, int angleVar) {

        // создаем пустой аналог первоначальной матрицы

        int[][] rotatedColors = new int[SIZE][SIZE];

        // заполняем аналог матрицы с выводом на экран в зависимости от переданного значения поворота

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (angleVar == 1) {
                    rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                } else if (angleVar == 2) {
                    rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                } else {
                    rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                }
                System.out.format("%4d", rotatedColors[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // создаем пустую матрицу

        int[][] colors = new int[SIZE][SIZE];

        // заполняем матрицу случайными значениями

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        // выводим матрицу на экран

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }

        // ждем ввода данных пользователем

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите угол поворота матрицы или введите `end`");
            System.out.println("1. поворот на 90°");
            System.out.println("2. поворот на 180°");
            System.out.println("3. поворот на 270°");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            } else if (Integer.parseInt(input) > 3 || Integer.parseInt(input) < 1) {
                System.out.println("введено некорректное значение\n");
                continue;
            }

            // если введен корректный вариант поворота выполняем метод

            rotateColors(colors, Integer.parseInt(input));
            break;
        }
    }
}