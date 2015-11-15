package br.com.tcc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.tcc.model.Estoria;

public class EstoriaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testAttributes() {
		Estoria est = new Estoria();
		est.setCodEstoria(1);
		est.setQtdePontos(2);
		est.setTempoEstimado(3.0);
		est.setTempoGasto(4);
		est.setTempoRestante(5.0);
		assertEquals(Double.valueOf(1), Double.valueOf(est.getCodEstoria()));
		assertEquals(Double.valueOf(2), Double.valueOf(est.getQtdePontos()));
		assertEquals(Double.valueOf(3.0), Double.valueOf(est.getTempoEstimado()));
		assertEquals(Double.valueOf(4), Double.valueOf(est.getTempoGasto()));
		assertEquals(Double.valueOf(5), Double.valueOf(est.getTempoRestante()));
	}

}
