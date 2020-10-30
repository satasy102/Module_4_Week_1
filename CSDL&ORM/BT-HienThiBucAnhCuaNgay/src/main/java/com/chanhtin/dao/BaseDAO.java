package com.chanhtin.dao;

import com.chanhtin.model.Comment;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();

    T findByID(Long id);

    Comment add(T object);

    Comment save(Comment object);

    void remote(Long id);
}
