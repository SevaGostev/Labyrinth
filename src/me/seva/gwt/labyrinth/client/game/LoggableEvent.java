package me.seva.gwt.labyrinth.client.game;

public interface LoggableEvent
{
	public void doForward();
	
	public void doBackward();
	
	public EventMessage getMessage();
}
