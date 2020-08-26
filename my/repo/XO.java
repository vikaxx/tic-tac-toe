package my.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XO {

    public static void main(String[] args) {
        Field gameField = new Field();
        Item[][] field = gameField.createField();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isEndGame = false;
        boolean isX = true;

        int row = 0;
        int col = 0;
        while (!isEndGame) {
            outPut(field);
            if (isX) System.out.println("\nКрестики ходят! Сделайте ваш ход.");
            else System.out.println("\nНолики ходят! Сделайте ваш ход.");
//            String line = reader.readLine();
            try {
                row = Integer.parseInt(reader.readLine())-1;
                if (row > 3 || row < 0) {
                    System.out.println("Ошибка. Выберите строку от 1 до 3");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                col = Integer.parseInt(reader.readLine())-1;
                if (col > 3 || col < 0) {
                    System.out.println("Ошибка. Выберите столбец от 1 до 3.");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            switch (field[row][col]) {
                case X:
                    System.out.println("Клетка занята. Выберите другую.");
                    continue;
                case O:
                    System.out.println("Клетка занята. Выберите другую.");
                    continue;
                default:
                    if (isX) {
                        field[row][col] = Item.X;
                        isX = false;
                    } else {
                        field[row][col] = Item.O;
                        isX = true;
                    }
            }

            isEndGame = true;
            if (isWin(field)) {
                continue;
            }

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == Item.NONE) {
                        isEndGame = false;
                        break;
                    }
                }
            }
        } // end of while loop

        outPut(field);

        if (isWin(field)) {
            if (isX) System.out.println("Нолики выиграли!");
            else System.out.println("Крестики выиграли!");
        } else System.out.println("Ничья!");


    } // end of main function

    public static void outPut(Item[][] field) {

        for (int i = 0; i < field.length; i++) {
            System.out.print("|");
            for (int j = 0; j < field.length; j++) {
                System.out.print(" ");
                switch (field[i][j]) {
                    case X:
                        System.out.print("x");
                        break;
                    case O:
                        System.out.print("o");
                        break;
                    default:
                        System.out.print(" ");
                }
                System.out.print(" |");
            }
            System.out.println("");
        }

    }

    public static boolean isWin(Item[][] field) {

        if (field[0][0] != Item.NONE && field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
            return true;
        } else if (field[0][2] != Item.NONE && field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
            return true;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][0] != Item.NONE && field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                    return true;
                } else if (field[0][i] != Item.NONE && field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                    return true;
                }
            }
        }
        return false;
    }

}
