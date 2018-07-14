package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentTest {

    public Instrument setupNewInstrument() {
        return new Instrument ("Gibson", "Les Paul Custom", "USA", "xxx", "www.test.url", true, false);
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
    public void getManufacturer_gibson() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("Gibson", testInstrument.getManufacturer());
    }

    @Test
    public void setManufacturer_fender() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setManufacturer("Fender");
        assertEquals("Fender", testInstrument.getManufacturer());
    }

    @Test
    public void getModel_lesPaulCustom() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("Les Paul Custom", testInstrument.getModel());
    }

    @Test
    public void setModel_jazzmaster() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setModel("Jazzmaster");
        assertEquals("Jazzmaster", testInstrument.getModel());
    }

    @Test
    public void getCountry_usa() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("USA", testInstrument.getCountry());
    }

    @Test
    public void setCountry_japan() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setCountry("Japan");
        assertEquals("Japan", testInstrument.getCountry());
    }

    @Test
    public void getSerialNumber_xxx() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("xxx", testInstrument.getSerialNumber());
    }

    @Test
    public void setSerialNumber_zzz() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setSerialNumber("zzz");
        assertEquals("zzz", testInstrument.getSerialNumber());
    }

    @Test
    public void getImageUrl_url() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals("www.test.url", testInstrument.getImageUrl());
    }

    @Test
    public void setImageUrl_jpg() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setImageUrl("www.test.jpg");
        assertEquals("www.test.jpg", testInstrument.getImageUrl());
    }

    @Test
    public void getCurrent_true() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(true, testInstrument.getCurrent());
    }

    @Test
    public void setCurrent_false() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setCurrent(false);
        assertEquals(false, testInstrument.getCurrent());
    }


    @Test
    public void getWishlist_false() {
        Instrument testInstrument = setupNewInstrument();
        assertEquals(false, testInstrument.getWishlist());
    }

    @Test
    public void setWishlist_true() {
        Instrument testInstrument = setupNewInstrument();
        testInstrument.setWishlist(true);
        assertEquals(true, testInstrument.getWishlist());
    }
}