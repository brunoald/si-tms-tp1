package br.com.tcc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.tcc.bo.BurnUpBO;
import br.com.tcc.model.BurnUp;

public class BurnUpBOTest {

	@Test
	public void testBurnUpAttribute() {
		BurnUpBO burnUpBO = new BurnUpBO();
		BurnUp burnUp = new BurnUp();
		burnUpBO.setBurnUp(burnUp);
		assertEquals(burnUpBO.getBurnUp(), burnUp);
	}
}
