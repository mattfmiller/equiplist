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
    public void setId() {
    }

    @Test
    public void getContent() {
    }

    @Test
    public void setContent() {
    }

    @Test
    public void getInstrumentId() {
    }

    @Test
    public void setInstrumentId() {
    }
}