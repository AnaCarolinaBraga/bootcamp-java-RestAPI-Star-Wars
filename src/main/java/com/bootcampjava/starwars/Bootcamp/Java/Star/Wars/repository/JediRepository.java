package com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.repository;

import com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.model.Jedi;

import java.util.List;
import java.util.Optional;

public interface JediRepository {

    //Optional é pq o retorno dele é opcional, pode retornar uma lista, um objeto...
    Optional<Jedi> findById(Integer id);

    //O retorno aqui é uma lista
    List<Jedi> findAll();

    boolean update(Jedi jedi);

    Jedi save(Jedi jedi);

    boolean delete(Integer id);

}

