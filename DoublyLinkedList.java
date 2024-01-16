package com.java;

import java.util.Locale;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class DoublyLinkedList {

    //Represent a node of the doubly linked list

    class Node {
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }

    //Represent the head and tail of the doubly linked list
    Node head, tail = null;

    //addNode() will add a node to the list
    public void addNode(PhonebookData data) {
        //Create a new node
        Node newNode = new Node(data);

        //If list is empty
        if (head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.previous = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    //display() will print out the nodes of the list
    public void display() {
        //Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    SortedSet search(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        Node current = head;
        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase(Locale.ROOT).strip()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.next;
        }
        return sortedSet;

    }

    public SortedSet searchTailFirst(String searchItem) {
        SortedSet sortedSet = new TreeSet();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty");
            return null;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.previous;
        }
        return sortedSet;
    }

    public static void main(String[] args) {

        DoublyLinkedList dList = new DoublyLinkedList();
        //Add nodes to the list
        dList.addNode(new PhonebookData("John Smith", "909-123-4576"));
        dList.addNode(new PhonebookData("Arnold Johynson", "622-234-2356"));
        dList.addNode(new PhonebookData("Harold Burns", "123-456-7890"));
        dList.addNode(new PhonebookData("Jackson Thomas", "555-333-7484"));
        dList.addNode(new PhonebookData("Jackson Mass", "555-322-7841"));
        dList.addNode(new PhonebookData("Allison Cat", "444-555-2234"));
        dList.addNode(new PhonebookData("Allison Cat", "444-555-2234"));


        Scanner sc = new Scanner(System.in);
        String searchItem;
        int choice = 0;
        System.out.println();
        System.out.println("Would you like to search from head or tail first? 1 for head and 2 for tail.");
        choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("\nStarting search from head test...");
            System.out.print("Enter search item (or q to quit):");
            searchItem = sc.nextLine();
            while (!searchItem.equals("q")) {
                SortedSet sortedSet = dList.search(searchItem);
                if (sortedSet.size() != 0) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                } else {
                    System.out.println("No search results found...");
                }

                System.out.print("\nEnter search item (or q to quit):");
                searchItem = sc.nextLine();
            }
        } else if (choice == 2) {
            System.out.println("\nStarting search from tail test...");
            System.out.print("Enter search item (or q to quit):");
            searchItem = sc.nextLine();
            while (!searchItem.equals("q")) {
                SortedSet sortedSet = dList.searchTailFirst(searchItem);
                if (sortedSet.size() != 0) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                } else {
                    System.out.println("No search results found...");
                }

                System.out.print("\nEnter search item (or q to quit):");
                searchItem = sc.nextLine();
            }
        }
    }
}



