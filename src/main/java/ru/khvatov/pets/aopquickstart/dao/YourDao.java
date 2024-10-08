package ru.khvatov.pets.aopquickstart.dao;

import java.util.List;

public class YourDao {
    private static final List<Object> YOUR_OBJECTS = List.of(
        new Object(),
        new Object(),
        new Object()
    );


    public List<Object> findAll() {
        return YOUR_OBJECTS;
    }
}