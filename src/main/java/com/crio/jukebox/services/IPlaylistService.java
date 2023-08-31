package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;

public interface IPlaylistService {
    public Playlist createPlaylist(String userId, String playlistName, List<String> songIds) throws IllegalArgumentException;
    // Playlist ID - 1 ...OR... Some Requested Songs Not Available. Please try again.

    public boolean deletePlaylist(String userId, String playlistId);
    // Delete Successful OR Playlist Not Found
    
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

}
