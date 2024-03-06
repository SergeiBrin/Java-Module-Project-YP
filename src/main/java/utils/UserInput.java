package utils;

import java.util.Scanner;

import exception.KopecksFormatException;

public class UserInput {
    private final static Scanner scanner = new Scanner(System.in);

    public static int enterNumberOfGuests() {
        int numberOfGuests;

        while (true) {
            try {
                numberOfGuests = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите число");
                continue;
            }

            if (numberOfGuests > 1) {
                break;
            } else {
                System.out.println("Ошибка. Введите число > 1");
            }
        }

        return numberOfGuests;
    }

    public static String enterProductName() {
        System.out.println("Введите название продукта");
        return scanner.nextLine();
    }

    public static double enterCostOfTheProduct() {
        System.out.println("Введите сумму товара в формате рубли.копейки");

        double cost;
        while (true) {
            try {
                String line = scanner.nextLine();
                cost = Double.parseDouble(line);
                validateKopecksAmount(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите число в формате рубли.копейки ");
                continue;
            } catch (KopecksFormatException e) {
                System.out.println("Ошибка. Введите копейки в формате .xx");
                continue;
            }

            if (cost < 0) {
                System.out.println("Введите положительное число");
            } else {
                return cost;
            }
        }
    }

    public static String askToContinueAddingProducts() {
        return scanner.nextLine();
    }

    private static void validateKopecksAmount(String line) throws KopecksFormatException {
        String kopecks;
        try {
            kopecks = line.split("\\.")[1];
        } catch (IndexOutOfBoundsException e) {
            throw new KopecksFormatException();
        }

        int length = kopecks.length();
        if (length != 2) {
            throw new KopecksFormatException();
        }
    }
}
