package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Artist;

public class ArtistRepository implements IArtistRepository{
    private Map<String, Artist> artistRepoMap = new HashMap<>();
    private Integer autoIncrement = 0;

    public Artist save(Artist entity){
        if (entity.getId() == null){
            String id = String.valueOf(autoIncrement++);
            entity.setId(id);
            artistRepoMap.put(id, entity);
            return entity;
        } else {
            artistRepoMap.put(entity.getId(), entity); 
            return entity;
        }
    }
    public List<Artist> findAll(){
        return artistRepoMap.values().stream().collect(Collectors.toList());
    }
    public Optional<Artist> findById(String songId){
        return Optional.ofNullable(artistRepoMap.get(songId));
    }
    public boolean existsById(String songId){
        return artistRepoMap.containsKey(songId);
    }
    public boolean delete(Artist entity){
        return artistRepoMap.remove(entity.getId(), entity);
    }
    public Artist deleteById(String songId){
        return artistRepoMap.remove(songId);
    }
    public Long count(){
        return Long.valueOf(artistRepoMap.size());
    }
}
