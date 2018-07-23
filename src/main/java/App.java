import com.google.gson.Gson;
import dao.Sql2oGuitarDao;
import dao.Sql2oAmpDao;
import models.Guitar;
import models.Amp;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oGuitarDao guitarDao;
        Sql2oAmpDao ampDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/equiplist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        guitarDao = new Sql2oGuitarDao(sql2o);
        ampDao = new Sql2oAmpDao(sql2o);
        conn = sql2o.open();

        //post: add new guitar instrument
        post("/guitars/new", "application/json", (req, res) -> {
            Guitar guitar = gson.fromJson(req.body(), Guitar.class);
            guitarDao.add(guitar);
            res.status(201);
            return gson.toJson(guitar);
        });

        //get: show guitars in collection
        get("/guitars", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(guitarDao.getAllGuitarsInCollection());
        });

        //get: show guitars in wishlist
        get("/guitars/wishlist", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(guitarDao.getAllGuitarsInWishlist());
        });

        //post: add new amp instrument
        post("/amps/new", "application/json", (req, res) -> {
            Amp amp = gson.fromJson(req.body(), Amp.class);
            ampDao.add(amp);
            res.status(201);
            return gson.toJson(amp);
        });

        //get: show amps in collection
        get("/amps", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(ampDao.getAllAmpsInCollection());
        });

        //get: show amps in wishlist
        get("/amps/wishlist", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(ampDao.getAllAmpsInWishlist());
        });
    }
}
