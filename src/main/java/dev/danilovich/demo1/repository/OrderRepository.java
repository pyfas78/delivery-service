package dev.danilovich.demo1.repository;

import dev.danilovich.demo1.model.Model;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private final Map<Long, Model> database = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    public Model save(String dishName, double price, boolean paid) {
        Long id = idGenerator.getAndIncrement();
        Model model = new Model(id, dishName, price, paid);
        database.put(id, model);
        return model;
    }

    public Optional<Model> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Model> findAll() {
        return new ArrayList<>(database.values());
    }
}
