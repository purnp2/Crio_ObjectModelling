package com.crio.jukebox.commands;

import java.util.List;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.services.IUserService;

public class ModifyPlaylistCommand implements ICommand{
    IUserService userService;

    public ModifyPlaylistCommand (IUserService userService){
        this.userService = userService;
    }
    
    public void execute(List<String> tokens) {

        // TODO: define command task
        // MODIFY-PLAYLIST ADD-SONG 1 1 7
        // MODIFY-PLAYLIST DELETE-SONG 1 1 7

        // Playlist ID - 1
        // Playlist Name - MY_PLAYLIST_1
        // Song IDs - 1 2 3 4 5 6 7
        // Or
        // Some Requested Songs Not Available. Please try again.

        String userId = tokens.get(2);
        String playlistId = tokens.get(3);
        List<String> songIds = tokens.stream().skip(4).collect(Collectors.toList());

        try {
            // Can use strategy pattern here for selecting either of the 2 methods.
            if (tokens.get(1).equals("ADD-SONG")) {
                Playlist playlist = userService.addSongToPlaylist(userId, playlistId, songIds);
                System.out.println(playlist.toStringInDetail());
            } else if (tokens.get(1).equals("DELETE-SONG")) {
                Playlist playlist = userService.deleteSongFromPlaylist(userId, playlistId, songIds);
                System.out.println(playlist.toStringInDetail());
            } else
                throw new IllegalArgumentException("Wrong token passed with MODIFY-PLAYLIST!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
