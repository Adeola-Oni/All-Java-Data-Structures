package com.company.Queue;

public class LinkedList {
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public Node LinkedList(int nodeValue){
        head = new Node();
        Node newnode = new Node();
        newnode.value = nodeValue;
        newnode.next = null;
        head = newnode;
        tail = newnode;
        size++;
        return head;
    }

    void add(int value, int location){
        Node newnode = new Node();
        newnode.value = value;
        if(head == null){
            LinkedList(value);
        }
        else if(location == 0){

        }
    }

    void isFull(){

    }

    void isEmpty(){

    }


}
