package br.com.tcc.bo;

import org.jfree.chart.JFreeChart;

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
		return null;
	}

}
