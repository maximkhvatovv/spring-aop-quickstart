package ru.khvatov.pets.aopquickstart.dao;

import java.util.List;

public class MyDao {
    private static final List<Object> MY_OBJECTS = List.of(
        new Object(),
        new Object(),
        new Object()
    );


    public List<Object> findAll() {
        return MY_OBJECTS;
    }
}
