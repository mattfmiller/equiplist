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
    void update(int id, Guitar guitar);

    //DELETE
    void delteteById(int id);
}
