package at.jku.ssw.battleship.model;

import java.util.EventListener;

public interface FieldListener extends EventListener {
    public void fieldEvent(FieldEvent event);
}
