package dao;

import models.AdditionalImage;

import java.util.List;

public interface AdditionalImageDao {
    // CREATE
    void add(AdditionalImage additionalImage);

    // READ
    List<AdditionalImage> getAllByInstrumentId(int id);
    AdditionalImage findById(int id);

    // UPDATE
    void update(int id, String url);

    // DELETE
    void deleteById(int id);
    void clearAllAdditionalImagesByInstrumentId( int id);
    void clearAll();
}