package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuitarTypeTest {

    public GuitarType setupNewGuitarType() {
        return new GuitarType("Electric");
    }

    @Test
    public void newGuitarTypeInstantiatesCorrectly() {
        GuitarType testGuitarType = setupNewGuitarType();
        assertTrue(testGuitarType instanceof GuitarType);
    }

    @Test
    public void getId() {

    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }
}