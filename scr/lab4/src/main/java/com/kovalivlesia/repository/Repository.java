package com.kovalivlesia.repository;

import java.util.List;

public interface Repository<T extends Object> {

    List<T> getAll();

    T add(T object);

    void delete(T object);
}
