package br.com.tcc.model;

import java.util.Hashtable;

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
		return null;
	}
}
