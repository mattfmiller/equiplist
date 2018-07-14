package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuitarTest {

    public Guitar setupNewGuitar() {
        return new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "www.test.url", true, false, 10.75, "Mahogany", "Lacquer", "Ebony", "5-Ply", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "Volume, Tone", "Gibson Hardcase");
    }

    @Test
    public void newGuitarInstantiatesCorrectly() {
        Guitar testGuitar = setupNewGuitar();
        assertTrue(testGuitar instanceof Guitar);
    }

    @Test
    public void getWeight_1075() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals(10.75, testGuitar.getWeight(), 0.05);
    }

    @Test
    public void setWeight_1175() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setWeight(11.75);
        assertEquals(11.75, testGuitar.getWeight(), 0.05);
    }

    @Test
    public void getBodyWood_mahogany() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Mahogany", testGuitar.getBodyWood());
    }

    @Test
    public void setBodyWood_ash() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setBodyWood("Ash");
        assertEquals("Ash", testGuitar.getBodyWood());
    }

    @Test
    public void getFinish_lacquer() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Lacquer", testGuitar.getFinish());
    }

    @Test
    public void setFinish_poly() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setFinish("Poly");
        assertEquals("Poly", testGuitar.getFinish());
    }

    @Test
    public void getColor_ebony() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Ebony", testGuitar.getColor());
    }

    @Test
    public void setColor_white() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setColor("White");
        assertEquals("White", testGuitar.getColor());
    }

    @Test
    public void getBinding_5Ply() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("5-Ply", testGuitar.getBinding());
    }

    @Test
    public void setBinding_singlePly() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setBinding("Single Ply");
        assertEquals("Single Ply", testGuitar.getBinding());
    }

    @Test
    public void getNeckWood_mahogany() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Mahogany", testGuitar.getNeckWood());
    }

    @Test
    public void setNeckWood_maple() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setNeckWood("Maple");
        assertEquals("Maple", testGuitar.getNeckWood());
    }

    @Test
    public void getNeckType_set() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Set", testGuitar.getNeckType());
    }

    @Test
    public void setNeckType_boltOn() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setNeckType("Bolt On");
        assertEquals("Bolt On", testGuitar.getNeckType());
    }

    @Test
    public void getNeckProfile_1960sSlimTaper() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("1960's Slim Taper", testGuitar.getNeckProfile());
    }

    @Test
    public void setNeckProfile_1950sFat() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setNeckProfile("1950's Fat");
        assertEquals("1950's Fat", testGuitar.getNeckProfile());
    }

    @Test
    public void getFretboardWood_ebony() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Ebony", testGuitar.getFretboardWood());
    }

    @Test
    public void setFretboardWood_rosewood() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setFretboardWood("Rosewood");
        assertEquals("Rosewood", testGuitar.getFretboardWood());
    }

    @Test
    public void getFretboardRadius_12() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals(12.0, testGuitar.getFretboardRadius(), 0.05);
    }

    @Test
    public void setFretboardRadius_9() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setFretboardRadius(9.0);
        assertEquals(9.0, testGuitar.getFretboardRadius(), 0.05);
    }

    @Test
    public void getFrets_22() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals(22, testGuitar.getFrets());
    }

    @Test
    public void setFrets_21() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setFrets(21);
        assertEquals(21, testGuitar.getFrets());
    }

    @Test
    public void getFretMaterial_gibsonStyle() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Gibson Style", testGuitar.getFretMaterial());
    }

    @Test
    public void setFretMaterial_vintage() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setFretMaterial("Vintage");
        assertEquals("Vintage", testGuitar.getFretMaterial());
    }

    @Test
    public void getInlays_motherOfPearlBlock() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Mother of Pearl Block", testGuitar.getInlays());
    }

    @Test
    public void setInlays_dot() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setInlays("Dot");
        assertEquals("Dot", testGuitar.getInlays());
    }

    @Test
    public void getNutMaterial_bone() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Bone", testGuitar.getNutMaterial());
    }

    @Test
    public void setNutMaterial_plastic() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setNutMaterial("Plastic");
        assertEquals("Plastic", testGuitar.getNutMaterial());
    }

    @Test
    public void getNutWidth_16875() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals(1.6875, testGuitar.getNutWidth(), 0.0005);
    }

    @Test
    public void setNutWidth_17075() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setNutWidth(1.7075);
        assertEquals(1.7075, testGuitar.getNutWidth(), 0.0005);
    }

    @Test
    public void getScaleLength_2475() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals(24.75, testGuitar.getScaleLength(), 0.05);
    }

    @Test
    public void setScaleLength_255() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setScaleLength(25.5);
        assertEquals(25.5, testGuitar.getScaleLength(), 0.1);
    }

    @Test
    public void getNeckPickup_humbucker() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Humbucker", testGuitar.getNeckPickup());
    }

    @Test
    public void setNeckPickup_goldFoil() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setNeckPickup("Gold Foil");
        assertEquals("Gold Foil", testGuitar.getNeckPickup());
    }

    @Test
    public void getMiddlePickup_nA() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("N/A", testGuitar.getMiddlePickup());
    }

    @Test
    public void setMiddlePickup_humbucker() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setMiddlePickup("Humbucker");
        assertEquals("Humbucker", testGuitar.getMiddlePickup());
    }

    @Test
    public void getBridgePickup_humbucker() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Humbucker", testGuitar.getBridgePickup());
    }

    @Test
    public void setBridgePickup_tele() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setBridgePickup("Tele");
        assertEquals("Tele", testGuitar.getBridgePickup());
    }

    @Test
    public void getVolumePots_500KCTS() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("500K CTS", testGuitar.getVolumePots());
    }

    @Test
    public void setVolumePots_250KCTS() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setVolumePots("250K CTS");
        assertEquals("250K CTS", testGuitar.getVolumePots());
    }

    @Test
    public void getTonePots_500KCTS() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("500K CTS", testGuitar.getTonePots());
    }

    @Test
    public void setTonePots_1MCTS() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setTonePots("1M CTS");
        assertEquals("1M CTS", testGuitar.getTonePots());
    }

    @Test
    public void getCapacitor_sprague022uf() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Sprangue .022 uf", testGuitar.getCapacitor());
    }

    @Test
    public void setCapacitor_orangeDrop022uf() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setCapacitor("Orange Drop .022 uf");
        assertEquals("Orange Drop .022 uf", testGuitar.getCapacitor());
    }

    @Test
    public void getTuners_groverRotomatic() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Grover Rotomatic", testGuitar.getTuners());
    }

    @Test
    public void setTuners_kluson() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setTuners("Kluson");
        assertEquals("Kluson", testGuitar.getTuners());
    }

    @Test
    public void getTunerButtons_nickelKeystone() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Nickel Keystone", testGuitar.getTunerButtons());
    }

    @Test
    public void setTunerButtons_whiteButton() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setTunerButtons("White Button");
        assertEquals("White Button", testGuitar.getTunerButtons());
    }

    @Test
    public void getBridge_roller() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Roller", testGuitar.getBridge());
    }

    @Test
    public void setBridge_wraparound() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setBridge("Wrap-a-round");
        assertEquals("Wrap-a-round", testGuitar.getBridge());
    }

    @Test
    public void getTailpiece_bigsbyB7() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Bigsby B7", testGuitar.getTailpiece());
    }

    @Test
    public void setTailpiece_stop() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setTailpiece("Stop");
        assertEquals("Stop", testGuitar.getTailpiece());
    }

    @Test
    public void getGuitarSwitch_3way() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("3-way", testGuitar.getGuitarSwitch());
    }

    @Test
    public void setGuitarSwitch() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setGuitarSwitch("5-way");
        assertEquals("5-way", testGuitar.getGuitarSwitch());
    }

    @Test
    public void getKnobs_bellhat() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Bellhat", testGuitar.getKnobs());
    }

    @Test
    public void setKnobs_witchHat() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setKnobs("Witch Hat");
        assertEquals("Witch Hat", testGuitar.getKnobs());
    }

    @Test
    public void getPickguard_5ply() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("5-Ply", testGuitar.getPickguard());
    }

    @Test
    public void setPickguard_3ply() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setPickguard("3-Ply");
        assertEquals("3-Ply", testGuitar.getPickguard());
    }

    @Test
    public void getControls_volumeTone() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Volume, Tone", testGuitar.getControls());
    }

    @Test
    public void setControls_tone() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setControls("Tone");
        assertEquals("Tone", testGuitar.getControls());
    }

    @Test
    public void getGuitarCase_gibsonHardcase() {
        Guitar testGuitar = setupNewGuitar();
        assertEquals("Gibson Hardcase", testGuitar.getGuitarCase());
    }

    @Test
    public void setGuitarCase_gigBag() {
        Guitar testGuitar = setupNewGuitar();
        testGuitar.setGuitarCase("Gig Bag");
        assertEquals("Gig Bag", testGuitar.getGuitarCase());
    }
}