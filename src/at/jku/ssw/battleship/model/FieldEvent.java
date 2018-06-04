package at.jku.ssw.battleship.model;

import java.util.EventObject;

public class FieldEvent extends EventObject {

    private final Field field;
    private final State state;

    public FieldEvent(Game source, Field field, State state) {
        super(source);
        this.field = field;
        this.state = state;
    }

    public State getKind() {
        return state;
    }

    public Field getField() {
        return field;
    }

}
