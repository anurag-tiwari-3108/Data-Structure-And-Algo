package com.codex.dsa.linkedlists;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode ptr = head;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.next;
        }
        int count = (stack.size() - 1) / 2;
        ptr = head;
        while (count-- > 0) {
            ListNode top = stack.pop();
            ListNode tmp = ptr.next;
            ptr.next = top;
            top.next = tmp;
            ptr = tmp;
        }
        stack.pop().next = null;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("Original: "); printList(head);
        new ReorderList().reorderList(head);
        System.out.print("Reordered: "); printList(head);
    }
}
