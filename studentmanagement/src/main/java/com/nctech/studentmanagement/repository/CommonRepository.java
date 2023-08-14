package com.nctech.studentmanagement.repository;

import java.util.List;

public interface CommonRepository<T> {
    public void save(T type);
    public List<T> get();
}
