package com.bridgelabz.repository;

import com.bridgelabz.entity.QuantityMeasurementEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private static QuantityMeasurementCacheRepository instance;
    private final List<QuantityMeasurementEntity> cache = new ArrayList<>();
    private static final String FILE_PATH = "quantity_data.ser";

    private QuantityMeasurementCacheRepository() {
        loadFromDisk();
    }

    public static QuantityMeasurementCacheRepository getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementCacheRepository();
        }
        return instance;
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        cache.add(entity);
        saveToDisk(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {
        return new ArrayList<>(cache);
    }

    private void saveToDisk(QuantityMeasurementEntity entity) {
        try (ObjectOutputStream oos = new AppendableObjectOutputStream(
                new FileOutputStream(FILE_PATH, true))) {
            oos.writeObject(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromDisk() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_PATH))) {

            while (true) {
                QuantityMeasurementEntity entity =
                        (QuantityMeasurementEntity) ois.readObject();
                cache.add(entity);
            }

        } catch (EOFException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}