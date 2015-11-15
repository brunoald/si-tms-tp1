package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.bo.SprintBO;
import br.com.tcc.model.Estoria;
import br.com.tcc.model.Sprint;

public class SprintBOTest {
	Sprint sprint;
	List<Estoria> estorias;
	SprintBO sprintBO;
	
	@Before
	public void setUp() throws Exception {
		sprint = new Sprint();
		estorias = new ArrayList<Estoria>();
		sprintBO = new SprintBO();
	}

	@Test
	public void testCalculaTotalHoras() {
		Estoria e1 = new Estoria();
		e1.setTempoEstimado(4.5);
		Estoria e2 = new Estoria();
		e2.setTempoEstimado(4.5);
		estorias.add(e1);
		estorias.add(e2);
		sprint.setEstorias(estorias);
		Double totalPontos = sprintBO.calculaTotalHoras(sprint);
		assertEquals(Double.valueOf(totalPontos), Double.valueOf(9.0));
	}

	@Test
	public void testCalculaTotalPontos() {
		Estoria e1 = new Estoria();
		e1.setQtdePontos(5);
		Estoria e2 = new Estoria();
		e2.setQtdePontos(5);
		estorias.add(e1);
		estorias.add(e2);
		sprint.setEstorias(estorias);
		int totalPontos = sprintBO.calculaTotalPontos(sprint);
		assertEquals(totalPontos, 10);
	}

}
