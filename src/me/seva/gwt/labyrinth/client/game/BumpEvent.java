package me.seva.gwt.labyrinth.client.game;

public class BumpEvent implements LoggableEvent
{
	private final Stepper s;
	private final EventMessage message;

	public BumpEvent(Stepper s, EventMessage message)
	{
		this.s = s;
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
