package me.seva.gwt.labyrinth.client.game;

public class TakeItemEvent implements LoggableEvent
{
	private final Player target;
	private final InventoryItem item;
	
	private final EventMessage message;

	public TakeItemEvent(Player target, InventoryItem item, EventMessage message)
	{
		this.target = target;
		this.item = item;
		this.message = message;
		
		doForward();
	}
	
	@Override
	public void doForward()
	{
		target.takeItem(item);
	}

	@Override
	public void doBackward()
	{
		target.removeItem(item);
	}

	@Override
	public EventMessage getMessage()
	{
		return message;
	}

}
