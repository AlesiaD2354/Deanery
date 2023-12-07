package Zadanie5;

import java.util.Scanner;

public class ModifyText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите символ для удаления или вставки:");
        char symbol = scanner.next().charAt(0);

        System.out.println("Введите признак (0 - удалить, 1 - вставить после k-го символа):");
        int sign = scanner.nextInt();

        if (sign == 0) {
            String modifiedText = text.replace(String.valueOf(symbol), "");
            System.out.println("Текст после удаления символа '" + symbol + "':");
            System.out.println(modifiedText);
        } else if (sign == 1) {
            System.out.println("Введите значение k:");
            int k = scanner.nextInt();

            StringBuilder modifiedText = new StringBuilder(text);
            int count = 0;
            int index = 0;

            while ((index = modifiedText.indexOf(String.valueOf(symbol), index)) != -1) {
                count++;
                if (index + 1 + k * count <= modifiedText.length()) {
                    modifiedText.insert(index + 1 + k * count, symbol);
                }
                index++;
            }

            System.out.println("Текст после вставки символа '" + symbol + "' после k-го символа:");
            System.out.println(modifiedText);
        } else {
            System.out.println("Некорректный признак. Введите 0 или 1.");
        }

        scanner.close();
    }
}