package com.issuetracker.repository;

import java.util.List;

public interface MyRepository<T> {

    List<T> findAll();

    void save();

    void update(T t, Long id);

    void delete(Long id);

}
