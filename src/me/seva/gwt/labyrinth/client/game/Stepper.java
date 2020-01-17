package me.seva.gwt.labyrinth.client.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stepper implements MazeObject
{
	private final GameController controller;
	private final Maze maze;
	
	private Position position;
	private final List<Position> trace;
	
	private final String name;
	private final String color;
	
	
	
	public Stepper(GameController controller, Maze maze, Position position, String name, String color)
	{
		this.controller = controller;
		this.maze = maze;
		this.position = position;
		this.trace = new ArrayList<Position>();
		this.name = name;
		this.color = color;
	}

	public boolean step(Direction d)
	{
		Edge e = null;
		Position destination = null;
		boolean positiveCross = false;
		
		switch(d)
		{
			case EAST:
				if(getX() < maze.getWidth())
				{
					e = maze.getVEdge(new Position(getX()+1, getY()));
					destination = new Position(getX()+1, getY());
					positiveCross = true;
				}
				break;
			case SOUTH:
				if(getY() < maze.getHeight())
				{
					e = maze.getHEdge(new Position(getX(), getY()+1));
					destination = new Position(getX(), getY()+1);
					positiveCross = true;
				}
				break;
			case WEST:
				if(getX() < maze.getWidth())
				{
					e = maze.getVEdge(new Position(getX(), getY()));
					destination = new Position(getX()-1, getY());
					positiveCross = false;
				}
				break;
			case NORTH:
				if(getX() < maze.getWidth())
				{
					e = maze.getHEdge(new Position(getX(), getY()));
					destination = new Position(getX(), getY()-1);
					positiveCross = false;
				}
				break;
			default:
				e = null;
				destination = null;
				positiveCross = false;
		}
		
		boolean success;
		
		if(destination != null)
		{
			if(e.canCross(this, positiveCross))
			{
				controller.getLogger().log(new RepositionEvent(this, destination, e.getCrossMessage(this, d)));
				success = true;
				
				if(maze.isInBounds(position))
					maze.getCell(position).stepOn(this);
			}
			else
			{
				controller.getLogger().log(new BumpEvent(this, e.getBumpMessage(this, d)));
				success = false;
			}
		}
		else
		{
			success = false;
		}
		
		controller.getLogger().log(new TurnAdvanceEvent(controller));
		
		return success;
	}
	
	public GameController getController()
	{
		return controller;
	}
	
	public Maze getMaze()
	{
		return maze;
	}
	
	public Position getPosition()
	{
		return position;
	}
	
	public List<Position> getTraceView()
	{
		return Collections.unmodifiableList(trace);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public boolean addTrace(Position p)
	{
		return trace.add(p);
	}
	
	public Position removeLastTrace()
	{
		return trace.remove(trace.size() - 1);
	}
	
	public int getX()
	{
		return position.getX();
	}
	
	public int getY()
	{
		return position.getY();
	}
	
	public void setPosition(Position pos)
	{
		position = pos;
	}
}
