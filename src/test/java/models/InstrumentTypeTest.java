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
    public void setId_1() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        testInstrumentType.setId(1);
        assertEquals(1, testInstrumentType.getId());
    }

    @Test
    public void getName_guitar() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        assertEquals("Guitar", testInstrumentType.getName());
    }

    @Test
    public void setName_amp() {
        InstrumentType testInstrumentType = setupNewInstrumentType();
        testInstrumentType.setName("Amp");
        assertEquals("Amp", testInstrumentType.getName());
    }
}