package com.roboticRover.entities;

import com.roboticRover.State;
import com.roboticRover.exception.InvalidMoveException;

public class Rover {

	private Position position;
	private State state;
	private Grid grid;

	public Rover(Position position) {
		super();
		this.position = position;
	}

	public Rover(Position position, Grid grid) {
		super();
		this.position = position;
		this.grid = grid;
	}


	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public void moveForward() {
		Position newPosition = this.state.moveForward(this.getPosition());
		if (!isValidMove(newPosition)) {
			throw new InvalidMoveException(newPosition);
		}
		this.position = newPosition;
	}

	public void spinLeft() {
		this.state.spinLeft(this); 
	}

	public void spinRight() {
		this.state.spinRight(this);
	}

	@Override
	public String toString() {
		return "Rover [position=" + position + "]";
	}

	public boolean isValidMove(Position newPosition) {
		boolean valid = true;
		if (newPosition.getX() > this.getGrid().getX() 
				|| newPosition.getY() > this.getGrid().getY()
				|| newPosition.getX() < 0
				|| newPosition.getY() <0 ) {
			valid = false;
		}
		return valid;
	}

}
