package de.uniks.pm.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uniks.pm.game.model.Ground;

public class TestGroundToGround {

	@Test
	public void testToLower() throws Exception {

		Ground lower = new Ground();
		Ground ground = new Ground();
		Ground higher = new Ground();

		ground.withFloorLower(lower).withFloorHigher(higher);

		assertNotNull(ground.getFloorHigher());
		assertNotNull(ground.getFloorLower());

		ground.removeFloorHigher(higher);

		assertNotNull(ground.getFloorHigher());
		assertFalse(ground.getFloorHigher().contains(higher));
		assertFalse(higher.getFloorLower().contains(ground));
	}

	@Test
	public void testToHigher() throws Exception {

		Ground lower = new Ground();
		Ground ground = new Ground();
		Ground higher = new Ground();

		ground.withFloorHigher(higher).withFloorLower(lower);

		assertNotNull(ground.getFloorHigher());
		assertNotNull(ground.getFloorLower());

		ground.removeFloorLower(lower);

		assertNotNull(ground.getFloorLower());
		assertFalse(ground.getFloorLower().contains(lower));
		assertFalse(lower.getFloorHigher().contains(ground));
	}
}
