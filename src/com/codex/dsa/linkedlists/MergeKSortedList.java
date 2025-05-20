package com.codex.dsa.linkedList;

import java.util.PriorityQueue;

public class MergeKSortedList {

	public Node mergeKLists(Node[] lists) {
		if (lists.length == 0)
			return null;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.length; ++i) {
			while (lists[i] != null) {
				pq.add(lists[i].val);
				lists[i] = lists[i].next;
			}
		}

		if (pq.peek() == null)
			return null;
		Node res = new Node(pq.poll());
		Node resultHead = res;
		while (pq.peek() != null) {
			res.next = new Node(pq.poll());
			res = res.next;

		}

		return resultHead;
	}

}
