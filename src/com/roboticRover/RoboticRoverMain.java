package com.roboticRover; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.roboticRover.entities.Grid;
import com.roboticRover.entities.Rover;
import com.roboticRover.exception.InvalidMoveException;
import com.roboticRover.implem.InputLoader;
import com.roboticRover.implem.command.CommandExecutor;

public class RoboticRoverMain {

	public static void main(String[] args) throws IOException {
		if (args[0] == null || args[0].isBlank()) {
			throw new IllegalArgumentException("Invalid input file");
		} 
		FileReader fileReader = new FileReader(args[0]);
		List<Rover> rovers = readFromfile(fileReader);
		rovers.forEach(rover -> {
			System.out.println(rover.getPosition().getX() + " " + rover.getPosition().getY()+ " " + rover.getPosition().getDirection().direction);
		});
	}

	private static List<Rover> readFromfile(FileReader fileReader) throws IOException {
		List<Rover> rovers = new ArrayList<>();
		try (var lineReader = new BufferedReader(fileReader)) {
			Grid upperGrid = InputLoader.loadUpperRightGrid(lineReader.readLine());
			var lineNumber = 0;
			String row;
			Rover rover = null;
			while ((row = lineReader.readLine())!= null) {
				lineNumber++;
				int rowType = lineNumber % 2;
				try {
					if (rowType != 0) {
						rover = null;
						rover = InputLoader.loadRoverCoord(row, upperGrid);
					} else {
						if (rover == null) {
							continue;
						}
						List<Command> commands = InputLoader.loadCommandsList(row, rover);
						for (Command command : commands) {
							CommandExecutor commandExecutor = new CommandExecutor();
							commandExecutor.executeOperation(command);
						}
						rovers.add(rover);
					}	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}  
		}
		return rovers;
	}

}
