package me.seva.gwt.labyrinth.client.game;

public class TreasureRoom extends DispenserCell
{
	private final Position position;
	
	public TreasureRoom(Position position)
	{
		this.position = position;
	}

	@Override
	public String getStepMessage(Stepper s)
	{
		return String.format("%s is in the treasury.", s.getName());
	}

	@Override
	public InventoryItem getDispensableItem()
	{
		return new Treasure();
	}

	@Override
	public void draw()
	{
		// TODO Auto-generated method stub

	}

}
