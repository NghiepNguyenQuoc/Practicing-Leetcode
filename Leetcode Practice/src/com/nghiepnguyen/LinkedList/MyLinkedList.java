package com.nghiepnguyen.LinkedList;

public class MyLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public void addTail(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = n;
        }
    }

    public void addHead(Node n) {
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    public void addAfter(Node cur, Node n) {

        if (cur == null)
            return;
        n.next = cur.next;
        cur.next = n;
    }

    public void addBefore(Node cur, Node n) {
        if (cur == null) {
            return;
        }
        Node prev = head;
        while (prev.next.data != cur.data) {
            prev = prev.next;
        }
        System.out.print(prev.data);
        n.next = cur;
        prev.next = n;
    }

    public void print() {
        Node n = head;
        while (n != null) {
            if (n.next == null)
                System.out.print(n.data);
            else
                System.out.print(n.data + "->");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addHead(new Node(4));
        linkedList.addHead(new Node(3));
        linkedList.addHead(new Node(2));
        linkedList.addHead(new Node(1));

        linkedList.addAfter(linkedList.head.next.next, new Node(5));


        linkedList.print();
    }
}
