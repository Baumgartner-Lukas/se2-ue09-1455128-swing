package at.jku.ssw.battleship.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<FieldListener> listeners = new ArrayList<>();
    private State grid[][];

    public Field(int size) {
        if (size < 1) throw new IllegalArgumentException("Field size must be at least 1");
        grid = new State[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = State.FREE;
            }
        }
    }

    public State getState(int row, int column) {
        if ((row > grid.length || row < 0) ||
                (column > grid.length || column < 0)) return State.FREE;
        return grid[row][column];
    }

    public void setState(int row, int column, State newState) {
        grid[row][column] = newState;
    }

    public int getSize() {
        return grid.length;
    }

    //ue-09-swing

    public void addFieldListener(FieldListener listener) {
        listeners.add(listener);
    }

    public void removeFieldListener(FieldListener listener) {
        listeners.remove(listener);

    }

    public void fireFieldEvent() {
    }

    //ue-09-swing
}
