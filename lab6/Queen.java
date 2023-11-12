package lab6;

public class Queen {
    private int row;
    private int column;

    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void move() {
        this.row++;
        if (this.row == Node.N) {
            this.row = 0;
        }
    }

    public boolean isConflict(Queen q) {
        return this.row == q.getRow() ||
                this.column == q.getColumn() ||
                Math.abs(this.row - q.getRow()) == Math.abs(this.column - q.getColumn());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
