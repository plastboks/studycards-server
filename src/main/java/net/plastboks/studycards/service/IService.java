package net.plastboks.studycards.service;

import javassist.NotFoundException;

import java.util.List;

/**
 * Created by alex on 1/9/16.
 */
public interface IService<T>
{
    public T create(T t);
    public T delete(int id) throws NotFoundException;
    public List<T> findAll();
    public T update(T t) throws NotFoundException;
    public T findById(int id);
}
