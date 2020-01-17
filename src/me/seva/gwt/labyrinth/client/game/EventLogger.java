package me.seva.gwt.labyrinth.client.game;

import java.util.ArrayList;
import java.util.List;

public class EventLogger
{
	private List<LoggableEvent> events;
	
	/**
	 points at the list index after the current state. Normally this is the end of the list,
	 except after undoing some actions. Events after the pointer are discarded if another action is taken.
	 * 
	 */
	private int pointer;
	
	public EventLogger()
	{
		events = new ArrayList<LoggableEvent>();
	}
	
	public void log(LoggableEvent event)
	{
		events.subList(pointer, events.size()).clear();
		events.add(event);
	}
	
	public void undo()
	{
		if(pointer > 0)
		{
			pointer --;
			events.get(pointer).doBackward();
		}
	}
	
	public void redo()
	{
		if(pointer < events.size())
		{
			events.get(pointer).doForward();
			pointer ++;
		}
	}
}
