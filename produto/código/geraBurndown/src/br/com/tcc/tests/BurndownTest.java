package br.com.tcc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.Burndown;

public class BurndownTest {
	
	Burndown burndown;

	@Before
	public void setUp() throws Exception {
		burndown = new Burndown();
	}

	@Test
	public final void testQtdeHorasConsumidas() {
		burndown.setQtdeHorasConsumidas(1);
		assertEquals(1, (int) burndown.getQtdeHorasConsumidas());
	}

	@Test
	public final void testQtdeHorasRestantes() {
		burndown.setQtdeHorasRestantes(2);
		assertEquals(2, (int) burndown.getQtdeHorasRestantes());
	}

	@Test
	public final void testTotalHoras() {
		burndown.setTotalHoras(3);
		assertEquals(3, (int) burndown.getTotalHoras());
	}

	@Test
	public final void testConsumoDiarioIdeal() {
		burndown.setConsumoDiarioIdeal(4);
		assertEquals(4, (int) burndown.getConsumoDiarioIdeal());
	}
}
