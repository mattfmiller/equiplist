package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuitarTest {

    public Guitar setupNewGuitar() {
        return new Guitar ("Gibson", "Les Paul Custom", "USA", "xxx", "www.test.url", 1, true, false, 10.75, "Mahogany", "Lacquer", "Ebony", "Mahogany", "Set", "1960's Slim Taper", "Ebony", 12.0, 22, "Gibson Style", "Mother of Pearl Block", "Bone", 1.6875, 24.75, "Humbucker", "N/A", "Humbucker", "500K CTS", "500K CTS", "Sprangue .022 uf", "Nickel Grover Rotomatic", "Nickel Keystone", "Roller", "Bigsby B7", "3-way", "Bellhat", "5-Ply", "N/A", "Volume, Tone", "Gibson Hardcase");
    }

    @Test
    public void newGuitarInstantiatesCorrectly() {
        Guitar testGuitar = setupNewGuitar();
        assertTrue(testGuitar instanceof Guitar);
    }

    @Test
    public void getWeight() {
    }

    @Test
    public void setWeight() {
    }

    @Test
    public void getBodyWood() {
    }

    @Test
    public void setBodyWood() {
    }

    @Test
    public void getFinish() {
    }

    @Test
    public void setFinish() {
    }

    @Test
    public void getColor() {
    }

    @Test
    public void setColor() {
    }

    @Test
    public void getNeckWood() {
    }

    @Test
    public void setNeckWood() {
    }

    @Test
    public void getNeckType() {
    }

    @Test
    public void setNeckType() {
    }

    @Test
    public void getNeckProfile() {
    }

    @Test
    public void setNeckProfile() {
    }

    @Test
    public void getFretboardWood() {
    }

    @Test
    public void setFretboardWood() {
    }

    @Test
    public void getFretboardRadius() {
    }

    @Test
    public void setFretboardRadius() {
    }

    @Test
    public void getFrets() {
    }

    @Test
    public void setFrets() {
    }

    @Test
    public void getFretMaterial() {
    }

    @Test
    public void setFretMaterial() {
    }

    @Test
    public void getInlays() {
    }

    @Test
    public void setInlays() {
    }

    @Test
    public void getNutMaterial() {
    }

    @Test
    public void setNutMaterial() {
    }

    @Test
    public void getNutWidth() {
    }

    @Test
    public void setNutWidth() {
    }

    @Test
    public void getScaleLength() {
    }

    @Test
    public void setScaleLength() {
    }

    @Test
    public void getNeckPickup() {
    }

    @Test
    public void setNeckPickup() {
    }

    @Test
    public void getMiddlePickup() {
    }

    @Test
    public void setMiddlePickup() {
    }

    @Test
    public void getBridgePickup() {
    }

    @Test
    public void setBridgePickup() {
    }

    @Test
    public void getVolumePots() {
    }

    @Test
    public void setVolumePots() {
    }

    @Test
    public void getTonePots() {
    }

    @Test
    public void setTonePots() {
    }

    @Test
    public void getCapacitor() {
    }

    @Test
    public void setCapacitor() {
    }

    @Test
    public void getTuners() {
    }

    @Test
    public void setTuners() {
    }

    @Test
    public void getTunerButtons() {
    }

    @Test
    public void setTunerButtons() {
    }

    @Test
    public void getBridge() {
    }

    @Test
    public void setBridge() {
    }

    @Test
    public void getTailpiece() {
    }

    @Test
    public void setTailpiece() {
    }

    @Test
    public void getGuitarSwitch() {
    }

    @Test
    public void setGuitarSwitch() {
    }

    @Test
    public void getKnobs() {
    }

    @Test
    public void setKnobs() {
    }

    @Test
    public void getPickguard() {
    }

    @Test
    public void setPickguard() {
    }

    @Test
    public void getNeckPlate() {
    }

    @Test
    public void setNeckPlate() {
    }

    @Test
    public void getControls() {
    }

    @Test
    public void setControls() {
    }

    @Test
    public void getGuitarCase() {
    }

    @Test
    public void setGuitarCase() {
    }
}