package dao;

import models.Note;

import java.util.List;

public interface NoteDao {
    // CREATE
    void add(Note note);

    // READ
    List<Note> getAllByInstrumentId(int id);
    Note findById(int id);

    // UPDATE
    void update(int id, Note note);

    // DELETE
    void deleteById(int id);
    void clearAllNotesByInstrumentId( int id);
    void clearAll();
}
