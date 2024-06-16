package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description Problem: Given an integer sequence Aseq consisting of n elements. A subsequence of Aseq is a way of selecting from Aseq a number of
 * elements that maintain the same order. Find the monotically increasing subsequence with the largest length.
 * 
 * Example: The longest monotically increasing subsequence of Aseq = (5, 2, 3, 4, 9, 10, 5, 6, 7, 8) is (2, 3, 4, 5, 6, 7, 8)
 * 
 * @author Son Phan
 *
 */
public class LongestIncreasingSubsequence {

	private List<Integer> sequence;
	private List<Integer> L;
	private List<Integer> T;
	private Integer size;
	
	public LongestIncreasingSubsequence(Integer[] array) {
		this.sequence = new ArrayList<>(Arrays.asList(array));
		this.sequence.add(0, Integer.MIN_VALUE);
		this.sequence.add(sequence.size(), Integer.MAX_VALUE);
		this.size = sequence.size();
		this.L = new ArrayList<>(Arrays.asList(new Integer[size]));
		this.T = new ArrayList<>(Arrays.asList(new Integer[size]));
	}
	
	public void handle() {
		buildSolutionTable();
		traceAndWriteResult();
	}
	
	private void buildSolutionTable() {
		L.set(size - 1, 1);
		
		for (int i = size - 2; i >= 0; i--) {
			Integer jMax = size - 1;
			for (int j = i + 1; j < size; j++) {
				if (sequence.get(j) > sequence.get(i) && L.get(j) > L.get(jMax)) {
					jMax = j;
				}
			}
			L.set(i, L.get(jMax) + 1);
			T.set(i, jMax);
		}
	}
	
	private void traceAndWriteResult() {
		System.out.println("Length of longest increasing subsequence: " + (L.get(0) - 2));
		Integer i = T.get(0);
		while (i != size - 1) {
			System.out.print(sequence.get(i) + " ");
			i = T.get(i);
		}
	}
}
