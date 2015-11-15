package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;

public class SprintTest {
	
	Sprint sprint;

	@Before
	public void setUp() throws Exception {
		sprint = new Sprint();
	}

	@Test
	public void testGetDtInicio() {
		Date d = new Date();
		sprint.setDtInicio(d);
		assertEquals(sprint.getDtInicio(), d);
	}

	@Test
	public void testGetDtFim() {
		Date d = new Date();
		sprint.setDtFim(d);
		assertEquals(sprint.getDtFim(), d);
	}

	@Test
	public void testGetEstorias() {
		List<Estoria> estorias = new ArrayList<Estoria>();
		Estoria estoria1 = new Estoria();
		Estoria estoria2 = new Estoria();
		estorias.add(estoria1);
		estorias.add(estoria2);
		sprint.setEstorias(estorias);
		assertEquals(sprint.getEstorias(), estorias);
	}

	@Test
	public void testGetTotalHoras() {
		sprint.setTotalHoras(10.0);
		assertEquals(Double.valueOf(10.0), Double.valueOf(sprint.getTotalHoras()));
	}

	@Test
	public void testGetQtdeDias() {
		sprint.setQtdeDias(1);
		assertEquals(1, sprint.getQtdeDias());
	}

	@Test
	public void testGetItensHistorico() {
		List<ItemHistorico> itensHistorico = new ArrayList<ItemHistorico>();
		sprint.setItensHistorico(itensHistorico);
		assertEquals(sprint.getItensHistorico(), itensHistorico);
	}

}
