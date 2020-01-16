package me.seva.gwt.labyrinth.client.game;

public interface Edge
{
	public boolean canCross(Stepper s, boolean positive);
	
	public EventMessage getCrossMessage(Stepper s, Direction d);
	
	public EventMessage getBumpMessage(Stepper s, Direction d);
	
	public void draw();
}
