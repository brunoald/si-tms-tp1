package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.bo.BurndownBO;
import br.com.tcc.bo.SprintBO;
import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;

public class BurndownBOTest {
	
	Sprint sprint, dataSprint;
	List<Estoria> estorias;
	List<ItemHistorico> items;
	SprintBO sprintBO;
	BurndownBO burndownBO;

	@Before
	public void setUp() throws Exception {
		burndownBO = new BurndownBO();
		sprint = new Sprint();
		estorias = new ArrayList<Estoria>();
		items = new ArrayList<ItemHistorico>();
		sprintBO = new SprintBO();
		dataSprint = generateSprint();
	}
	
	public Sprint generateSprint() throws ParseException {
		sprint.setDtInicio(DataUtil.converteStringParaDate("01/01/2015"));
		sprint.setQtdeDias(7);
		
		// 2 estórias devem terminar, sendo que uma em uma data que já
		// tenha pontos registrados e outra não.
		
		List<Estoria> estorias = new ArrayList<Estoria>();
		
		Estoria est1 = new Estoria();
		est1.setTempoEstimado(40);
		est1.setCodEstoria(1);
		est1.setQtdePontos(5);

		Estoria est2 = new Estoria();
		est2.setTempoEstimado(32);
		est2.setCodEstoria(2);
		est2.setQtdePontos(3);
		
		Estoria est3 = new Estoria();
		est3.setTempoEstimado(10);
		est3.setCodEstoria(3);
		est3.setQtdePontos(1);
		
		Estoria est4 = new Estoria();
		est4.setTempoEstimado(88);
		est4.setCodEstoria(4);
		est4.setQtdePontos(8);
		
		estorias.add(est1);
		estorias.add(est2);
		estorias.add(est3);
		estorias.add(est4);
		
		sprint.setEstorias(estorias);
		
		sprint.setTotalHoras(sprintBO.calculaTotalHoras(sprint));
				
		ItemHistorico item = new ItemHistorico();
		item.setCodEstoria(1);
		item.setTempoGasto(40);
		item.setData(DataUtil.converteStringParaDate("01/01/2015"));
		
		ItemHistorico item2 = new ItemHistorico();
		item2.setCodEstoria(2);
		item2.setTempoGasto(32);
		item2.setData(DataUtil.converteStringParaDate("01/01/2015"));
		
		ItemHistorico item3 = new ItemHistorico();
		item3.setCodEstoria(3);
		item3.setTempoGasto(15);
		item3.setData(DataUtil.converteStringParaDate("02/01/2015"));
		
		ItemHistorico item4 = new ItemHistorico();
		item4.setCodEstoria(3);
		item4.setTempoGasto(33);
		item4.setData(DataUtil.converteStringParaDate("03/01/2015"));

		ItemHistorico item5 = new ItemHistorico();
		item5.setCodEstoria(3);
		item5.setTempoGasto(3);
		item5.setData(DataUtil.converteStringParaDate("04/01/2015"));
		
		ItemHistorico item6 = new ItemHistorico();
		item6.setCodEstoria(3);
		item6.setTempoGasto(2);
		item6.setData(DataUtil.converteStringParaDate("05/01/2015"));
		
		List<ItemHistorico> itens = new ArrayList<ItemHistorico>();
		itens.add(item);
		itens.add(item2);
		itens.add(item3);
		itens.add(item4);
		itens.add(item5);
		itens.add(item6);
		sprint.setItensHistorico(itens);
		return sprint;
	}

	@Test
	public void testGetQtdeHorasRestantesHoras() {
		burndownBO.gerarBurndownHoras(dataSprint);
		assertEquals(Double.valueOf(45.0), Double.valueOf(burndownBO.getQtdeHorasRestantes()));
	}

	@Test
	public void testGetTotalHorasHoras() {
		burndownBO.gerarBurndownHoras(dataSprint);
		assertEquals(Double.valueOf(170.0), Double.valueOf(burndownBO.getTotalHoras()));
	}

	@Test
	public void testGetQtdeHorasConsumidasHoras() {
		burndownBO.gerarBurndownHoras(dataSprint);
		assertEquals(Double.valueOf(125.0), Double.valueOf(burndownBO.getQtdeHorasConsumidas()));
	}

	@Test
	public void testGetConsumoDiarioIdealHoras() {
		burndownBO.gerarBurndownHoras(dataSprint);
		assertEquals(24, (int) burndownBO.getConsumoDiarioIdeal());
	}
	
	@Test
	public void testGetQtdeHorasRestantesPontos() {
		burndownBO.gerarBurndownPontos(dataSprint);
		assertEquals(Double.valueOf(0.0), Double.valueOf(burndownBO.getQtdeHorasRestantes()));
		
		burndownBO.setQtdeHorasRestantes(1.0);
		assertEquals(Double.valueOf(1.0), Double.valueOf(burndownBO.getQtdeHorasRestantes()));
	}

	@Test
	public void testGetTotalHorasPontos() {
		burndownBO.gerarBurndownPontos(dataSprint);
		assertEquals(Double.valueOf(0.0), Double.valueOf(burndownBO.getTotalHoras()));
	}

	@Test
	public void testGetQtdeHorasConsumidasPontos() {
		burndownBO.gerarBurndownPontos(dataSprint);
		assertEquals(Double.valueOf(0.0), Double.valueOf(burndownBO.getQtdeHorasConsumidas()));
		
		burndownBO.setQtdeHorasConsumidas(1.0);
		assertEquals(Double.valueOf(1.0), Double.valueOf(burndownBO.getQtdeHorasConsumidas()));
	}

	@Test
	public void testGetConsumoDiarioIdealPontos() {
		burndownBO.gerarBurndownPontos(dataSprint);
		assertEquals(0, (int) burndownBO.getConsumoDiarioIdeal());
	}

}
