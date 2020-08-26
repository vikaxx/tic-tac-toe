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
        return diagonal() || addDiagonal() || vertical() || horizontal();
    }

    private boolean diagonal() {
        if (field[1][1].equals(Item.NONE)) return false;
        boolean res = false;
        for (int i = 0; i < field.length; i++) {
            res = field[i][i].equals(field[1][1]);
            if (!res) break;
        }
        return res;
    }

    private boolean addDiagonal() {
        if (field[1][1].equals(Item.NONE)) return false;
        boolean res = false;
        for (int i = 0; i < field.length; i++) {
            res = field[i][field.length - i - 1].equals(field[1][1]);
            if (!res) break;
        }
        return res;
    }


    private boolean vertical() {
        boolean res = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][i].equals(Item.NONE)) break;
                res = field[j][i].equals(field[i][i]);
                if (!res) break;
            }
            if (res) return res;
        }
        return res;
    }

    private boolean horizontal() {
        boolean res = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][i].equals(Item.NONE)) break;
                res = field[i][j].equals(field[i][i]);
                if (!res) break;
            }
            if (res) return res;
        }
        return res;
    }


}
