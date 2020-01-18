package me.seva.gwt.labyrinth.client.game;

public class Options
{
	private int initialMovesPerTurn;
	private int finalMovesPerTurn;
	private int fastTurns;
	private boolean revealOneways;
	private boolean bearsIgnoreOneways;
	private boolean bearsIgnoreDoors;
	private boolean moveToAttack;
	private boolean unarmedAttack;
	
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
	public boolean getRevealOneways()
	{
		return revealOneways;
	}
	public void setRevealOneways(boolean revealOneways)
	{
		this.revealOneways = revealOneways;
	}
	public boolean getBearsIgnoreOneways()
	{
		return bearsIgnoreOneways;
	}
	public void setBearsIgnoreOneways(boolean bearsIgnoreOneways)
	{
		this.bearsIgnoreOneways = bearsIgnoreOneways;
	}
	public boolean getBearsIgnoreDoors()
	{
		return bearsIgnoreDoors;
	}
	public void setBearsIgnoreDoors(boolean bearsIgnoreDoors)
	{
		this.bearsIgnoreDoors = bearsIgnoreDoors;
	}
	public boolean getMoveToAttack()
	{
		return moveToAttack;
	}
	public void setMoveToAttack(boolean moveToAttack)
	{
		this.moveToAttack = moveToAttack;
	}
	public boolean getUnarmedAttack()
	{
		return unarmedAttack;
	}
	public void setUnarmedAttack(boolean unarmedAttack)
	{
		this.unarmedAttack = unarmedAttack;
	}
}
