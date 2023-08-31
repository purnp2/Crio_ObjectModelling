package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.User;

public class UserRepository implements IUserRepository{

    private Map<String, User> userRepoMap = new HashMap<>();
    private Integer autoIncrement = 0;

    public User save(User entity){
        if (entity.getId() == null){
            String id = String.valueOf(++autoIncrement);
            entity.setId(id);
            userRepoMap.put(id, entity);
            return entity;
        } else {
            userRepoMap.put(entity.getId(), entity); 
            return entity;
        }
    }
    public List<User> findAll(){
        return userRepoMap.values().stream().collect(Collectors.toList());
    }
    public Optional<User> findById(String songId){
        return Optional.ofNullable(userRepoMap.get(songId));
    }
    public boolean existsById(String songId){
        return userRepoMap.containsKey(songId);
    }
    public boolean delete(User entity){
        return userRepoMap.remove(entity.getId(), entity);
    }
    public User deleteById(String songId){
        return userRepoMap.remove(songId);
    }
    public Long count(){
        return Long.valueOf(userRepoMap.size());
    }
    
}
