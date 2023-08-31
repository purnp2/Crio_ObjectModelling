package com.crio.jukebox.repositories;

import java.util.List;
import com.crio.jukebox.entities.Song;

public interface ISongRepository extends ICRUDRepository<Song, String>{
    
    public boolean existByIds(List<String> songIds);
    
}
