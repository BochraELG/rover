package com.roboticRover.implem.command;

import com.roboticRover.Command;
import com.roboticRover.entities.Rover;

public class MoveForwardCommand implements Command{

    private Rover rover;

	public MoveForwardCommand(Rover rover) {
		super();
		this.rover = rover;
	}

	@Override
	public void execute() {
        this.rover.moveForward();	
	}


}
