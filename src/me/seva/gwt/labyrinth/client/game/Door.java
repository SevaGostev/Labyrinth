package me.seva.gwt.labyrinth.client.game;

public class Door implements Edge
{
	private final Position position;
	private final boolean vertical;
	private final DoorColor color;

	public Door(Position position, boolean vertical, DoorColor color)
	{
		this.position = position;
		this.vertical = vertical;
		this.color = color;
	}

	@Override
	public boolean canCross(Stepper s, boolean positive)
	{
		if(s instanceof Player)
		{
			return ((Player) s).hasItem(new Key(color));
		}
		else
		{
			return s.getController().getOptions().getBearsIgnoreDoors();
		}
	}

	@Override
	public EventMessage getCrossMessage(Stepper s, Direction d)
	{
		return new EventMessage(String.format("%s steps %s through a %s door.", s.getName(),
				GameController.getDirectionString(d), color.getName()), !(s instanceof Player));
	}

	@Override
	public EventMessage getBumpMessage(Stepper s, Direction d)
	{
			return new EventMessage(String.format("%s attempts to step %s but there's a %s door there.", s.getName(),
					GameController.getDirectionString(d), color.getName()), !(s instanceof Player));
	}

	@Override
	public void draw()
	{
		// TODO Auto-generated method stub

	}


}
