package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {

    public Note setupNewNote() {
        return new Note("Added custom neck plate.", 1);
    }

    @Test
    public void newNoteInstantiatesCorrectly() {
        Note testNote = setupNewNote();
        assertTrue(testNote instanceof Note);
    }

    @Test
    public void setId_1() {
        Note testNote = setupNewNote();
        testNote.setId(1);
        assertEquals(1, testNote.getId());
    }

    @Test
    public void getContent_addedCustomNeckPlate() {
        Note testNote = setupNewNote();
        assertEquals("Added custom neck plate.", testNote.getContent());
    }

    @Test
    public void setContent() {
        Note testNote = setupNewNote();
        testNote.setContent("Added bridge cover.");
        assertEquals("Added bridge cover.", testNote.getContent());
    }

    @Test
    public void getInstrumentId() {
        Note testNote = setupNewNote();
        assertEquals(1, testNote.getInstrumentId());
    }

    @Test
    public void setInstrumentId() {
        Note testNote = setupNewNote();
        testNote.setInstrumentId(2);
        assertEquals(2, testNote.getInstrumentId());
    }
}