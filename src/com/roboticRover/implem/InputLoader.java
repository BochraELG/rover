package com.roboticRover.implem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.roboticRover.Command;
import com.roboticRover.State;
import com.roboticRover.entities.CommandType;
import com.roboticRover.entities.Direction;
import com.roboticRover.entities.Grid;
import com.roboticRover.entities.Position;
import com.roboticRover.entities.Rover;

public class InputLoader {

	public static Grid loadUpperRightGrid(String input) {
		String[] arrOfStr = input.split(" ");
		Grid grid = new Grid (Integer.parseInt(arrOfStr[0]), 
				Integer.parseInt(arrOfStr[1]));
		return grid;		
	}

	public static Rover loadRoverCoord(String input, Grid grid) {
		String[] arrOfStr = input.split(" ");
		Rover rover = new Rover (new Position (Integer.parseInt(arrOfStr[0]), 
				                                Integer.parseInt(arrOfStr[1]),
				                                 Direction.valueOfLabel(arrOfStr[2])), grid);
		State state = Direction.getStateValue(arrOfStr[2]);
		rover.setState(state);
		return rover;		
	}
	
	public static List<Command> loadCommandsList(String input, Rover rover) {
		char[] commands = input.toCharArray();
		List<Command> commandList = new ArrayList<>();
		
		for (char commandStr : commands) {
			Command command = CommandType.valueOfLabel(commandStr, rover);
			commandList.add(command);
		}
		return commandList;
					
	}
	
}
