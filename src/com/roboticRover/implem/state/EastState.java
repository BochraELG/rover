package com.roboticRover.implem.state;

import com.roboticRover.State;
import com.roboticRover.entities.Direction;
import com.roboticRover.entities.Position;
import com.roboticRover.entities.Rover;

public class EastState extends State{

	@Override
	public Position moveForward(Position position) {
		Position newPosition = new Position(position.getX(), position.getY(), position.getDirection());
		newPosition.setX(position.getX()+1);
		return newPosition;
	}

	@Override
	public void spinLeft(Rover rover) {
		rover.setState(new NorthState());
		Position position = rover.getPosition();
		position.setDirection(Direction.NORTH);
	}

	@Override
	public void spinRight(Rover rover) {
		rover.setState(new SouthState());
		Position position = rover.getPosition();
		position.setDirection(Direction.SOUTH);
	}

}
