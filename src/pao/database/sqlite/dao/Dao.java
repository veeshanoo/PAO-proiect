package pao.database.sqlite.dao;

import java.util.List;

public interface Dao<T> {
    List<T> readAll();
    T read(T filter);
    void insert(T element);
    void update(T filter, T update);
    void delete(T filter);
}
