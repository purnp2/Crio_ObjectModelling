package com.crio.jukebox.entities;

import java.util.List;

// public class Artist extends User implements IArtisitic{

//     List<Song> album;

//     public Artist (String artistName){
//         super(artistName);
//     }

//     public List<Song> getAlbum() {
//         return album;
//     }

//     public void setAlbum(List<Song> album) {
//         this.album = album;
//     }

//     @Override
//     public String toString() {
//         return name;
//     }

// }

public class Artist extends BaseEntity{

    List<Song> album;
    
    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    
}
