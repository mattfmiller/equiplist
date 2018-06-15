package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentTest {

    public Instrument setupNewInstrument() {
        return new Instrument ("Gibson", "Les Paul Custom", "USA", "xxx", "www.test.url", 1, true);
    }

    @Test
    public void newInstrumentInstantiatesCorrectly() {
        Instrument testInstrument = setupNewInstrument();
        assertTrue(testInstrument instanceof Instrument);
    }

    @Test
    public void setId() {
    }

    @Test
    public void getManufacturer() {
    }

    @Test
    public void setManufacturer() {
    }

    @Test
    public void getModel() {
    }

    @Test
    public void setModel() {
    }

    @Test
    public void getCountry() {
    }

    @Test
    public void setCountry() {
    }

    @Test
    public void getSerialNumber() {
    }

    @Test
    public void setSerialNumber() {
    }

    @Test
    public void getImageUrl() {
    }

    @Test
    public void setImageUrl() {
    }

    @Test
    public void getInstrumentTypeId() {
    }

    @Test
    public void setInstrumentTypeId() {
    }

    @Test
    public void getCurrent() {
    }

    @Test
    public void setCurrent() {
    }
}