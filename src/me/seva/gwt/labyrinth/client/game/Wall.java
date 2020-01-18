package me.seva.gwt.labyrinth.client.game;

public class Wall implements Edge
{
	private final Position position;
	private final boolean vertical;

	public Wall(Position position, boolean vertical)
	{
		this.position = position;
		this.vertical = vertical;
	}

	@Override
	public boolean canCross(Stepper s, boolean positive)
	{
		return false;
	}

	@Override
	public EventMessage getCrossMessage(Stepper s, Direction d)
	{
		return new EventMessage("", true);
	}

	@Override
	public EventMessage getBumpMessage(Stepper s, Direction d)
	{
		return new EventMessage(String.format("%s attempts to step %s but there's a wall there.", s.getName(),
				GameController.getDirectionString(d)), !(s instanceof Player));
	}

	@Override
	public void draw()
	{
		// TODO Auto-generated method stub

	}

}
