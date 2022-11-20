package com.roboticRover.implem.command;

import com.roboticRover.Command;
import com.roboticRover.entities.Rover;

public class SpinLeftCommand implements Command{

    private Rover rover;

	public SpinLeftCommand(Rover rover) {
		super();
		this.rover = rover;
	}

	@Override
	public void execute() {
		this.rover.spinLeft();		
	}

}
