package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionalImageTest {

    public AdditionalImage setupNewAdditionalImage() {
        return new AdditionalImage("www.test.com", 1);
    }

    @Test
    public void newAdditionalImageInstantiatesCorrectly() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        assertTrue(testAdditionalImage instanceof AdditionalImage);
    }

    @Test
    public void setId() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        testAdditionalImage.setId(1);
        assertEquals(1, testAdditionalImage.getId());
    }

    @Test
    public void setUrl() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        testAdditionalImage.setUrl("www.test2.com");
        assertEquals("www.test2.com", testAdditionalImage.getUrl());
    }

    @Test
    public void setInstrumentId() {
        AdditionalImage testAdditionalImage = setupNewAdditionalImage();
        testAdditionalImage.setInstrumentId(2);
        assertEquals(2, testAdditionalImage.getInstrumentId());
    }
}