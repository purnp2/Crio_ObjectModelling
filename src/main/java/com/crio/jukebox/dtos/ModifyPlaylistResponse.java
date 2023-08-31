package com.crio.jukebox.dtos;

import java.util.stream.Collectors;
import com.crio.jukebox.entities.Playlist;

@Deprecated
public class ModifyPlaylistResponse {

    Playlist playlist;

    public ModifyPlaylistResponse(Playlist playlist){
        this.playlist = playlist;
    }

    // "Playlist ID - 1\n"+
    // "Playlist Name - MY_PLAYLIST_1\n"+
    // "Song IDs - 1 4 5 6 7\n"+

    @Override
    public String toString(){
        String songIds = playlist.getSongsIds().stream().collect(Collectors.joining(" "));
        return playlist.toString() + "\nPlaylist Name - " + playlist.getName() + "\nSong IDs - " + songIds;
    }
}
