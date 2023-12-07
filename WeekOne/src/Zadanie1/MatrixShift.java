package Zadanie1;

import java.util.Random;
import java.util.Scanner;

public class MatrixShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов матрицы: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        // Заполнение матрицы случайными значениями в интервале от -n до n
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(2 * Math.max(rows, columns) + 1) - Math.max(rows, columns);
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        System.out.print("Введите количество позиций для сдвига k: ");
        int k = scanner.nextInt();

        System.out.println("Выберите сторону сдвига:");
        System.out.println("1. Вправо");
        System.out.println("2. Влево");
        System.out.println("3. Вверх");
        System.out.println("4. Вниз");
        int choice = scanner.nextInt();

        int[][] shiftedMatrix = null;
        switch (choice) {
            case 1:
                shiftedMatrix = shiftRight(matrix, k);
                break;
            case 2:
                shiftedMatrix = shiftLeft(matrix, k);
                break;
            case 3:
                shiftedMatrix = shiftUp(matrix, k);
                break;
            case 4:
                shiftedMatrix = shiftDown(matrix, k);
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }

        if (shiftedMatrix != null) {
            System.out.println("Матрица после циклического сдвига на " + k + " позиций:");
            printMatrix(shiftedMatrix);
        }

        scanner.close();
    }

    // Метод для печати матрицы
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Методы для циклического сдвига матрицы на k позиций в разные стороны
    public static int[][] shiftRight(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][columns];

        k = k % columns;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                shiftedMatrix[i][(j + k) % columns] = matrix[i][j];
            }
        }

        return shiftedMatrix;
    }

    public static int[][] shiftLeft(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][columns];

        k = k % columns;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                shiftedMatrix[i][j] = matrix[i][(j + k) % columns];
            }
        }

        return shiftedMatrix;
    }

    public static int[][] shiftUp(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][columns];

        k = k % rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                shiftedMatrix[i][j] = matrix[(i + k) % rows][j];
            }
        }

        return shiftedMatrix;
    }

    public static int[][] shiftDown(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] shiftedMatrix = new int[rows][columns];

        k = k % rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                shiftedMatrix[i][j] = matrix[(i - k + rows) % rows][j];
            }
        }

        return shiftedMatrix;
    }
}
