package me.seva.gwt.labyrinth.client.game;

public class GenericEvent implements LoggableEvent
{
	private final EventMessage message;
	
	public GenericEvent(EventMessage message)
	{
		this.message = message;
	}

	@Override
	public void doForward()
	{}

	@Override
	public void doBackward()
	{}

	@Override
	public EventMessage getMessage()
	{
		return message;
	}

}
