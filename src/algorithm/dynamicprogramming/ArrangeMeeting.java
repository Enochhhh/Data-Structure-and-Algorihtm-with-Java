package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description Problem: There are n meetings. The i meeting starts at the time si and ends at the time fi. Because there is only one conference 
 * room, any meeting will be arranged together if their working time periods only intersect at the same end. Arrange the meeting room to 
 * accommodate the most meetings.
 * 
 * 
 * Example: The longest monotically increasing subsequence of Aseq = (5, 2, 3, 4, 9, 10, 5, 6, 7, 8) is (2, 3, 4, 5, 6, 7, 8)
 * 
 * @author Son Phan
 *
 */
public class ArrangeMeeting {
	
	public static class Meeting {
		private Integer startTime;
		private Integer endTime;
		
		public Meeting(Integer startTime, Integer endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
	}

	private List<Meeting> meetings;
	private List<Integer> L;
	private List<Integer> T;
	private Integer size;
	
	public ArrangeMeeting(List<Meeting> meetings) {
		this.meetings = meetings;
		Meeting meetingLeftTip = new Meeting(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Meeting meetingRightTip = new Meeting(Integer.MAX_VALUE, Integer.MAX_VALUE);
		this.meetings.add(0, meetingLeftTip);
		this.meetings.add(meetings.size(), meetingRightTip);
		this.size = meetings.size();
		L = new ArrayList<>(Arrays.asList(new Integer[size]));
		T = new ArrayList<>(Arrays.asList(new Integer[size]));
	}
	
	public void handle() {
		buildSolutionTable();
		traceAndWriteResult();
	}
	
	public void buildSolutionTable() {
		L.set(size - 1, 1);
		for (int i = size - 2; i >= 0; i--) {
			int jMax = size - 1;
			for (int j = i + 1; j <= size - 1; j++) {
				if (meetings.get(j).startTime >= meetings.get(i).endTime && L.get(j) > L.get(jMax)) {
					jMax = j;
				}
			}
			L.set(i, L.get(jMax) + 1);
			T.set(i, jMax);
		}
	}
	
	public void traceAndWriteResult() {
		System.out.println("Maximum number of meetings that can be arranged: " + (L.get(0) - 2));
		int i = T.get(0);
		while (i != size - 1) {
			System.out.println("Meeting " + i + " " + meetings.get(i).startTime + " " + meetings.get(i).endTime);
			i = T.get(i);
		}
	}
}
