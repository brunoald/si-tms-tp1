package br.com.tcc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.tcc.model.BurnUp;
import br.com.tcc.model.Sprint;

public class BurnUpTest {
	
	@Test
	public void testAttributeSprint() {
		BurnUp burnup = new BurnUp();
		Sprint sprint = new Sprint();
		burnup.setSprint(sprint);
		assertEquals(burnup.getSprint(), sprint);
	}
}