package dao;

import models.Guitar;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Collections;

public class Sql2oGuitarDao implements GuitarDao{

    private final Sql2o sql2o;
    public Sql2oGuitarDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Guitar guitar) {
        String instrumentSql = "WITH new_instrument AS (INSERT INTO instruments (manufacturer, model, country, serialNumber, imageUrl, instrumentTypeId, current, wishlist) VALUES (:manufacturer, :model, :country, :serialNumber, :imageUrl, :instrumentTypeId, :current, :wishlist) RETURNING id)) INSERT INTO guitars(guitarId) SELECT id FROM new_instrument INSERT INTO guitars (weight, bodyWood,  finish, color, binding, neckWood, neckType, neckProfile, fretboardWood, fretboardRadius, frets, fretMaterial, inlays, nutMaterial, nutWidth, scaleLength, neckPickup, middlePickup, bridgePickup, volumePots, tonePots, capacitor, tuners, tunerButtons, bridge, tailpiece, guitarSwitch, knobs, pickguard, controls, guitarCase) VALUES (:weight, :bodyWood,  :finish, :color, :binding, :neckWood, :neckType, :neckProfile, :fretboardWood, :fretboardRadius, :frets, :fretMaterial, :inlays, :nutMaterial, :nutWidth, :scaleLength, :neckPickup, :middlePickup, :bridgePickup, :volumePots, :tonePots, :capacitor, :tuners, :tunerButtons, :bridge, :tailpiece, :guitarSwitch, :knobs, :pickguard, :controls, :guitarCase) ";
//        String guitarSql = "INSERT INTO guitars (weight, bodyWood,  finish, color, binding, neckWood, neckType, neckProfile, fretboardWood, fretboardRadius, frets, fretMaterial, inlays, nutMaterial, nutWidth, scaleLength, neckPickup, middlePickup, bridgePickup, volumePots, tonePots, capacitor, tuners, tunerButtons, bridge, tailpiece, guitarSwitch, knobs, pickguard, controls, guitarCase) VALUES (:weight, :bodyWood,  :finish, :color, :binding, :neckWood, :neckType, :neckProfile, :fretboardWood, :fretboardRadius, :frets, :fretMaterial, :inlays, :nutMaterial, :nutWidth, :scaleLength, :neckPickup, :middlePickup, :bridgePickup, :volumePots, :tonePots, :capacitor, :tuners, :tunerButtons, :bridge, :tailpiece, :guitarSwitch, :knobs, :pickguard, :controls, :guitarCase)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(instrumentSql, true)
                    .bind(guitar)
                    .executeUpdate()
                    .getKey();
            guitar.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Guitar> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM instruments JOIN guitars ON instrument.id = guitars.guitarId")
//                    .addParameter("collectionBoolean", "Ebony")
                    .executeAndFetch(Guitar.class);
//            allGuitarsWithoutNull.removeAll(Collections.singleton(null));
        }
    }
}
