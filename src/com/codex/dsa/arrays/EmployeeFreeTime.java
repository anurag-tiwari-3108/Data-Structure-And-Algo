package com.codex.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
	class Interval{
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.end = end;
			this.start = start;
		}
	}
	public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
		List<Interval> result = new ArrayList<>();
		List<Interval> timeLine = new ArrayList<>();
		avails.forEach(e -> timeLine.addAll(e));
		Collections.sort(timeLine, ((a, b) -> a.start - b.start));

		Interval temp = timeLine.get(0);
		for (Interval each : timeLine) {
			if (temp.end < each.start) {
				result.add(new Interval(temp.end, each.start));
				temp = each;
			} else {
				temp = temp.end < each.end ? each : temp;
			}
		}
		return result;
	}
}
