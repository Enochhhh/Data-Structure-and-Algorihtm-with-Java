package app;


import java.util.ArrayList;
import java.util.List;

import algorithm.dynamicprogramming.ArrangeMeeting;
import algorithm.dynamicprogramming.ArrangeMeeting.Meeting;
import algorithm.dynamicprogramming.LongestIncreasingSubsequence;
import algorithm.dynamicprogramming.MachineRental;
import algorithm.dynamicprogramming.MachineRental.Machine;

public class DataStructureAndAlgorithm {

	public static void main(String[] args) {
		
		/**
		 * Algorithm Dynamic Programming
		 * 
		 */
		
		/*****************************************/
		/** Index 01
		 * Problem Longest increasing subsequence
		 * 
		 */
//		LongestIncreasingSubsequence longestIncreasingSubsequence = 
//				new LongestIncreasingSubsequence(new Integer[] { 5, 2, 3, 4, 9, 10, 5, 6, 7, 8 });
//		longestIncreasingSubsequence.handle();
		
		
		/*****************************************/
		/** Index 02
		 * Problem Arrange meetings
		 * 
		 */
//		List<Meeting> meetings = new ArrayList<>();
//		meetings.add(new Meeting(1, 4));
//		meetings.add(new Meeting(2, 3));
//		meetings.add(new Meeting(5, 9));
//		meetings.add(new Meeting(6, 8));
//		meetings.add(new Meeting(9, 10));
//		meetings.add(new Meeting(11, 15));
//		meetings.add(new Meeting(13, 17));
//		meetings.add(new Meeting(19, 23));
//		ArrangeMeeting arrangeMeeting = new ArrangeMeeting(meetings);
//		arrangeMeeting.handle();
		
		/*****************************************/
		/** Index 03
		 * Problem Machine rental
		 * 
		 */
		List<Machine> machines = new ArrayList<>();
		machines.add(new Machine(1, 4, 23));
		machines.add(new Machine(2, 3, 18));
		machines.add(new Machine(5, 9, 6));
		machines.add(new Machine(6, 8, 19));
		machines.add(new Machine(9, 10, 28));
		machines.add(new Machine(11, 15, 6));
		machines.add(new Machine(13, 17, 3));
		machines.add(new Machine(19, 23, 15));
		MachineRental machineRental = new MachineRental(machines);
		machineRental.handle();
	}

}
