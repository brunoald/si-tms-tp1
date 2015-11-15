package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.ItemHistorico;

public class ItemHistoricoTest {
	
	ItemHistorico item;

	@Before
	public void setUp() throws Exception {
		item = new ItemHistorico();
	}

	@Test
	public final void testGetData() {
		Date d = new Date();
		item.setData(d);
		assertEquals(item.getData(), d);
	}

	@Test
	public void testGetTempoGasto() {
		item.setTempoGasto(1.5);
		assertEquals(Double.valueOf(item.getTempoGasto()), Double.valueOf(1.5));
	}

	@Test
	public final void testGetCodEstoria() {
		item.setCodEstoria(1);
		assertEquals((int)item.getCodEstoria(), 1);
	}
}
