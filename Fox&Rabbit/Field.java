import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Field {
    private static final Random rand = Randomizer.getRandom();
    private int depth, width;
    private Object[][] field;
    public Field(int depth, int width) {
        this.depth = depth;
        this.width = width;
        field = new Object[depth][width];
    }
    
    public void clear() {
        for (int row = 0; row < depth; row++) {
            for (int col = 0; col < width; col++) {
                field[row][col] = null;
            }
        }
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }
    
    public void place(Object animal, Location location) {
        field[location.getRow()][location.getCol()] = animal;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> adjacent = new LinkedList<>();
        int row = location.getRow();
        int col = location.getCol();
        for (int roffset = -1; roffset <= 1; roffset++) {
            int nextRow = row + roffset;
            if (nextRow >= 0 && nextRow < depth) {
                for (int coffset = -1; coffset <= 1; coffset++) {
                    int nextCol = col + coffset;
                    if (nextCol >= 0 && nextCol < width && (roffset != 0 || coffset != 0)) {
                        adjacent.add(new Location(nextRow, nextCol));
                    }
                }
            }
        }
        return adjacent;
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = getFreeAdjacentLocations(location);
        if (free.size() > 0) {
            return free.get(0);
        } else {
            return null;
        }
    }
    
    public List<Location> getFreeAdjacentLocations(Location location) {
        List<Location> free = new LinkedList<>();
        List<Location> adjacent = adjacentLocations(location);
        for (Location next : adjacent) {
            if (getObjectAt(next) == null) {
                free.add(next);
            }
        }
        Collections.shuffle(free, rand);
        return free;
    }
    
    public int getDepth() { return depth; }
    public int getWidth() { return width; }
}