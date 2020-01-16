package me.seva.gwt.labyrinth.client.game;

public class TurnAdvanceEvent implements LoggableEvent
{
	private final EventMessage message;
	private final GameController controller;
	
	public TurnAdvanceEvent(GameController controller)
	{
		this.controller = controller;
		
		doForward();
		
		message = new EventMessage(String.format("%s's turn, move %d/%d", controller.getCurrentPlayer().getName(),
				controller.getMoveNumber(), controller.getMaxMoves()), controller.getCurrentPlayer().getColor(), false);
	}

	@Override
	public void doForward()
	{
		controller.nextTurn();
	}

	@Override
	public void doBackward()
	{
		controller.previousTurn();
	}

	@Override
	public EventMessage getMessage()
	{
		return message;
	}

}
