package dao;

import models.Instrument;
import models.Note;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNoteDao implements NoteDao {

    private final Sql2o sql2o;

    public Sql2oNoteDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Note note) {
        String sql = "INSERT INTO notes (content, createdAt, instrumentId) VALUES (:content, :createdAt, :instrumentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(note)
                    .executeUpdate()
                    .getKey();
            note.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Note> getAllByInstrumentId(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM notes WHERE instrumentId = :id ORDER BY id DESC")
                    .addParameter("id", id)
                    .executeAndFetch(Note.class);
        }
    }

    @Override
    public Note findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * from notes WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Note.class);
        }
    }

    @Override
    public void update(int id, Note note) {
        String sql = "UPDATE notes SET content = :content WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("content", note.getContent())
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from notes WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAllNotesByInstrumentId(int id) {
        String sql = "DELETE from notes WHERE instrumentId = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from notes";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
