/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import java.util.List;

/**
 *
 * @author cassio.machado
 * @param <T>
 * @param <ID>
 */
public interface Dao<T, ID> {

    void insert(T entity);

    void delete(T entity);

    T find(ID id);

    List<T> findAll();

    List<T> findByName(String name);

    List<T> findByEntity(T entity);
}
