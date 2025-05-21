package com.codex.dsa.linkedlists;

import java.util.PriorityQueue;

public class MergeKSortedList {
    static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Node node : lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        if (pq.isEmpty()) return null;
        Node res = new Node(pq.poll());
        Node resultHead = res;
        while (!pq.isEmpty()) {
            res.next = new Node(pq.poll());
            res = res.next;
        }
        return resultHead;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node l1 = new Node(1); l1.next = new Node(4); l1.next.next = new Node(5);
        Node l2 = new Node(1); l2.next = new Node(3); l2.next.next = new Node(4);
        Node l3 = new Node(2); l3.next = new Node(6);
        Node[] lists = new Node[] {l1, l2, l3};
        MergeKSortedList merger = new MergeKSortedList();
        Node merged = merger.mergeKLists(lists);
        printList(merged);
    }
}
