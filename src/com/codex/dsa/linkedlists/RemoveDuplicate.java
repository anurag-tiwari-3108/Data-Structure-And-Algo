package com.codex.dsa.linkedlists;

import java.util.HashSet;

// Remove Duplicate with and without temp buffer
public class RemoveDuplicate {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // With temp buffer
    public static void removeDuplicates(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node prev = null, curr = head;
        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    // Without temp buffer
    public static void removeDuplicatesNoBuffer(Node head) {
        Node curr = head;
        while (curr != null) {
            Node runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(3);
        System.out.print("Original: "); printList(head);
        removeDuplicates(head);
        System.out.print("After removing duplicates: "); printList(head);
    }
}
