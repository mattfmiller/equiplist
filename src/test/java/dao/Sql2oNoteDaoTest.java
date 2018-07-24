
package dao;

import models.Note;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oNoteDaoTest {

    private static Sql2oNoteDao noteDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/equiplist_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        noteDao = new Sql2oNoteDao(sql2o);
        conn = sql2o.open();
    }

    public Note setupNewNote(){
        return new Note("Upgraded Sleeve", 1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        noteDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void add_addingNoteSetsId() {
        Note testNote = setupNewNote();
        int originalIdOfNote = testNote.getId();
        noteDao.add(testNote);
        assertNotEquals(originalIdOfNote, testNote.getId());
    }

    @Test
    public void getAllByInstrumentId() {
        Note testNote = setupNewNote();
        Note testNote2 = new Note("Cool dude", 2);
        Note testNote3 = new Note("whatever", 1);
        noteDao.add(testNote);
        noteDao.add(testNote2);
        noteDao.add(testNote3);
        assertEquals(2, noteDao.getAllByInstrumentId(1).size());
    }

//    @Test
//    public void findById() {
//        Note testNote = setupNewNote();
//        Note testNote2 = new Note("Cool dude", 2);
//        Note testNote3 = new Note("whatever", 1);
//        noteDao.add(testNote);
//        noteDao.add(testNote2);
//        noteDao.add(testNote3);
//        assertEquals("Cool dude", noteDao.findById(2).getContent());
//    }

    @Test
    public void update() {
        Note testNote = setupNewNote();
        noteDao.add(testNote);
        Note testNote2 = new Note("cool man", 1);
        noteDao.update(testNote.getId(), testNote2);
        List<Note> foundNotes = noteDao.getAllByInstrumentId(1);
        assertEquals("cool man", foundNotes.get(0).getContent());
    }

    @Test
    public void deleteById() {
        Note testNote = setupNewNote();
        noteDao.add(testNote);
        noteDao.deleteById(testNote.getId());
        assertEquals(0, noteDao.getAllByInstrumentId(1).size());
    }

    @Test
    public void clearAllNotesByInstrumentId() {
        Note testNote = setupNewNote();
        noteDao.add(testNote);
        noteDao.clearAllNotesByInstrumentId(testNote.getInstrumentId());
        assertEquals(0, noteDao.getAllByInstrumentId(1).size());
    }

    @Test
    public void clearAll() throws Exception {
        Note testNote = setupNewNote();
        Note testNote2 = new Note("Cool dude", 1);
        Note testNote3 = new Note("whatever", 1);
        noteDao.add(testNote);
        noteDao.add(testNote2);
        noteDao.add(testNote3);
        noteDao.clearAll();
        List<Note> allNotes = noteDao.getAllByInstrumentId(1);
        assertEquals(0, allNotes.size());
    }

}