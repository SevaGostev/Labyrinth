package me.seva.gwt.labyrinth.client.game;

public class Maze
{
	private final int width;
	private final int height;
	private Cell[][] cells;
	private Edge[][] hEdges;
	private Edge[][] vEdges;
	
	public Maze(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
	
	public Cell getCell(Position pos)
	{
		return cells[pos.getX()][pos.getY()];
	}
	
	public Edge getHEdge(Position pos)
	{
		return hEdges[pos.getX()][pos.getY()];
	}
	
	public Edge getVEdge(Position pos)
	{
		return vEdges[pos.getX()][pos.getY()];
	}
	
	public boolean isInBounds(Position pos)
	{
		return ((pos.getX() >= 0) && (pos.getY() >= 0) && (pos.getX() < width) && (pos.getY() < height));
	}
}
