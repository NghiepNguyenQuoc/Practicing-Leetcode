package com.nghiepnguyen.LinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    public Node delete(Node head, int key) {
        if (head == null) {
            return null;
        }
        if (head.data == key) {
            head = head.next;
            return head;
        }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public Node deleteAtPosition(Node head, int position) {
        if (head == null) {
            return null;
        }
        if (position == 0) {
            return head.next;
        }

        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null)
            return null;
        Node next = temp.next.next;
        temp.next = next;
        return head;
    }

    public int getCount(Node head) {
        //add code here.
        int count = 0;
        if (head == null) {
            return 0;
        }
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public int getCount2(Node node) {
        //add code here.
        if (head == null) {
            return 0;
        }
        if (node == null)
            return 0;
        return getCount2(node.next) + 1;
    }

    public boolean search(int x) {
        if (head == null)
            return false;
        Node temp = head;
        for (; temp != null; ) {
            if (temp.data == x)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean search2(Node head, int x) {
        if (head == null)
            return false;

        if (head.data == x)
            return true;

        return search2(head.next, x);
    }

    int getNthFromLast(Node head, int n) {
        // Your code here
        if (n <= 0)
            return -1;
        int lenght = 0;
        Node temp = head;
        for (; temp != null; ) {
            lenght++;
            temp = temp.next;
        }
        temp = head;

        for (int i = lenght; temp != null; i--) {
            if (i == n) {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }

    boolean isPalindrome(Node head) {
        //Your code here
        //Your code here
        List<Integer> array = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            array.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        int i = array.size() - 1;
        while (temp != null) {
            if (temp.data != array.get(i)) {
                return false;
            }
            i--;
            temp = temp.next;
        }
        return true;
    }

    Node removeDuplicates(Node head) {
        // Your code here
        Node temp = head;
        Node temp2;
        while (temp != null) {
            temp2=temp;
            while(temp2.next!=null){
                if(temp.data==temp2.next.data){
                    temp2.next=temp2.next.next;
                }else{
                    temp2=temp2.next;
                }
            }
            temp=temp.next;
        }
        return head;
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
        linkedList.addTail(new Node(3));
        linkedList.addTail(new Node(4));
        linkedList.addTail(new Node(5));
        linkedList.addTail(new Node(5));
        linkedList.addTail(new Node(3));
        linkedList.addTail(new Node(6));
//        linkedList.addTail(new Node(2));
//        linkedList.addTail(new Node(2));

//        linkedList.deleteAtPosition(0);
        linkedList.removeDuplicates(linkedList.head);
        linkedList.print();
//        System.out.print("\n\n" + linkedList.search2(linkedList.head, 4));

    }
}
