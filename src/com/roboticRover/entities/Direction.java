package com.roboticRover.entities;

import com.roboticRover.State;
import com.roboticRover.implem.state.EastState;
import com.roboticRover.implem.state.NorthState;
import com.roboticRover.implem.state.SouthState;
import com.roboticRover.implem.state.WestState;

public enum Direction {
	NORTH("N"),
	EAST("E"), 
	WEST("W"), 
	SOUTH("S");
	
    public final String direction;

    private Direction(String direction) {
        this.direction = direction;
    }
    
    public static Direction valueOfLabel(String direction) {
        for (Direction e : values()) {
            if (e.direction.equals(direction)) {
                return e;
            }
        }
        return null;
    }

    public static State getStateValue(String direction) {
        for (Direction e : values()) {
            if (e.direction.equals(direction) && "N".equals(direction)) {
                return  new NorthState();
            } else if (e.direction.equals(direction) && "E".equals(direction)) {
                return new EastState();
            } else if (e.direction.equals(direction) && "W".equals(direction)) {
            	return new WestState();
            } else if (e.direction.equals(direction) && "S".equals(direction)){
            	return new SouthState();
            }
        }
        return null;
    }
   
}
