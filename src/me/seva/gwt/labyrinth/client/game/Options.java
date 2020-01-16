package me.seva.gwt.labyrinth.client.game;

public class Options
{
	private int initialMovesPerTurn;
	private int finalMovesPerTurn;
	private int fastTurns;
	private boolean revealOneways;
	private boolean moveToAttack;
	
	public int getInitialMovesPerTurn()
	{
		return initialMovesPerTurn;
	}
	public void setInitialMovesPerTurn(int initialMovesPerTurn)
	{
		this.initialMovesPerTurn = initialMovesPerTurn;
	}
	public int getFinalMovesPerTurn()
	{
		return finalMovesPerTurn;
	}
	public void setFinalMovesPerTurn(int finalMovesPerTurn)
	{
		this.finalMovesPerTurn = finalMovesPerTurn;
	}
	public int getFastTurns()
	{
		return fastTurns;
	}
	public void setFastTurns(int fastTurns)
	{
		this.fastTurns = fastTurns;
	}
	public boolean isRevealOneways()
	{
		return revealOneways;
	}
	public void setRevealOneways(boolean revealOneways)
	{
		this.revealOneways = revealOneways;
	}
	public boolean isMoveToAttack()
	{
		return moveToAttack;
	}
	public void setMoveToAttack(boolean moveToAttack)
	{
		this.moveToAttack = moveToAttack;
	}
}
