package com.roboticRover.implem.state;

import com.roboticRover.State;
import com.roboticRover.entities.Direction;
import com.roboticRover.entities.Position;
import com.roboticRover.entities.Rover;

public class NorthState extends State{

	@Override
	public Position moveForward(Position position) {
		Position newPosition = new Position(position.getX(), position.getY(), position.getDirection());
		newPosition.setY(position.getY()+1);
		return newPosition;
	}

	@Override
	public void spinLeft(Rover rover) {
		rover.setState(new WestState());
		Position position = rover.getPosition();
		position.setDirection(Direction.WEST);
	}

	@Override
	public void spinRight(Rover rover) {
		rover.setState(new EastState());
		Position position = rover.getPosition();
		position.setDirection(Direction.EAST);
		
	}

}
