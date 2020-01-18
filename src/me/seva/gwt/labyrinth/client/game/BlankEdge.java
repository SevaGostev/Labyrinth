package me.seva.gwt.labyrinth.client.game;

public class BlankEdge implements Edge
{
	private final Position position;
	private final boolean vertical;

	public BlankEdge(Position position, boolean vertical)
	{
		this.position = position;
		this.vertical = vertical;
	}

	@Override
	public boolean canCross(Stepper s, boolean positive)
	{
		return true;
	}

	@Override
	public EventMessage getCrossMessage(Stepper s, Direction d)
	{
		return new EventMessage(String.format("%s steps %s.", s.getName(),
				GameController.getDirectionString(d)), !(s instanceof Player));
	}

	@Override
	public EventMessage getBumpMessage(Stepper s, Direction d)
	{
		return new EventMessage("", true);
	}

	@Override
	public void draw()
	{
		// TODO Auto-generated method stub

	}

}
