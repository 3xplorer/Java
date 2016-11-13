package de.uniks.pm.game.model;

public class Dice {

	private int value;
	private Game game;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		if (this.game == null || !this.game.equals(game)) {
			this.game = game;
			game.setDice(this);
		}
	}

	public Dice withGame(Game game) {
		setGame(game);
		return this;
	}
}
