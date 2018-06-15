package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentTypeTest {

    public InstrumentType setupNewInstrumentType() {
        return new InstrumentType("Guitar");
    }

    @Test
    public void newInstrumentTypeInstantiatesCorrectly() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        assertTrue(testInstrumentType instanceof InstrumentType);
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