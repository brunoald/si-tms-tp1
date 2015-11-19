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

	public int[] getScopeList() {
		int i = this.sprint.getItensHistorico().size();
		int[] list = new int[i];
		for (int j = 0; j < i; j++) {
			try {
				int value = scope.get(j);
				list[j] = value;
			} catch (Exception e) {
				list[j] = list[j - 1];
			}
		}
		return list;
	}

	public double[] getWorkListHours() {
		Hashtable<String, Double> workTimeByDay = new Hashtable<String, Double>();
		int i = 0, soma = 0;
		int size = sprint.getItensHistorico().size();
		double[] result = new double[size];
		for (ItemHistorico item : sprint.getItensHistorico()) {
			String key = DataUtil.dateToString(item.getData());
			double currentValue = 0.0;
			if (workTimeByDay.containsKey(key))
				currentValue = workTimeByDay.get(key);
			workTimeByDay.put(key, currentValue + item.getTempoGasto());
			double value = workTimeByDay.get(key);
			soma += value;
			result[i] = soma;
			i++;
		}
		return result;
	}
}
