package me.seva.gwt.labyrinth.client.game;

import java.util.List;

public class GameController
{
	private final Maze maze;
	private final EventLogger logger;
	private final Options options;
	
	private int round; //first round is 0
	private int currentPlayerNumber;
	private Player currentPlayer;
	private int movesLeft;
	
	private List<Player> players;
	
	
	public GameController(Maze maze, EventLogger logger, Options options)
	{
		this.maze = maze;
		this.logger = logger;
		this.options = options;
	}
	
	public Maze getMaze()
	{
		return maze;
	}
	
	public EventLogger getLogger()
	{
		return logger;
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public int getMaxMoves()
	{
		if(round >= options.getFastTurns())
		{
			return options.getFinalMovesPerTurn();
		}
		else
		{
			return options.getInitialMovesPerTurn();
		}
	}
	
	public int getMoveNumber()
	{
		return getMaxMoves() - movesLeft + 1;
	}
	
	public void nextTurn()
	{
		movesLeft --;
		
		if(movesLeft <= 0)
		{
			currentPlayerNumber ++;
			if(currentPlayerNumber >= players.size())
			{
				round ++;
				currentPlayerNumber = 0;
			}

			currentPlayer = players.get(currentPlayerNumber);

			movesLeft = getMaxMoves();
		}
	}
	
	public void previousTurn()
	{
		movesLeft ++;
		
		if(((movesLeft > options.getFinalMovesPerTurn()) && (round >= options.getFastTurns()))
				|| ((movesLeft > options.getInitialMovesPerTurn()) && (round < options.getFastTurns())))
		{
			currentPlayerNumber --;
			if(currentPlayerNumber < 0)
			{
				round --;
				currentPlayerNumber = players.size() - 1;
			}

			currentPlayer = players.get(currentPlayerNumber);
			
			movesLeft = 1;
		}
	}
}
