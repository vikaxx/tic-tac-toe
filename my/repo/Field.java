package my.repo;

public class Field {
    private Item[][] field = new Item[3][3];

    public Field() {
        this.createField();
    }

    public Item[][] getField() {
        return field;
    }

    public void printField() {
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

    private void createField() {
        this.field = new Item[][]{
                {Item.NONE, Item.NONE, Item.NONE},
                {Item.NONE, Item.NONE, Item.NONE},
                {Item.NONE, Item.NONE, Item.NONE}
        };
    }

    public void changeCellStateTo(int row, int col, Item element) {
        field[row][col] = element;
    }

    public Item getCellState(int row, int col) {
        return field[row][col];
    }

    public boolean isMoveAllowed() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j].equals(Item.NONE)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSomebodyWin() {
        return diagonal() || vertical() || horizontal();
    }

    private boolean diagonal() {
        if (field[0][0].equals(field[1][1])) {
            if (field[0][0].equals(field[2][2])) {
                if (!field[1][1].equals(Item.NONE)) {
                    return true;
                }
            }

        } else if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[1][1].equals(Item.NONE)) {
            return true;
        }
        return false;
    }

    private boolean vertical() {
        for (int i = 0; i < field.length; i++) {
            if (!field[i][0].equals(Item.NONE) && field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean horizontal() {
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] != Item.NONE && field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                return true;
            }
        }
        return false;
    }






}
