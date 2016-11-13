package de.uniks.pm.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uniks.pm.game.model.Dice;
import de.uniks.pm.game.model.Game;
import de.uniks.pm.game.model.Ground;
import de.uniks.pm.game.model.Trainer;

public class TestModel {

	@Test
	public void testGameToPlayer() throws Exception {

		Game game = new Game();
		Trainer trainer = new Trainer();

		game.withTrainer(trainer);
		trainer.withGame(game);

		assertNotNull(game.getTrainers());
		assertNotNull(trainer.getGame());
		assertTrue(game.getTrainers().contains(trainer));
		assertEquals(trainer.getGame(), game);
	}

	@Test
	public void testGameToGround() throws Exception {

		Game game = new Game();
		Ground ground = new Ground();

		game.withGrounds(ground);
		ground.withGame(game);

		assertNotNull(game.getGrounds());
		assertNotNull(ground.getGame());
		assertTrue(game.getGrounds().contains(ground));
		assertEquals(ground.getGame(), game);

		game.removeGround(ground);

		assertTrue(!game.getGrounds().contains(ground));
		assertNull(ground.getGame());
	}

	@Test
	public void testGameToDice() throws Exception {

		Game game = new Game();
		Dice dice = new Dice();

		game.with(dice);
		dice.withGame(game);

		assertNotNull(game.getDice());
		assertNotNull(dice.getGame());
		assertEquals(game.getDice(), dice);
		assertEquals(dice.getGame(), game);
	}

	@Test
	public void testTrainerToGround() throws Exception {

		Trainer trainer = new Trainer();
		Ground ground = new Ground();
		Ground aGround = new Ground();

		trainer.withGround(ground);
		aGround.withTrainer(trainer);

		assertNotNull(trainer.getGround());
		assertNotNull(ground.getTrainers());
		assertFalse(ground.getTrainers().contains(trainer));
		assertEquals(trainer.getGround(), aGround);
	}

	@Test
	public void testCurrentTrainerToGame() throws Exception {

		Game game = new Game();
		Trainer trainer1 = new Trainer();
		Trainer trainer2 = new Trainer();

		game.withCurrentTrainer(trainer1);

		assertNotNull(game.getCurrentTrainer());
		assertEquals(game.getCurrentTrainer(), trainer1);
		assertEquals(trainer1.getCurrentGame(), game);

		game.withCurrentTrainer(trainer2);

		assertEquals(game.getCurrentTrainer(), trainer2);
		assertNull(trainer1.getCurrentGame());
		assertEquals(trainer2.getCurrentGame(), game);
	}
	
	@Test
	public void testNeighbor() throws Exception {
		
		Ground ground = new Ground();
		Ground left = new Ground();
		Ground right = new Ground();
		Ground top = new Ground();
		Ground bot = new Ground();
		
		ground.withNeighbor(left, right, top, bot);
		
		assertNotNull(ground.getNeighbors());
		assertTrue(ground.getNeighbors().contains(bot));
		assertTrue(left.getNeighbors().contains(ground));
		assertEquals(ground.getNeighbors().size(), 4);
		
		ground.removeNeighbor(top);
		
		assertFalse(top.getNeighbors().contains(ground));
		assertFalse(ground.getNeighbors().contains(top));
		assertEquals(ground.getNeighbors().size(), 3);
	}
}
