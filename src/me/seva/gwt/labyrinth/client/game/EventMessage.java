package me.seva.gwt.labyrinth.client.game;


public class EventMessage
{
	private final String text;
	private final String color;
	private final boolean secret;
	
	public EventMessage(String text)
	{
		this.text = text;
		this.color = "#000000";
		this.secret = false;
	}
	
	public EventMessage(String text, boolean secret)
	{
		this.text = text;
		this.color = "#000000";
		this.secret = secret;
	}
	
	public EventMessage(String text, String color, boolean secret)
	{
		this.text = text;
		this.color = color;
		this.secret = secret;
	}

	public String getText()
	{
		return text;
	}

	public String getColor()
	{
		return color;
	}

	public boolean isSecret()
	{
		return secret;
	}
	
	
}
