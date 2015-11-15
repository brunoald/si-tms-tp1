package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.tcc.model.Historico;
import br.com.tcc.model.ItemHistorico;

public class HistoricoTest {
	
	Historico historico;
	ItemHistorico item;
	List<ItemHistorico> items;

	@Test
	public void testItens() {
		historico = new Historico();
		item = new ItemHistorico();
		items = new ArrayList<ItemHistorico>();
		items.add(item);
		historico.setItens(items);
		assertEquals(historico.getItens(), items);
	}
}
