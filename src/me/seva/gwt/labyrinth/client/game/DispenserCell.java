package me.seva.gwt.labyrinth.client.game;

public abstract class DispenserCell extends Cell
{

	@Override
	public void stepOn(Stepper s)
	{
		if(s instanceof Player)
		{
			InventoryItem item = getDispensableItem();
			TakeItemResult result = ((Player) s).canTakeItem(item);
			
			if(result == TakeItemResult.SUCCESS)
			{
				s.getController().getLogger().log(new TakeItemEvent((Player) s, item,
						new EventMessage(String.format("%s took a %s.", s.getName(), item.getName()))));
			}
			else
			{
				if(result == TakeItemResult.ALREADY_CARRYING)
				{
					s.getController().getLogger().log(new GenericEvent(
							new EventMessage(String.format("%s is already carrying a %s", s.getName(), item.getName()))));
				}
				else
				{
					s.getController().getLogger().log(new GenericEvent(
							new EventMessage(String.format("%s is injured and can't take a %s", s.getName(), item.getName()))));
				}
			}
		}
	}
	
	abstract public String getStepMessage(Stepper s);
	
	abstract public InventoryItem getDispensableItem();

}
