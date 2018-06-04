package at.jku.ssw.battleship.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GameTest {
    private Game g;
    private Field f;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
         f = new Field(3);
         f.setState(0,0,State.SHIP);
         f.setState(1,1, State.SHIP);
         f.setState(2,2,State.SHIP);
         g = new Game(f);
    }

    @Test
    public void constructor_whatToTest(){
        /*
        What can  be tested here?


         */
    }

    @Test
    public void getField_returnsField() {
        assertEquals(f, g.getField());
    }

    @Test
    public void getShipCount_returnsTrueIfCountGreaterZero() {
        assertEquals(3, g.getShipCount());
    }

    @Test
    public void getShipCount_returnsFalseIfCountEqualsZero() {
        g.fireAt(1,1);
        assertEquals(0, g.getShipCount());
    }

    @Test
    public void getShipCount_returnsRightAmountOfShips() {
        assertEquals(3, g.getShipCount());
    }

    @Test
    public void fireAt_setsFieldToHITIfShipIsHit() {
        g.fireAt(1,1);
        assertEquals(State.HIT, f.getState(1,1));
    }

    @Test
    public void fireAt_setsSurroundingFieldsToHit() {
        g.fireAt(1,1);
        assertEquals(State.HIT, f.getState(0,0));
        assertEquals(State.HIT, f.getState(2,2));
    }

    @Test
    public void fireAt_setsFieldToMISSIfNoShipIsHit() {
        g.fireAt(0,1);
        assertEquals(State.MISS, f.getState(0,1));
    }

    @Test
    public void shipCountGreaterThanHalfofFieldSizeIsNotAllowed(){
        thrown.expect(IllegalArgumentException.class);
        Game.createRandomPlayingField(3,5);
    }




}