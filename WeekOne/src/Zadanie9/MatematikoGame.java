package Zadanie9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MatematikoGame {
    private static final int BOARD_SIZE = 5;
    private static final int TOTAL_CARDS = 52;
    private static final int MAX_NUM_PER_CARD = 13;
    private static final int MAX_CARDS_PER_NUM = 4;

    private int[][] board;
    private List<Integer> cards;

    public MatematikoGame() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        cards = new ArrayList<>();

        for (int i = 1; i <= MAX_NUM_PER_CARD; i++) {
            for (int j = 0; j < MAX_CARDS_PER_NUM; j++) {
                cards.add(i);
            }
        }

        Collections.shuffle(cards);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int turns = BOARD_SIZE * BOARD_SIZE;
        int currentPlayer = 1;
        int scorePlayer1 = 0;
        int scoreComputer = 0;

        for (int turn = 0; turn < turns; turn++) {
            System.out.println("Ход игрока " + currentPlayer);

            if (currentPlayer == 1) {
                scorePlayer1 += playerMove(scanner); // Обновляем очки игрока 1
            } else {
                scoreComputer += computerMove(random);
            }

            printBoard();

            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("Игра завершена!");
        int totalScore = calculateScore();
        if (currentPlayer == 1) {
            scorePlayer1 = totalScore;
        }

        System.out.println("Общее количество очков игрока 1: " + scorePlayer1);
        System.out.println("Общее количество очков компьютера: " + scoreComputer);
    }

    private int playerMove(Scanner scanner) {
        int selectedCard = cards.remove(0);
        System.out.println("Выбрано число: " + selectedCard);

        int row, col;
        do {
            System.out.print("Введите номер строки (1-" + BOARD_SIZE + "): ");
            row = scanner.nextInt() - 1;
            System.out.print("Введите номер столбца (1-" + BOARD_SIZE + "): ");
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = selectedCard;

        return calculateScore(); // Возвращаем количество очков, полученных за этот ход
    }

    private int computerMove(Random random) {
        int selectedCard = cards.remove(0);
        int row, col;
        do {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);
        } while (!isValidMove(row, col));

        board[row][col] = selectedCard;
        System.out.println("Компьютер выбрал ячейку: [" + (row + 1) + "," + (col + 1) + "]");

        return calculateScore(); // Возвращаем количество очков, полученных за этот ход
    }


    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == 0;
    }

    private int calculateScore() {
        int totalScore = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            totalScore += checkCombination(board[i]);
            int[] col = new int[BOARD_SIZE];
            for (int j = 0; j < BOARD_SIZE; j++) {
                col[j] = board[j][i];
            }
            totalScore += checkCombination(col);
        }

        int[] diagonal1 = new int[BOARD_SIZE];
        int[] diagonal2 = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            diagonal1[i] = board[i][i];
            diagonal2[i] = board[i][BOARD_SIZE - 1 - i];
        }
        totalScore += checkCombination(diagonal1);
        totalScore += checkCombination(diagonal2);

        return totalScore;
    }

    private int checkCombination(int[] arr) {
        int score = 0;
        int[] counts = new int[MAX_NUM_PER_CARD + 1];
        for (int num : arr) {
            counts[num]++;
        }

        for (int count : counts) {
            if (count == 2) {
                score += 10;
            } else if (count == 4) {
                score += 20;
            } else if (count == 3) {
                score += 40;
            } else if (count == 5) {
                score += 50;
            } else if (count == 3 && containsNumberNTimes(counts, 2)) {
                score += 80;
            } else if (count == 4 && containsNumberNTimes(counts, 1)) {
                score += 100;
            } else if (count == 1 && containsNumberNTimes(counts, 5)) {
                score += 150;
            } else if (count == 1 && counts[13] == 3 && counts[1] == 2) {
                score += 200;
            } else if (counts[1] == 1 && counts[13] == 1 && counts[12] == 1 && counts[11] == 1 && counts[10] == 1) {
                score += 160;
            } else if (counts[1] == 4) {
                score += 170;
            } else if (counts[1] == 3 && counts[13] == 2) {
                score += 90;
            } else if (counts[1] == 1 && counts[13] == 3) {
                score += 110;
            } else if (isSequenceOfFive(counts)) {
                score += 60;
            } else if (count == 3 && counts[1] == 3 && counts[13] == 2) {
                score += 100;
            }

        }

        return score;
    }

    private boolean containsNumberNTimes(int[] counts, int n) {
        for (int count : counts) {
            if (count == n) {
                return true;
            }
        }
        return false;
    }

    private boolean isSequenceOfFive(int[] counts) {
        for (int i = 1; i <= 9; i++) {
            if (counts[i] != 1) {
                return false;
            }
        }
        return (counts[10] == 1 && counts[11] == 1 && counts[12] == 1 && counts[13] == 1 && counts[1] == 1);
    }

    private void printBoard() {
        System.out.println("Текущее состояние поля:");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatematikoGame game = new MatematikoGame();
        game.play();
    }
}