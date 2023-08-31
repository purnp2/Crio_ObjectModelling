package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.User;

public interface IUserService {
    // #2
    public User createUser(String name); // 1 Kiran

    // #3
    public Playlist createPlaylist(String userId, String playlistName, List<String> songIds);
    // Playlist ID - 1 ...OR... Some Requested Songs Not Available. Please try again.
    
    // #4
    public boolean deletePlaylist(String userId, String playlistId); // Delete Successful OR Playlist Not Found

    // #5
    public Playlist addSongToPlaylist(String userId, String playlistId, List<String> songIds);
    // Playlist ID - 1
    // Playlist Name - MY_PLAYLIST_1
    // Song IDs - 1 2 3 4 5 6 7
    // Or
    // Some Requested Songs Not Available. Please try again.

    public Playlist deleteSongFromPlaylist(String userId, String playlistId, List<String> songIds);
    // Playlist ID - 1
    // Playlist Name - MY_PLAYLIST_1
    // Song IDs - 1 2 5 6 7
    // Or
    // Some Requested Songs for Deletion are not present in the playlist. Please try again.

    // #6
    public Song playAPlaylist(String userId, String playlistId);
    // Current Song Playing
    // Song - Save Your Tears(Remix)
    // Album -  After Hours 
    // Artists -  TheWeeknd,Ariana Grande  
    // Or
    // Playlist is empty.

    public Song playBackSong(String userId);
    public Song playNextSong(String userId);
    public Song playSongById(String userId, String songId);
    // Current Song Playing
    // Song  -  { Song Name  } 
    // Album - { Album Name  }  
    // Artists - { List of Artists 
    // Or
    // Error Message if above Song ID is not part of a current active playlist.

    
}
