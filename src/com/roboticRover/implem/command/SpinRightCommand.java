package com.roboticRover.implem.command;

import com.roboticRover.Command;
import com.roboticRover.entities.Rover;

public class SpinRightCommand implements Command{

    private Rover rover;

	public SpinRightCommand(Rover rover) {
		super();
		this.rover = rover;
	}

	@Override
	public void execute() {
		rover.spinRight();		
	}
}
