package my.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static my.repo.Item.O;
import static my.repo.Item.X;

public class XO {

    public static void main(String[] args) {
        Field gameField = new Field();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isX = true;

        while (gameField.isMoveAllowed() && !gameField.isSomebodyWin()) {

            gameField.printField();

            if (isX) System.out.println("\nКрестики ходят! Сделайте ваш ход.");
            else System.out.println("\nНолики ходят! Сделайте ваш ход.");

            isX = gameProcess(reader, gameField, isX);
        }

        gameField.printField();

        if (gameField.isSomebodyWin()) {
            if (isX) System.out.println("Нолики выиграли!");
            else System.out.println("Крестики выиграли!");
        } else System.out.println("Ничья!");
    }

    private static int inputRow(BufferedReader reader) {
        int row = 10;
        System.out.print("Введите номер строки: ");
        try {
            row = Integer.parseInt(reader.readLine()) - 1;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if (row <= 2 && row >= 0) {
            return row;
        } else {
            System.out.println("Ошибка. Выберите строку от 1 до 3");
            return inputRow(reader);
        }
    }

    private static int inputCol(BufferedReader reader) {
        int col = 10;
        System.out.print("Введите номер столбца: ");
        try {
            col = Integer.parseInt(reader.readLine()) - 1;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if (col <= 2 && col >= 0) {
            return col;
        } else {
            System.out.println("Ошибка. Выберите столбец от 1 до 3");
            return inputCol(reader);
        }
    }

    private static boolean gameProcess(BufferedReader reader, Field gameField, boolean isX) {

        int row = inputRow(reader);
        int col = inputCol(reader);

        switch (gameField.getCellState(row, col)) {
            case X:
                System.out.println("Клетка занята. Выберите другую.");
                return gameProcess(reader, gameField, isX);
            case O:
                System.out.println("Клетка занята. Выберите другую.");
                return gameProcess(reader, gameField, isX);
            default:
                if (isX) {
                    gameField.changeCellStateTo(row, col, X);
                    isX = false;
                } else {
                    gameField.changeCellStateTo(row, col, O);
                    isX = true;
                }
        }
        return isX;
    }

}
