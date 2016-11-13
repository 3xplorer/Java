package de.uniks.pm.game.model;

public class Trainer {

	private String name;
	private String color;
	private int experience;
	private Game game;
	private Ground ground;
	private Game currentGame;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		Game oldValue = this.game;

		if (this.game == null || !this.game.equals(game)) {
			this.game = game;
		}
		if (game == null && oldValue != null) {
			this.game = game;
			oldValue.removeTrainer(this);
		}
		if (this.game != null) {
			game.addTrainer(this);
		}
	}

	public Trainer withGame(Game game) {
		setGame(game);
		return this;
	}

	public Ground getGround() {
		return ground;
	}

	public void setGround(Ground ground) {
		if (this.ground == null || !this.ground.equals(ground)) {
			this.ground = ground;
			ground.addTrainer(this);
		}
	}

	public Trainer withGround(Ground ground) {
		setGround(ground);
		return this;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game game) {
		if (currentGame == null || !currentGame.equals(game)) {
			currentGame = game;
			game.setCurrentTrainer(this);
		}
	}

	public Trainer withCurrentGame(Game game) {
		setCurrentGame(game);
		return this;
	}
}
