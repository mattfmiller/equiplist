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
    List<Guitar> search(String query);

    //UPDATE
    void update(int id, Guitar guitar);

    //DELETE
    void deleteById(int id);
    void clearAll();
}
