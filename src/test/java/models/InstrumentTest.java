package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentTest {

    public Instrument setupNewInstrument() {
        return new Instrument ("Gibson", "Les Paul Custom", "USA", "xxx", "www.test.url", 1, true, false);
    }

    @Test
    public void newInstrumentInstantiatesCorrectly() {
        Instrument testInstrument = setupNewInstrument();
        assertTrue(testInstrument instanceof Instrument);
    }

    @Test
    public void setId_1() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setId(1);
        assertEquals(1, testInstrument.getId());
    }

    @Test
    public void getManufacturer_Gibson() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("Gibson", testInstrument.getManufacturer());
    }

    @Test
    public void setManufacturer() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setManufacturer("Fender");
        assertEquals("Fender", testInstrument.getManufacturer());
    }

    @Test
    public void getModel() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("Les Paul Custom", testInstrument.getModel());
    }

    @Test
    public void setModel() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setModel("Jazzmaster");
        assertEquals("Jazzmaster", testInstrument.getModel());
    }

    @Test
    public void getCountry() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("USA", testInstrument.getCountry());
    }

    @Test
    public void setCountry() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setCountry("Japan");
        assertEquals("Japan", testInstrument.getCountry());
    }

    @Test
    public void getSerialNumber() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("xxx", testInstrument.getSerialNumber());
    }

    @Test
    public void setSerialNumber() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setSerialNumber("zzz");
        assertEquals("zzz", testInstrument.getSerialNumber());
    }

    @Test
    public void getImageUrl() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("www.test.url", testInstrument.getImageUrl());
    }

    @Test
    public void setImageUrl() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setImageUrl("www.test.jpg");
        assertEquals("www.test.jpg", testInstrument.getImageUrl());
    }

    @Test
    public void getInstrumentTypeId() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(1, testInstrument.getInstrumentTypeId());
    }

    @Test
    public void setInstrumentTypeId() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setInstrumentTypeId(2);
        assertEquals(2, testInstrument.getInstrumentTypeId());
    }

    @Test
    public void getCurrent() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(true, testInstrument.getCurrent());
    }

    @Test
    public void setCurrent() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setCurrent(false);
        assertEquals(false, testInstrument.getCurrent());
    }


    @Test
    public void getWishlist() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(false, testInstrument.getWishlist());
    }

    @Test
    public void setWishlist() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setWishlist(true);
        assertEquals(true, testInstrument.getWishlist());
    }

}