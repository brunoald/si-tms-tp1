package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
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
	public void testScopeList() throws ParseException {
		Sprint sprint = SprintsFixture.busySprint();
		burnup.setSprint(sprint);
		burnup.setScope(0, 100);
		burnup.setScope(4, 120);
		int[] scope = new int[] {100,100,100,100,120,120,120,120};
		assertArrayEquals(burnup.getScopeList(), scope);
	}
	
	@Test
	public void testWorkListHours() throws ParseException {
		Sprint sprint = SprintsFixture.busySprint();
		burnup.setSprint(sprint);
		double[] realWork = new double[] {15,25,40,50,65,75,90,100};
		assertArrayEquals(burnup.getWorkListHours(), realWork, 0.0);
	}
}