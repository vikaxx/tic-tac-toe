package my.repo;

public class Field {
    Item[][] field = new Item[3][3];

    public Item[][] getField() {
        return field;
    }

    public void createField(Item[][] field) {
        this.field = new Item[][]{
                {Item.NONE, Item.NONE, Item.NONE},
                {Item.NONE, Item.NONE, Item.NONE},
                {Item.NONE, Item.NONE, Item.NONE}
        };
    }

    public void changeCellStateTo(int row, int col, Item element){
        field[row][col] = element;
    }

    public boolean isMoveAllowed() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == Item.NONE) {
                    return true;
                }
            }
        }
        return false;
    }

    


}
