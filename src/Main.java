import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // создаем пустую начальную матрицу

        int[][] colors = new int[SIZE][SIZE];

        // заполняем матрицу случайными значениями

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        // вывод начальной матрицы на экран

        printMatrix(colors);

        // ждем ввода данных пользователем

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите угол поворота матрицы или введите `end`");
            System.out.println("1. поворот на 90°");
            System.out.println("2. поворот на 180°");
            System.out.println("3. поворот на 270°");
            String input = scanner.nextLine();

            int angleVar;

        // анализируем ввод пользователя

            if ("end".equals(input)) {
                break;
            } else if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 3) {
                angleVar = Integer.parseInt(input);
            } else {
                System.out.println("введено некорректное значение\n");
                continue;
            }
        // создаем и заполняем альтернативную матрицу

            int[][] rotatedColors = new int[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    switch (angleVar) {
                        case (1):
                            rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                            break;
                        case (2):
                            rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                            break;
                        case (3):
                            rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                            break;
                        default:
                            break;
                    }
                }
            }

        // вывод альтернативной матрицы на экран

            printMatrix (rotatedColors);

            break;
        }
    }
}