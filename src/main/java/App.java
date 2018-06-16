import com.google.gson.Gson;
import dao.Sql2oGuitarDao;
import dao.Sql2oInstrumentTypeDao;
import models.Guitar;
import models.InstrumentType;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oInstrumentTypeDao instrumentTypeDao;
        Sql2oGuitarDao guitarDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/equiplist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        instrumentTypeDao = new Sql2oInstrumentTypeDao(sql2o);
        guitarDao = new Sql2oGuitarDao(sql2o);
        conn = sql2o.open();

        post("/instrumentTypes/new", "application/json", (req, res) -> {
            InstrumentType instrumentType = gson.fromJson(req.body(), InstrumentType.class);
            instrumentTypeDao.add(instrumentType);
            res.status(201);
            return gson.toJson(instrumentType);
        });

        get("/instrumentTypes", "application/json", (req, res) -> {
            return gson.toJson(instrumentTypeDao.getAll());
        });

        get("/instrumentTypes/:instrumentTypeId", "application/json", (req, res) -> {
            int instrumentTypeId = Integer.parseInt(req.params("instrumentTypeId"));
            return gson.toJson(instrumentTypeDao.findById(instrumentTypeId));
        });

        post("/guitars/new", "application/json", (req, res) -> {
            Guitar guitar = gson.fromJson(req.body(), Guitar.class);
            guitarDao.add(guitar);
            res.status(201);
            return gson.toJson(guitar);
        });
    }

}
