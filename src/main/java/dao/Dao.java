package dao;

import exceptions.NoSuchUserException;
import exceptions.UserEmailTakenException;

import java.util.List;

public interface Dao<E> {
    //CRUD operations

    void create(E obj) throws UserEmailTakenException;

    E read(int id);

    List<E> readAll();

    void update(E obj) throws UserEmailTakenException, NoSuchUserException;

    void delete(int id);
}
