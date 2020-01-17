package me.seva.gwt.labyrinth.client.game;

import java.util.Collections;
import java.util.List;

public class Player extends Stepper
{	
	private boolean healthy;
	private final List<InventoryItem> items;
	
	public boolean hasItem(InventoryItem i)
	{
		return items.contains(i);
	}
	
	public List<InventoryItem> getInventoryView()
	{
		return Collections.unmodifiableList(items);
	}
	
	public TakeItemResult canTakeItem(InventoryItem i)
	{
		if(!healthy)
			return TakeItemResult.INJURED;
		else
		{
			if(hasItem(i))
				return TakeItemResult.ALREADY_CARRYING;
			else
				return TakeItemResult.SUCCESS;
		}
	}
	
	public boolean takeItem(InventoryItem i)
	{
		return items.add(i);
	}
	
	public boolean removeItem(InventoryItem i)
	{
		return items.remove(i);
	}
}
