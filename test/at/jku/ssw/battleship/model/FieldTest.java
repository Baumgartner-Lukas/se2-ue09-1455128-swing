package at.jku.ssw.battleship.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class FieldTest {
    private Field field;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() throws Exception {
        field = new Field(3);
    }

    @Test
    public void constructor_GeneratesEmptyField() {
        for(int row = 0; row < field.getSize(); row++){
            for(int col = 0; col < field.getSize(); col++){
                assertEquals(State.FREE, field.getState(row, col));
            }
        }
    }

    @Test
    public void constructor_FieldSizeSmallerOneIsNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        Field f = new Field(0);
    }

    @Test
    public void setState_getState() {
        field.setState(2,2, State.HIT);
        assertEquals(State.HIT, field.getState(2,2));
    }

    @Test
    public void testGetSize() {
        assertEquals(3, field.getSize());
    }
}