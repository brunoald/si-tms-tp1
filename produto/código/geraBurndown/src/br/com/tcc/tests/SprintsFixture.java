package br.com.tcc.tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcc.model.Estoria;
import br.com.tcc.model.ItemHistorico;
import br.com.tcc.model.Sprint;
import br.com.tcc.util.DataUtil;

public class SprintsFixture {

	public static Sprint busySprint() throws ParseException {
		Sprint sprint = new Sprint();
		sprint.setDtInicio(DataUtil.converteStringParaDate("01/01/2015"));
		sprint.setQtdeDias(7);
		
		List<Estoria> estorias = new ArrayList<Estoria>();
		
		Estoria est1 = new Estoria();
		Estoria est2 = new Estoria();
		Estoria est3 = new Estoria();
		Estoria est4 = new Estoria();
		
		est1.setTempoEstimado(25);
		est1.setCodEstoria(1);
		est2.setTempoEstimado(25);
		est2.setCodEstoria(2);
		est3.setTempoEstimado(25);
		est3.setCodEstoria(3);
		est4.setTempoEstimado(25);
		est4.setCodEstoria(4);
		
		estorias.add(est1);
		estorias.add(est2);
		estorias.add(est3);
		estorias.add(est4);
		
		sprint.setEstorias(estorias);
				
		ItemHistorico e1i1 = new ItemHistorico();
		e1i1.setCodEstoria(1);
		e1i1.setTempoGasto(15);
		e1i1.setData(DataUtil.converteStringParaDate("01/01/2015"));
		
		ItemHistorico e1i2 = new ItemHistorico();
		e1i2.setCodEstoria(1);
		e1i2.setTempoGasto(10);
		e1i2.setData(DataUtil.converteStringParaDate("02/01/2015"));
		
		ItemHistorico e2i1 = new ItemHistorico();
		e2i1.setCodEstoria(2);
		e2i1.setTempoGasto(15);
		e2i1.setData(DataUtil.converteStringParaDate("03/01/2015"));
		
		ItemHistorico e2i2 = new ItemHistorico();
		e2i2.setCodEstoria(2);
		e2i2.setTempoGasto(10);
		e2i2.setData(DataUtil.converteStringParaDate("04/01/2015"));
		
		ItemHistorico e3i1 = new ItemHistorico();
		e3i1.setCodEstoria(3);
		e3i1.setTempoGasto(15);
		e3i1.setData(DataUtil.converteStringParaDate("05/01/2015"));
		
		ItemHistorico e3i2 = new ItemHistorico();
		e3i2.setCodEstoria(3);
		e3i2.setTempoGasto(10);
		e3i2.setData(DataUtil.converteStringParaDate("06/01/2015"));
		
		ItemHistorico e4i1 = new ItemHistorico();
		e4i1.setCodEstoria(4);
		e4i1.setTempoGasto(15);
		e4i1.setData(DataUtil.converteStringParaDate("07/01/2015"));
		
		ItemHistorico e4i2 = new ItemHistorico();
		e4i2.setCodEstoria(4);
		e4i2.setTempoGasto(10);
		e4i2.setData(DataUtil.converteStringParaDate("08/01/2015"));
		
		List<ItemHistorico> itens = new ArrayList<ItemHistorico>();
		itens.add(e1i1);
		itens.add(e1i2);
		itens.add(e2i1);
		itens.add(e2i2);
		itens.add(e3i1);
		itens.add(e3i2);
		itens.add(e4i1);
		itens.add(e4i2);
		sprint.setItensHistorico(itens);
		return sprint;
	}
}
