package com.crio.jukebox.commands;

import java.util.List;
import com.crio.codingame.exceptions.NoSuchCommandException;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.services.IUserService;

public class PlaySongCommand implements ICommand{

    IUserService userService;
    
    public PlaySongCommand(IUserService userService) {
        this.userService = userService;
    }
    
    public void execute(List<String> tokens) throws NoSuchCommandException{
        // TODO: define command task
        // PLAY-SONG 1 5
        // PLAY-SONG 1 NEXT
        // PLAY-SONG 1 NEXT
        // PLAY-SONG 1 BACK
        // PLAY-SONG 1 BACK
        // PLAY-SONG 1 19

        // Current Song Playing
        // Song - Save Your Tears(Remix)
        // Album -  After Hours 
        // Artists -  TheWeeknd,Ariana Grande
        // Or
        // Song Not Found in the current active playlist.

        String userId = tokens.get(1);
        String arg3 = tokens.get(2);
        Song song = null;
        try {
            if (arg3.equals("NEXT")) {
                song = userService.playNextSong(userId);
            } else if (arg3.equals("BACK")) {
                song = userService.playBackSong(userId);
            } else if (Integer.valueOf(arg3) > 0) {
                song = userService.playSongById(userId, arg3);
            } else
                throw new NoSuchCommandException();

            System.out.println(song);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
