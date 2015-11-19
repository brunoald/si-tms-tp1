package br.com.tcc.bo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.tcc.model.BurnUp;

public class BurnUpBO {
	
	BurnUp burnUp;

	public void setBurnUp(BurnUp burnUp) {
		this.burnUp = burnUp;
	}

	public BurnUp getBurnUp() {
		return this.burnUp;
	}

	public JFreeChart getChart() {
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		
		double[] completed = getBurnUp().getWorkListHours();
		int[] scope = getBurnUp().getScopeList();
		String[] dates = getBurnUp().getDates();
		
		for (int i = 0; i < scope.length; i++) {
			ds.addValue(scope[i], "Total", dates[i]);
			ds.addValue(completed[i], "Completado", dates[i]);
		}
		
		JFreeChart chart = ChartFactory.createLineChart("Gráfico BurnUp", null, null, ds);
		return chart;
	}

}
