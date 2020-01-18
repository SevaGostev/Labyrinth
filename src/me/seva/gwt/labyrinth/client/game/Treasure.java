package me.seva.gwt.labyrinth.client.game;

public class Treasure implements InventoryItem
{

	@Override
	public String getName()
	{
		return "treasure";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Treasure);
	}

}
