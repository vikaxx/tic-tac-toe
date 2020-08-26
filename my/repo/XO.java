package my.repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XO {

    public static void main(String[] args) {
        Field gameField = new Field();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isX = true;

        int row = 0;
        int col = 0;
        while (gameField.isMoveAllowed() && !gameField.isSomebodyWin()) {
            gameField.printField();
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


            switch (gameField.getCellState(row,col)) {
                case X:
                    System.out.println("Клетка занята. Выберите другую.");
                    continue;
                case O:
                    System.out.println("Клетка занята. Выберите другую.");
                    continue;
                default:
                    if (isX) {
                        gameField.changeCellStateTo(row,col,Item.X);
                        isX = false;
                    } else {
                        gameField.changeCellStateTo(row,col,Item.O);
                        isX = true;
                    }
            }


        } // end of while loop

        gameField.printField();


        if (gameField.isSomebodyWin()) {
            if (isX) System.out.println("Нолики выиграли!");
            else System.out.println("Крестики выиграли!");
        } else System.out.println("Ничья!");


    }
}
