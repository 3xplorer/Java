package de.uniks.pm.game.model;

import java.util.LinkedHashSet;

public class Game {

	private int actionPoints;
	private LinkedHashSet<Trainer> trainerList;
	private LinkedHashSet<Ground> groundList;
	private Dice dice;
	private Trainer currentTrainer;

	public int getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		if (this.dice == null || !this.dice.equals(dice)) {
			this.dice = dice;
			dice.setGame(this);
		}
	}

	public Game with(Dice dice) {
		setDice(dice);
		return this;
	}

	public void addTrainer(Trainer trainer) {
		if (trainerList == null) {
			trainerList = new LinkedHashSet<>();
		}
		if (!trainerList.contains(trainer)) {
			trainerList.add(trainer);
			trainer.setGame(this);
		}
	}

	public void removeTrainer(Trainer trainer) {
		if (trainerList != null && trainerList.contains(trainer)) {
			trainerList.remove(trainer);
			trainer.setGame(null);
		}
	}

	public LinkedHashSet<Trainer> getTrainers() {
		return trainerList;
	}

	public Game withTrainer(Trainer... trainers) {
		for (Trainer trainer : trainers) {
			addTrainer(trainer);
		}
		return this;
	}

	public void addGround(Ground ground) {
		if (groundList == null) {
			groundList = new LinkedHashSet<>();
		}
		if (!groundList.contains(ground)) {
			groundList.add(ground);
			ground.setGame(this);
		}
	}

	public void removeGround(Ground ground) {
		if (groundList != null) {
			groundList.remove(ground);
			ground.setGame(null);
		}
	}

	public LinkedHashSet<Ground> getGrounds() {
		return groundList;
	}

	public Game withGrounds(Ground... grounds) {
		for (Ground ground : grounds) {
			addGround(ground);
		}
		return this;
	}

	public Trainer getCurrentTrainer() {
		return currentTrainer;
	}

	public void setCurrentTrainer(Trainer newTrainer) {
		Trainer oldValue = this.getCurrentTrainer();
		if (currentTrainer == null || !currentTrainer.equals(newTrainer)) {
			currentTrainer = newTrainer;
			currentTrainer.setCurrentGame(this);
			if (oldValue != null) {
				oldValue.setCurrentGame(null);
			}
		}
	}

	public Game withCurrentTrainer(Trainer trainer) {
		setCurrentTrainer(trainer);
		return this;
	}

	public boolean checkend() {
		return false;
	}
}
