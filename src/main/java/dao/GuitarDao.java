package dao;

import models.Guitar;
import models.Instrument;

import java.util.HashMap;
import java.util.List;

public interface GuitarDao {

    //CREATE
    void add(Guitar guitar);

//    //READ
    List<Guitar> getAllGuitars();
    List<Guitar> getAllGuitarsInCollection();
//    List<Guitar> getAllGuitarsByGuitarTypeId();
//
//    //UPDATE
//    void update(int id, HashMap<String, Object> updatedContent);


}
