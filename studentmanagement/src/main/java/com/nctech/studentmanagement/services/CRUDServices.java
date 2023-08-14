package com.nctech.studentmanagement.services;

import java.util.List;

public interface CRUDServices<T, K> {
    public void save(T value);
    public T fetch(K id);
    public List<T> fetchAll();
    public boolean update(T value);
    public boolean delete (K id);
}
