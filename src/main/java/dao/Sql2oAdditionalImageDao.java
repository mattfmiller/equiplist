package dao;

import models.Instrument;
import models.AdditionalImage;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAdditionalImageDao implements AdditionalImageDao {

    private final Sql2o sql2o;

    public Sql2oAdditionalImageDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(AdditionalImage additionalImage) {
        String sql = "INSERT INTO additionalImages (url, instrumentId) VALUES (:url, :instrumentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(additionalImage)
                    .executeUpdate()
                    .getKey();
            additionalImage.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<AdditionalImage> getAllByInstrumentId(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM additionalImages WHERE instrumentId = :id ORDER BY id DESC")
                    .addParameter("id", id)
                    .executeAndFetch(AdditionalImage.class);
        }
    }

    @Override
    public AdditionalImage findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * from additionalImages WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(AdditionalImage.class);
        }
    }

    @Override
    public void update(int id, String url) {
        String sql = "UPDATE additionalImages SET url = :url WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("url", url)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from additionalImages WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAllAdditionalImagesByInstrumentId(int id) {
        String sql = "DELETE from additionalImages WHERE instrumentId = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from additionalImages";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
