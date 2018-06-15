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
    public void setId_1() {
        GuitarType testGuitarType = setupNewGuitarType();
        testGuitarType.setId(1);
        assertEquals(1, testGuitarType.getId());
    }

    @Test
    public void getName_electric() {
        GuitarType testGuitarType = setupNewGuitarType();
        assertEquals("Electric", testGuitarType.getName());
    }

    @Test
    public void setName_acoustic() {
        GuitarType testGuitarType = setupNewGuitarType();
        testGuitarType.setName("Acoustic");
        assertEquals("Acoustic", testGuitarType.getName());
    }
}