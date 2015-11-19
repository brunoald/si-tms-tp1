package br.com.tcc.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import br.com.tcc.bo.BurnUpBO;
import br.com.tcc.model.BurnUp;
import br.com.tcc.model.Sprint;

public class BurnUpBOTest {

	@Test
	public void testBurnUpAttribute() {
		BurnUpBO burnUpBO = new BurnUpBO();
		BurnUp burnUp = new BurnUp();
		burnUpBO.setBurnUp(burnUp);
		assertEquals(burnUpBO.getBurnUp(), burnUp);
	}

	@Test
	public void testChart() throws ParseException {
		BurnUpBO burnUpBO = new BurnUpBO();
		BurnUp burnUp = new BurnUp();
		Sprint sprint = SprintsFixture.busySprint();
		burnUp.setScope(0, 80);
		burnUp.setScope(4, 100);
		burnUp.setSprint(sprint);
		burnUpBO.setBurnUp(burnUp);

		DefaultCategoryDataset ds = new DefaultCategoryDataset();

		ds.addValue(15, "Completado", "01/01/2015");
		ds.addValue(25, "Completado", "02/01/2015");
		ds.addValue(40, "Completado", "03/01/2015");
		ds.addValue(50, "Completado", "04/01/2015");
		ds.addValue(65, "Completado", "05/01/2015");
		ds.addValue(75, "Completado", "06/01/2015");
		ds.addValue(90, "Completado", "07/01/2015");
		ds.addValue(100, "Completado", "08/01/2015");

		ds.addValue(80, "Total", "01/01/2015");
		ds.addValue(80, "Total", "02/01/2015");
		ds.addValue(80, "Total", "0/01/2015");
		ds.addValue(80, "Total", "04/01/2015");
		ds.addValue(100, "Total", "05/01/2015");
		ds.addValue(100, "Total", "06/01/2015");
		ds.addValue(100, "Total", "07/01/2015");
		ds.addValue(100, "Total", "08/01/2015");

		JFreeChart chart = ChartFactory.createLineChart("Gráfico BurnUp", null, null, ds);

		TextTitle output = burnUpBO.getChart().getTitle();
		TextTitle expected = chart.getTitle();
		assertEquals(output, expected);
	}
}
