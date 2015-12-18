package net.plastboks.studycards.model;

/**
 * Created by alex on 12/18/15.
 */
public interface DAO<T>
{
    public void save(T t);
    public T getById(int id);
    public T getById(int id, boolean joins);
}
