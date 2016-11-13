package de.uniks.pm.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uniks.pm.game.model.Dice;
import de.uniks.pm.game.model.Game;

public class TestGameToDice {

	@Test
	public void testGameToDice() throws Exception {

		Game game = new Game();
		Dice dice = new Dice();

		game.with(dice);

		assertNotNull(game.getDice());
		assertNotNull(dice.getGame());
		assertEquals(game.getDice(), dice);
		assertEquals(dice.getGame(), game);
	}

	@Test
	public void testDiceToGame() throws Exception {

		Game game = new Game();
		Dice dice = new Dice();

		dice.withGame(game);

		assertNotNull(game.getDice());
		assertNotNull(dice.getGame());
		assertEquals(game.getDice(), dice);
		assertEquals(dice.getGame(), game);
	}
}
