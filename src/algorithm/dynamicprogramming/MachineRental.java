package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MachineRental {

	public static class Machine {
		private Integer startTime;
		private Integer endTime;
		private Integer cost;
		
		public Machine(Integer startTime, Integer endTime, Integer cost) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.cost = cost;
		}
	}
	
	private List<Machine> machines;
	private List<Integer> L;
	private List<Integer> T;
	private Integer size;
	
	public MachineRental(List<Machine> machines) {
		this.machines = machines;
		this.machines.add(0, new Machine(Integer.MIN_VALUE, Integer.MIN_VALUE, 0));
		this.machines.add(machines.size(), new Machine(Integer.MAX_VALUE, Integer.MAX_VALUE, 0));
		this.size = machines.size();
		L = new ArrayList<>(Arrays.asList(new Integer[size]));
		T = new ArrayList<>(Arrays.asList(new Integer[size]));
	}
	
	public void handle() {
		buildSolutionTable();
		traceAndWriteResult();
	}
	
	public void buildSolutionTable() {
		L.set(size - 1, 0);
		for (int i = size - 2; i >= 0; i--) {
			int jMax = size - 1;
			for (int j = i + 1; j < size; j++) {
				if (machines.get(j).startTime > machines.get(i).endTime && L.get(j) > L.get(jMax)) {
					jMax = j;
				}
			}
			L.set(i, L.get(jMax) + machines.get(i).cost);
			T.set(i, jMax);
		}
	}
	
	public void traceAndWriteResult() {
		System.out.println("Maximum number of machines that can be arranged: " + L.get(0));
		int i = T.get(0);
		while (i != size - 1) {
			System.out.println("Machines " + i + " " + machines.get(i).startTime + " " + machines.get(i).endTime + " " + machines.get(i).cost);
			i = T.get(i);
		}
	}
}
