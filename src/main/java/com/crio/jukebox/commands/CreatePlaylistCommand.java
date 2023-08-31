package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.entities.Playlist;

public class CreatePlaylistCommand implements ICommand{
    
    IUserService userService;

    public CreatePlaylistCommand(IUserService userService) {
        this.userService = userService;
    }

    public void execute(List<String> tokens){
        // DONE: define command task
        // CREATE-PLAYLIST 1 MY_PLAYLIST_1 1 4 5 6
        // CREATE-PLAYLIST 1 MY_PLAYLIST_2 1 //TODO Handle case when no songId is passed.
        List<String> songIds = new ArrayList<>();
        for (int i = 3; i < tokens.size(); i++){
            songIds.add(tokens.get(i));
        }

        Playlist newPlaylist = null;
        try{
            newPlaylist = userService.createPlaylist(tokens.get(1), tokens.get(2), songIds);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(newPlaylist.toString());
    }
    
}
