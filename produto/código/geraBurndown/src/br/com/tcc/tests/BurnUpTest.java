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
	
	@Test
	public void testScopeProjection() {
		burnup.setScope(0, 100);
		burnup.setScope(4, 120);
		burnup.setScope(8, 80);
		int[] scope = new int[] {100,100,100,100,120,120,120,120,80,80};
		assertArrayEquals(burnup.getScopeList(10), scope);
	}
}