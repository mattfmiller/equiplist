import com.google.gson.Gson;
import dao.*;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import filters.CorsFilter;
import exceptions.ApiException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Sql2oGuitarDao guitarDao;
        Sql2oAmpDao ampDao;
        Sql2oPedalDao pedalDao;
        Sql2oNoteDao noteDao;
        Sql2oAdditionalImageDao additionalImageDao;
        Connection conn;
        Gson gson = new Gson();
        CorsFilter.apply();

//        String connectionString = "jdbc:h2:~/equiplist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");

        String connectionString = "jdbc:h2:~/equiplist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        guitarDao = new Sql2oGuitarDao(sql2o);
        ampDao = new Sql2oAmpDao(sql2o);
        pedalDao = new Sql2oPedalDao(sql2o);
        noteDao = new Sql2oNoteDao(sql2o);
        additionalImageDao = new Sql2oAdditionalImageDao(sql2o);
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
            String query = req.queryParams("query");
            List<Guitar> guitarsInCollection = guitarDao.getAllGuitarsInCollection();
            if (guitarsInCollection.size() > 0) {
                if (query != null) {
                    return gson.toJson(guitarDao.search(query));
                } else {
                    return gson.toJson(guitarDao.getAllGuitarsInCollection());
                }
            } else {
                return "{\"message\":\"I'm sorry, but no guitars are currently listed in the collection.\"}";
            }
        });

        //get: show guitars in wishlist
        get("/guitars/wishlist", "application/json", (req, res) -> {
            res.type("application/json");
            List<Guitar> guitarsInWishlist= guitarDao.getAllGuitarsInWishlist();
            if (guitarsInWishlist.size() > 0 ) {
                return gson.toJson(guitarDao.getAllGuitarsInWishlist());
            } else {
                return "{\"message\":\"I'm sorry, but no guitars are currently listed in the wishlist.\"}";
            }

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
            String query = req.queryParams("query");
            List<Amp> ampsInCollection = ampDao.getAllAmpsInCollection();
            if (ampsInCollection.size() > 0) {
                if (query != null) {
                    return gson.toJson(ampDao.search(query));
                } else {
                    return gson.toJson(ampDao.getAllAmpsInCollection());
                }
            } else {
                return "{\"message\":\"I'm sorry, but no amps are currently listed in the collection.\"}";
            }
        });

        //get: show amps in wishlist
        get("/amps/wishlist", "application/json", (req, res) -> {
            res.type("application/json");
            List<Amp> ampsInWishlist= ampDao.getAllAmpsInWishlist();
            if (ampsInWishlist.size() > 0 ) {
                return gson.toJson(ampDao.getAllAmpsInWishlist());
            } else {
                return "{\"message\":\"I'm sorry, but no amps are currently listed in the wishlist.\"}";
            }
        });

        //post: add new pedal instrument
        post("/pedals/new", "application/json", (req, res) -> {
            Pedal pedal = gson.fromJson(req.body(), Pedal.class);
            pedalDao.add(pedal);
            res.status(201);
            return gson.toJson(pedal);
        });

        //get: show pedals in collection
        get("/pedals", "application/json", (req, res) -> {
            res.type("application/json");
            String query = req.queryParams("query");
            List<Pedal> pedalsInCollection = pedalDao.getAllPedalsInCollection();
            if (pedalsInCollection.size() > 0) {
                if (query != null) {
                    return gson.toJson(pedalDao.search(query));
                } else {
                    return gson.toJson(pedalDao.getAllPedalsInCollection());
                }
            } else {
                return "{\"message\":\"I'm sorry, but no pedals are currently listed in the collection.\"}";
            }
        });

        //get: show pedals in wishlist
        get("/pedals/wishlist", "application/json", (req, res) -> {
            res.type("application/json");
            List<Pedal> pedalsInWishlist= pedalDao.getAllPedalsInWishlist();
            if (pedalsInWishlist.size() > 0 ) {
                return gson.toJson(pedalDao.getAllPedalsInWishlist());
            } else {
                return "{\"message\":\"I'm sorry, but no pedals are currently listed in the wishlist.\"}";
            }
        });

        //post: Edit guitar instrument by id
        post("/guitars/:id/edit", "application/json", (req, res) -> {
            int guitarId = Integer.parseInt(req.params("id"));
            Guitar guitar = gson.fromJson(req.body(), Guitar.class);
            guitarDao.update(guitarId, guitar);
            res.status(201);
            return gson.toJson(guitar);
        });

        //post: Delete guitar instrument by id
        post("/guitars/:id/delete", "application/json", (req, res) -> {
            int guitarId = Integer.parseInt(req.params("id"));
            noteDao.clearAllNotesByInstrumentId(guitarId);
            additionalImageDao.clearAllAdditionalImagesByInstrumentId(guitarId);
            guitarDao.deleteById(guitarId);
            res.status(201);
            return "success";
        });

        //post: Edit amp instrument by id
        post("/amps/:id/edit", "application/json", (req, res) -> {
            int ampId = Integer.parseInt(req.params("id"));
            Amp amp = gson.fromJson(req.body(), Amp.class);
            ampDao.update(ampId, amp);
            res.status(201);
            return gson.toJson(amp);
        });

        //post: Delete amp instrument by id
        post("/amps/:id/delete", "application/json", (req, res) -> {
            int ampId = Integer.parseInt(req.params("id"));
            noteDao.clearAllNotesByInstrumentId(ampId);
            additionalImageDao.clearAllAdditionalImagesByInstrumentId(ampId);
            ampDao.deleteById(ampId);
            res.status(201);
            return "success";
        });

        //post: Edit pedal instrument by id
        post("/pedals/:id/edit", "application/json", (req, res) -> {
            int pedalId = Integer.parseInt(req.params("id"));
            Pedal pedal = gson.fromJson(req.body(), Pedal.class);
            pedalDao.update(pedalId, pedal);
            res.status(201);
            return gson.toJson(pedal);
        });

        //post: Delete pedal instrument by id
        post("/pedals/:id/delete", "application/json", (req, res) -> {
            int pedalId = Integer.parseInt(req.params("id"));
            noteDao.clearAllNotesByInstrumentId(pedalId);
            additionalImageDao.clearAllAdditionalImagesByInstrumentId(pedalId);
            pedalDao.deleteById(pedalId);
            res.status(201);
            return "success";
        });

        //post: add new note
        post("/notes/new", "application/json", (req, res) -> {
            Note note = gson.fromJson(req.body(), Note.class);
            noteDao.add(note);
            res.status(201);
            return gson.toJson(note);
        });

        //post: Delete note by id
        post("/notes/:id/delete", "application/json", (req, res) -> {
            int noteId = Integer.parseInt(req.params("id"));
            noteDao.deleteById(noteId);
            res.status(201);
            return "success";
        });

        //post: Edit note by id
        post("/notes/:id/edit", "application/json", (req, res) -> {
            int noteId = Integer.parseInt(req.params("id"));
            Note note = gson.fromJson(req.body(), Note.class);
            noteDao.update(noteId, note);
            res.status(201);
            return gson.toJson(note);
        });

        //get: show notes by instrument id
        get("/instruments/:id/notes", "application/json", (req, res) -> {
            int noteId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(noteDao.getAllByInstrumentId(noteId));
        });

        //post: add new additionalImage
        post("/additionalImages/new", "application/json", (req, res) -> {
            AdditionalImage additionalImage = gson.fromJson(req.body(), AdditionalImage.class);
            additionalImageDao.add(additionalImage);
            res.status(201);
            return gson.toJson(additionalImage);
        });

        //post: Delete additionalImage by id
        post("/additionalImages/:id/delete", "application/json", (req, res) -> {
            int additionalImageId = Integer.parseInt(req.params("id"));
            additionalImageDao.deleteById(additionalImageId);
            res.status(201);
            return "success";
        });

        //post: Edit additionalImage by id
        post("/additionalImages/:id/edit", "application/json", (req, res) -> {
            int additionalImageId = Integer.parseInt(req.params("id"));
            AdditionalImage additionalImage = gson.fromJson(req.body(), AdditionalImage.class);
            additionalImageDao.update(additionalImageId, additionalImage);
            res.status(201);
            return gson.toJson(additionalImage);
        });

        //get: show additionalImages by instrument id
        get("/instruments/:id/additionalImages", "application/json", (req, res) -> {
            int additionalImageId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(additionalImageDao.getAllByInstrumentId(additionalImageId));
        });

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request
                    .headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request
                    .headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }
            return "OK";
        });

        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
