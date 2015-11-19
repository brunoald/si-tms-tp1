package br.com.tcc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.BurnUp;
import br.com.tcc.model.Sprint;

public class BurnUpTest {

	BurnUp burnup;

	@Before
	public void setUp() {
		burnup = new BurnUp();
	}

	@Test
	public void testAttributeSprint() {
		Sprint sprint = new Sprint();
		burnup.setSprint(sprint);
		assertEquals(burnup.getSprint(), sprint);
	}
}