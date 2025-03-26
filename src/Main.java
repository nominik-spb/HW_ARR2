import java.util.Scanner;

public class Main {

    public static String[] products = {"Хлеб", "Яблоки", "Молоко"};
    public static int[] prices = {100, 200, 300};
    public static int[] count = new int[products.length];

    public static void main(String[] args) {

        // вывод на экран информации о продуктах и стоимости

        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        int sumProducts = 0;

        // сканируем ввод пользователя

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите товар и количество (через пробел) или введите `end`");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int prodNumber = Integer.parseInt(parts[0]) - 1;
            int prodCount = Integer.parseInt(parts[1]);

            count[prodNumber] = count[prodNumber] + prodCount;
        }

        System.out.println("Ваша корзина:");
        System.out.println("______________________________________");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                sumProducts += prices[i] * count[i];
                System.out.println(products[i] + " (" + count[i] + "шт. по " + prices[i] + " руб/шт.) в сумме - " + prices[i] * count[i] + " руб.");
            }
        }
        System.out.println("______________________________________");
        System.out.println("Итого: " + sumProducts + "руб.");
    }
}