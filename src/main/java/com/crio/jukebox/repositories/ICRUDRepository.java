package com.crio.jukebox.repositories;

import java.util.List;
import java.util.Optional;

public interface ICRUDRepository<T, ID>{
    public T save(T entity);
    public List<T> findAll();
    public Optional<T> findById(ID id);
    public boolean existsById(ID id);
    public boolean delete(T entity);
    public T deleteById(ID id);
    public Long count();

}
