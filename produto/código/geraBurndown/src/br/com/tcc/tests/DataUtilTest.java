package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.tcc.util.DataUtil;

public class DataUtilTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		new DataUtil();
	}

	@Test
	public void testConverteStringParaDateValido() throws ParseException {
		Date e = new Date(2015-1900,0,1);
		Date d = DataUtil.converteStringParaDate("01/01/2015");
		assertEquals(d, e);
	}
	
	@Test
	public void testConverteStringParaDateInvalido() throws ParseException {
	    exception.expect(ParseException.class);
		DataUtil.converteStringParaDate("invalid");
	}
	
	@Test
	public void testConverteStringParaDateInvalidoNull() throws ParseException {
		Date d = DataUtil.converteStringParaDate(null);
		assertEquals(d, null);
	}
	
	@Test
	public void testConverteStringParaDateInvalidoVazio() throws ParseException {
		Date d = DataUtil.converteStringParaDate("");
		assertEquals(d, null);
	}

	@Test
	public void testDateToString() {
		Date e = new Date(2015-1900,0,1);
		String dataString = DataUtil.dateToString(e);
		assertEquals("01/01/2015", dataString);
	}

	@Test
	public void testAdicionarDiasData() {
		Date hoje = new Date(2015-1900,0,1);
		Date amanha = new Date(2015-1900,0,2);
		Date conversao = DataUtil.adicionarDiasData(hoje, 1);
		assertEquals(conversao, amanha);
	}

}
