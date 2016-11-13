package de.uniks.pm.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uniks.pm.game.model.Game;
import de.uniks.pm.game.model.Trainer;

public class TestGameToTrainer {

	@Test
	public void testGameToPlayer() throws Exception {

		Game game = new Game();
		Trainer ralf = new Trainer();
		Trainer harry = new Trainer();

		game.withTrainer(ralf).withTrainer(harry);

		assertNotNull(game.getTrainers());
		assertNotNull(ralf.getGame());
		assertTrue(game.getTrainers().contains(ralf));
		assertEquals(ralf.getGame(), game);

		game.removeTrainer(ralf);

		assertFalse(game.getTrainers().contains(ralf));
		assertNull(ralf.getGame());
	}

	@Test
	public void testTrainerToGame() throws Exception {

		Game game = new Game();
		Trainer trainer = new Trainer();

		trainer.withGame(game);

		assertNotNull(game.getTrainers());
		assertNotNull(trainer.getGame());
		assertTrue(game.getTrainers().contains(trainer));
		assertEquals(trainer.getGame(), game);

		trainer.setGame(null);
		
		assertNull(trainer.getGame());
	}
}
