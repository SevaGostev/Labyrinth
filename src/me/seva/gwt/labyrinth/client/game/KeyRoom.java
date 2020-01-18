package me.seva.gwt.labyrinth.client.game;

public class KeyRoom extends DispenserCell
{
	private final Position position;
	private final DoorColor color;
	
	public KeyRoom(Position position, DoorColor color)
	{
		this.position = position;
		this.color = color;
	}

	@Override
	public String getStepMessage(Stepper s)
	{
		return String.format("%s is in a room with lots of %s keys.", s.getName(), color.getName());
	}

	@Override
	public InventoryItem getDispensableItem()
	{
		return new Key(color);
	}

	@Override
	public void draw()
	{
		// TODO Auto-generated method stub

	}

}
