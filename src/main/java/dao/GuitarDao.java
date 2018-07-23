package dao;

import models.Guitar;

import java.util.HashMap;
import java.util.List;

public interface GuitarDao {

    //CREATE
    void add(Guitar guitar);

//    //READ
    List<Guitar> getAllGuitars();
    List<Guitar> getAllGuitarsInCollection();
    List<Guitar> getAllGuitarsInWishlist();
//    List<Guitar> getAllGuitarsByGuitarTypeId(int guitarTypeId);
//    List<Guitar> search(String query);

    //UPDATE
    void update(int id, Guitar guitar
//                String manufacturer, String model, String country, String serialNumber, String description, int year, Double weight, String imageUrl, Boolean current, Boolean wishlist, double paid, double sold, String bodyWood, String finish, String color, String binding, String neckWood, String neckType, String neckProfile, String fretboardWood, Double fretboardRadius, int frets, String fretMaterial, String inlays, String nutMaterial, double nutWidth, double scaleLength, String neckPickup, String middlePickup, String bridgePickup, String volumePots, String tonePots, String capacitor, String tuners, String tunerButtons, String bridge, String tailpiece, String guitarSwitch, String knobs, String pickguard, String controls, String guitarCase
    );

    //DELETE
//    void delteteById(int id);
}
