package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.IUserService;

public class PlayPlaylistCommand implements ICommand{

    IUserService userService;

    public PlayPlaylistCommand (IUserService userService){
        this.userService = userService;
    }
    
    public void execute(List<String> tokens){
        // TODO: define command task PLAY-PLAYLIST 1 1

        // Current Song Playing
        // Song - Save Your Tears(Remix)
        // Album -  After Hours 
        // Artists -  TheWeeknd,Ariana Grande  
        // Or
        // Playlist is empty.
        if (tokens.size() < 3 || tokens.size() > 3) throw new IllegalArgumentException("ddd");
        try{
            Song song = userService.playAPlaylist(tokens.get(1), tokens.get(2));
            System.out.println(song);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }

    
    
}