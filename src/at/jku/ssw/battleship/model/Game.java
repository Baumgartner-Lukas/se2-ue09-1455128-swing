package at.jku.ssw.battleship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final Field field;

    public Game(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public boolean isRunning() {
        return getShipCount() > 0;
    }

    public int getShipCount() {
        int shipCount = 0;
        for (int row = 0; row < field.getSize(); row++) {
            for (int col = 0; col < field.getSize(); col++) {
                if (field.getState(row, col).equals(State.SHIP)) shipCount++;
            }
        }
        return shipCount;
    }

    /**
     * @return <code>true</code> if a ship has been hit, <code>false</code> otherwise.
     */
    public boolean fireAt(int row, int column) {
        boolean isShip = field.getState(row, column) == State.SHIP;
        if (isShip) {
            field.setState(row, column, State.HIT);
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = column - 1; c <= column + 1; c++) {
                    if (!((r < 0 || r > field.getSize() - 1) || (c < 0 || c > field.getSize() - 1))) {
                        if (field.getState(r, c) == State.SHIP)
                            field.setState(r, c, State.HIT);
                            //fireFieldEvent(State.HIT, field);
                    }
                }
            }
        } else {
            field.setState(row, column, State.MISS);
            //fireFieldEvent(State.MISS, field);
        }
        return isShip;

    }


    public static Field createRandomPlayingField(int fieldSize, int numShips) {
        if ((fieldSize * fieldSize) / numShips < 2) throw new IllegalArgumentException("Too many Ships!");
        int count = 0;
        Field f = new Field(fieldSize);
        while (count < numShips) {
            int row = getRand(fieldSize);
            int col = getRand(fieldSize);
            if (f.getState(row, col) != State.SHIP) {
                f.setState(row, col, State.SHIP);
                count++;
            }
        }
        return f;
    }

    private static int getRand(int fieldSize) {
        Random random = new Random();
        return Math.abs(random.nextInt() % fieldSize);
    }

}
