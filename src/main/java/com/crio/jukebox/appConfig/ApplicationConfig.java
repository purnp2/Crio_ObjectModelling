package com.crio.jukebox.appConfig;

import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.services.UserService;
import com.crio.jukebox.commands.CreatePlaylistCommand;
import com.crio.jukebox.commands.DeletePlaylistCommand;
import com.crio.jukebox.commands.LoadDataCommand;
import com.crio.jukebox.commands.ModifyPlaylistCommand;
import com.crio.jukebox.commands.PlayPlaylistCommand;
import com.crio.jukebox.commands.PlaySongCommand;
import com.crio.jukebox.repositories.ArtistRepository;
import com.crio.jukebox.repositories.IArtistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.PlaylistService;
import com.crio.jukebox.services.SongService;

public class ApplicationConfig {

    // Repositories
    ISongRepository songRepository = new SongRepository();
    IUserRepository userRepository = new UserRepository();
    IArtistRepository artistRepository = new ArtistRepository();
    
    // Services
    ISongService songService = new SongService(songRepository);
    IPlaylistService playlistService = new PlaylistService(userRepository, songRepository);
    IUserService userService = new UserService(songRepository, userRepository, playlistService);

    // Commands
    LoadDataCommand loadDataCommand = new LoadDataCommand(songService);
    CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    CreatePlaylistCommand CreatePlaylistCommand = new CreatePlaylistCommand(userService);
    DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(userService);
    PlayPlaylistCommand playPlaylistCommand = new PlayPlaylistCommand(userService);
    ModifyPlaylistCommand modifyPlaylistCommand = new ModifyPlaylistCommand(userService);
    PlaySongCommand playSongCommand = new PlaySongCommand(userService);


    CommandInvoker commandInvoker = new CommandInvoker();
    // commandInvoker.registerNewCommand("LOAD-DATA", loadDataCommand);
    // FIXME: Why this can't be used here? Why it must be inside a function?

    public CommandInvoker getCommandInvoker(){
        commandInvoker.registerNewCommand("LOAD-DATA", loadDataCommand);
        commandInvoker.registerNewCommand("CREATE-USER", createUserCommand);
        commandInvoker.registerNewCommand("CREATE-PLAYLIST", CreatePlaylistCommand);
        commandInvoker.registerNewCommand("DELETE-PLAYLIST", deletePlaylistCommand);
        commandInvoker.registerNewCommand("PLAY-PLAYLIST", playPlaylistCommand);
        commandInvoker.registerNewCommand("MODIFY-PLAYLIST", modifyPlaylistCommand);
        commandInvoker.registerNewCommand("PLAY-SONG", playSongCommand);

        return commandInvoker;
    }


}
