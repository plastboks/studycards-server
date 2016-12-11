package net.plastboks.studycards.service;

import javassist.NotFoundException;

import java.util.List;

/**
 * Created by alex on 1/9/16.
 */
public interface IService<T>
{
    T save(T t);
    T delete(int id) throws NotFoundException;
    List<T> findAll();
    T findOne(int id);
}
