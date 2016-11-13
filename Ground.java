package de.uniks.pm.game.model;

import java.util.LinkedHashSet;

public class Ground {

	private int x;
	private int y;
	private Game game;
	private LinkedHashSet<Trainer> trainerList;
	private LinkedHashSet<Ground> floor_higher;
	private LinkedHashSet<Ground> floor_lower;
	private LinkedHashSet<Ground> neighbors;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
			oldValue.removeGround(this);
		}
		if (this.game != null) {
			game.addGround(this);
		}
	}

	public Ground withGame(Game game) {
		setGame(game);
		return this;
	}

	public void addTrainer(Trainer newTrainer) {
		Ground oldValue = newTrainer.getGround();

		if (trainerList == null) {
			trainerList = new LinkedHashSet<>();
		}
		if (!trainerList.contains(newTrainer)) {
			trainerList.add(newTrainer);
			if (oldValue != null) {
				oldValue.removeTrainer(newTrainer);
			}
			newTrainer.setGround(this);
		}
	}

	public void removeTrainer(Trainer trainer) {
		if (trainerList != null && trainerList.contains(trainer)) {
			trainerList.remove(trainer);
		}
	}

	public LinkedHashSet<Trainer> getTrainers() {
		return trainerList;
	}

	public Ground withTrainer(Trainer... trainers) {
		for (Trainer trainer : trainers) {
			addTrainer(trainer);
		}
		return this;
	}

	public void addFloorHigher(Ground ground) {
		if (floor_higher == null) {
			floor_higher = new LinkedHashSet<>();
		}
		if (!floor_higher.contains(ground)) {
			floor_higher.add(ground);
			ground.addFloorLower(this);
		}
	}

	public void removeFloorHigher(Ground ground) {
		if (floor_higher.contains(ground)) {
			floor_higher.remove(ground);
			ground.removeFloorLower(this);
		}
	}

	public LinkedHashSet<Ground> getFloorHigher() {
		return floor_higher;
	}

	public Ground withFloorHigher(Ground ground) {
		addFloorHigher(ground);
		return this;
	}

	public void addFloorLower(Ground ground) {
		if (floor_lower == null) {
			floor_lower = new LinkedHashSet<Ground>();
		}
		if (!floor_lower.contains(ground)) {
			floor_lower.add(ground);
			ground.addFloorHigher(this);
		}
	}

	public void removeFloorLower(Ground ground) {
		if (floor_lower.contains(ground)) {
			floor_lower.remove(ground);
			ground.removeFloorHigher(this);
		}
	}

	public LinkedHashSet<Ground> getFloorLower() {
		return floor_lower;
	}

	public Ground withFloorLower(Ground ground) {
		addFloorLower(ground);
		return this;
	}

	public void addNeighbor(Ground ground) {
		if (neighbors == null) {
			neighbors = new LinkedHashSet<>();
		}
		if (!neighbors.contains(ground)) {
			neighbors.add(ground);
			ground.addNeighbor(this);
		}
	}

	public LinkedHashSet<Ground> getNeighbors() {
		return neighbors;
	}

	public void removeNeighbor(Ground ground) {
		if (neighbors.contains(ground)) {
			neighbors.remove(ground);
			ground.removeNeighbor(this);
		}
	}

	public Ground withNeighbor(Ground... grounds) {
		for (Ground ground : grounds) {
			this.addNeighbor(ground);
		}
		return this;
	}
}
