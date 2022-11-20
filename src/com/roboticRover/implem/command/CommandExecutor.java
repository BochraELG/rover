package com.roboticRover.implem.command;

import com.roboticRover.Command;

public class CommandExecutor {
	
    public void executeOperation(Command command) {
		command.execute();
		
	}
}

