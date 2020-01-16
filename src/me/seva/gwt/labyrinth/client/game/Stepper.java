package me.seva.gwt.labyrinth.client.game;

public class Stepper implements MazeObject
{
	private final GameController controller;
	private final Maze maze;
	
	private Position position;
	
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
