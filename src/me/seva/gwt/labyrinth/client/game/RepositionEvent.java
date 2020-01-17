package me.seva.gwt.labyrinth.client.game;

public class RepositionEvent implements LoggableEvent
{
	private final Stepper target;
	private final Position startPosition;
	private final Position endPosition;
	private final EventMessage message;

	public RepositionEvent(Stepper target, Position pos)
	{
		this.target = target;
		this.startPosition = target.getPosition();
		this.endPosition = pos;
		this.message = null;
		
		doForward();
	}
	
	public RepositionEvent(Stepper target, Position pos, EventMessage message)
	{
		this.target = target;
		this.startPosition = target.getPosition();
		this.endPosition = pos;
		this.message = message;
		
		doForward();
	}
	
	@Override
	public void doForward()
	{
		if(target.getMaze().isInBounds(startPosition))
			target.getMaze().getCell(startPosition).remove(target);
		
		target.addTrace(startPosition);
		target.setPosition(endPosition);
		
		if(target.getMaze().isInBounds(endPosition))
			target.getMaze().getCell(endPosition).add(target);
	}

	@Override
	public void doBackward()
	{
		if(target.getMaze().isInBounds(endPosition))
			target.getMaze().getCell(endPosition).remove(target);
		
		target.removeLastTrace();
		target.setPosition(startPosition);
		
		if(target.getMaze().isInBounds(startPosition))
			target.getMaze().getCell(startPosition).add(target);
	}
	
	@Override
	public EventMessage getMessage()
	{
		return message;
	}

}
