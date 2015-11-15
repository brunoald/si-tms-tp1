package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.text.ParseException;

import org.junit.Test;

import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.util.Main;

public class MainTest {

	@Test
	public void testMain() throws ParseException {
		new Main();
		Main.main(null);
	}

	@Test
	public void testCriaItensHistorico() throws ParseException {
		List<ItemHistorico> items = Main.criaItensHistorico();
		assertEquals(items.size(), 7);
	}

	@Test
	public void testCriaListaEstorias() {
		List<Estoria> estorias = Main.criaListaEstorias();
		assertEquals(estorias.size(), 4);
	}

}
