package me.seva.gwt.labyrinth.client.game;

public class Key implements InventoryItem
{
	private final DoorColor color;

	public Key(DoorColor color)
	{
		this.color = color;
	}
	
	public DoorColor getColor()
	{
		return color;
	}
	
	@Override
	public String getName()
	{
		return String.format("%s key", color.getName());
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(!(o instanceof Key))
			return false;
		else
			return (color.equals(((Key) o).getColor()));
	}

}
