import com.google.gson.Gson;
import dao.Sql2oGuitarDao;
import models.Guitar;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oGuitarDao guitarDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/equiplist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        guitarDao = new Sql2oGuitarDao(sql2o);
        conn = sql2o.open();

        //post: add new guitar instrument
        post("/guitars/new", "application/json", (req, res) -> {
            Guitar guitar = gson.fromJson(req.body(), Guitar.class);
            guitarDao.add(guitar);
            res.status(201);
            return gson.toJson(guitar);
        });
    }

}
