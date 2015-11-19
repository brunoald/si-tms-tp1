package br.com.tcc.model;

import java.util.Hashtable;

import br.com.tcc.util.DataUtil;

public class BurnUp {
	
	Sprint sprint;
	Hashtable<Integer, Integer> scope = new Hashtable<Integer, Integer>();


	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setScope(int iteration, int amount) {
		scope.put(iteration, amount);
	}

	public int[] getScopeList(int i) {
		int[] list = new int[i];
		for (int j = 0; j < i; j++) {
			try {
				int value = scope.get(j);
				list[j] = value;				
			} catch (Exception e) {
				list[j] = list[j-1];
			}
		}
		return list;
	}

	public double[] getWorkList() {
		Hashtable<String, Double> workTimeByDay = new Hashtable<String, Double>();
		for (ItemHistorico item : sprint.getItensHistorico()) {
			workTimeByDay.put(DataUtil.dateToString(item.getData()), 0.0);
		}
		for (ItemHistorico item : sprint.getItensHistorico()) {
			double currentValue = workTimeByDay.get(DataUtil.dateToString(item.getData())); 
			workTimeByDay.put(DataUtil.dateToString(item.getData()), currentValue + item.getTempoGasto());
		}
		int size = sprint.getItensHistorico().size();
		double[] result = new double[size];
		int i = 0;
		int soma = 0;
		for (ItemHistorico item : sprint.getItensHistorico()) {
			double value = workTimeByDay.get(DataUtil.dateToString(item.getData()));
			soma+= value;
			result[i] = soma;
			i++;	
		}
		return result;
	}
}
