public class Location {
    private final int row;
    private final int col;
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Location) {
            Location other = (Location) obj;
            return row == other.getRow() && col == other.getCol();
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (row << 16) + col;
    }
    
    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}