package com.roboticRover.exception;

import com.roboticRover.entities.Position;

public class InvalidMoveException extends RuntimeException{

	private static final long serialVersionUID = 1705887657181239450L;

	public InvalidMoveException(Position position) {
		super(String.format("Position %d - %d is out of range", position.getX(), position.getY()));
		
	} 

}
