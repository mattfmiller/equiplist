package dao;

import models.Guitar;

import java.util.HashMap;
import java.util.List;

public interface GuitarDao {

    //CREATE
    void add(Guitar guitar);

    //READ
    List<Guitar> getAll();
    List<Guitar> getAllGuitarsByGuitarTypeId();

    //UPDATE
    void update(int id, HashMap<String, Object> updatedContent);

    //DELETE
    void deleteById(int id);



}
