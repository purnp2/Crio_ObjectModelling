package com.crio.jukebox.appConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.commands.ICommand;
import com.crio.jukebox.exceptions.NoSuchCommandException;

public class CommandInvoker {

    Map<String, ICommand> commandsMap = new HashMap<>();

    public void registerNewCommand(String commandName, ICommand command){
        commandsMap.put(commandName, command);
    }
    
    public void executeCommand(String commandName, List<String> tokens){
        ICommand command = commandsMap.get(commandName);
        try{
            command.execute(tokens);
        } catch(RuntimeException e){
            throw new NoSuchCommandException();
        }
        // command.execute(tokens);
    }
}
