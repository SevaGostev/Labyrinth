package me.seva.gwt.labyrinth.client.game;

public class OneWayWall implements Edge
{
	private final Position position;
	private final boolean vertical;
	private final boolean positive;

	public OneWayWall(Position position, boolean vertical, boolean positive)
	{
		this.position = position;
		this.vertical = vertical;
		this.positive = positive;
	}

	@Override
	public boolean canCross(Stepper s, boolean positive)
	{
		if(!(s instanceof Player) && (s.getController().getOptions().getBearsIgnoreOneways()))
			return true;
		else
			return !(positive ^ this.positive);
	}

	@Override
	public EventMessage getCrossMessage(Stepper s, Direction d)
	{
		return new EventMessage(String.format("%s steps %s through a one-way passage.", s.getName(),
				GameController.getDirectionString(d)), !(s instanceof Player));
	}

	@Override
	public EventMessage getBumpMessage(Stepper s, Direction d)
	{
		if(s.getController().getOptions().getRevealOneways())
		{
			return new EventMessage(String.format("%s attempts to step %s but cannot. There's an one-way passage in the opposite direction.",
					s.getName(),
					GameController.getDirectionString(d)), !(s instanceof Player));
		}
		else
		{
			return new EventMessage(String.format("%s attempts to step %s but there's a wall there.", s.getName(),
					GameController.getDirectionString(d)), !(s instanceof Player));
		}
	}

	@Override
	public void draw()
	{
		// TODO Auto-generated method stub

	}

}
