package com.roboticRover.entities;

import com.roboticRover.Command;
import com.roboticRover.implem.command.MoveForwardCommand;
import com.roboticRover.implem.command.SpinLeftCommand;
import com.roboticRover.implem.command.SpinRightCommand;

public enum CommandType {
	MOVE('M'),
	LEFT('L'), 
	RIGHT('R');
	
    public final char command;

	private CommandType(char command) {
		this.command = command;
	}

	public char getCommand() {
		return command;
	}
	
    public static Command valueOfLabel(char command, Rover rover) {
        for (CommandType e : values()) {
            if (e.command == command && command == 'M') {
                return new MoveForwardCommand(rover);
            } else if (e.command == command && command == 'L') {
                return new SpinLeftCommand(rover);
            } else if (e.command == command && command == 'R'){
                return new SpinRightCommand(rover);
            }
        }
        return null;
    }
}
