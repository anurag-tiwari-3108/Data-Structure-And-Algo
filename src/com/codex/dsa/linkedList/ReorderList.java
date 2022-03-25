package com.codex.dsa.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {
	
	public static void main(String [] args) {
		

	}

	public void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		Deque<ListNode> stack = new ArrayDeque<>();
		ListNode ptr=head;
		while(ptr != null) {
			stack.push(ptr);
			ptr = ptr.next;
		}
		
		int count  = (stack.size()-1)/2;
		ptr = head;
		while(count-- > 0) {
			ListNode top = stack.pop();
			ListNode tmp = ptr.next;
			ptr.next = top;
			top.next = tmp;
			ptr = tmp;			
		}
		stack.pop().next=null;
	}
	// Need Optimization
//	public void reorderList(ListNode head) {
//		Deque<ListNode> dq = new ArrayDeque<ListNode>();
//		while(head !=null && head.next !=null) {
//			dq.add(head);
//		}
//		Boolean flag = true;
//		ListNode node = new ListNode();
//		while(!dq.isEmpty()) {
//			node.next = flag ? dq.pollFirst() : dq.pollLast();
//			node = node.next;
//			node.next = null;
//		}		
//	}
}

 class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
