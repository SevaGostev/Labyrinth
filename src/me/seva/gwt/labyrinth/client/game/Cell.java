package me.seva.gwt.labyrinth.client.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class Cell
{
	private List<MazeObject> mazeObjects = new ArrayList<MazeObject>();
	
	public List<MazeObject> getListView()
	{
		return Collections.unmodifiableList(mazeObjects);
	}
	
	public boolean contains(MazeObject o)
	{
		return mazeObjects.contains(o);
	}
	
	public boolean remove(MazeObject o)
	{
		return mazeObjects.remove(o);
	}
	
	public boolean add(MazeObject o)
	{
		return mazeObjects.add(o);
	}
	
	abstract public void stepOn(Stepper s);
	
	abstract public void draw();
}
