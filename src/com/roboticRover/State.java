package com.roboticRover;

import com.roboticRover.entities.Position;
import com.roboticRover.entities.Rover;

public abstract class State {
	  public abstract Position moveForward(Position position);
	  public abstract void spinLeft(Rover rover);
	  public abstract void spinRight(Rover rover);
}
