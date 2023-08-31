package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.services.IUserService;


public class DeletePlaylistCommand implements ICommand{

    IUserService userService;

    public DeletePlaylistCommand(IUserService userService){
        this.userService = userService;
    }
    
    public void execute(List<String> tokens){
        // TODO: define command task
        // Eg: DELETE-PLAYLIST 1 2
        // Delete Successful OR Playlist Not Found
        if (tokens.size() < 3 || tokens.size() > 3) System.out.println("Number of tokens is incorrect!");
        boolean deleteSuccessful = userService.deletePlaylist(tokens.get(1), tokens.get(2));
        if (deleteSuccessful) System.out.println("Delete Successful");
        else System.out.println("Playlist Not Found");
    }
    
}
