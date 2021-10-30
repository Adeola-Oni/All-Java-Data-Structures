package com.company.Queue;

public class CircularQueue {
    int[] arr;
    int beginningOfQueue;
    int endOfQueue;
    int size; //needed in a circular queue

    public CircularQueue(int size){
        this.arr = new int[size];
        this.size = size;
        this.endOfQueue = -1;
        this.beginningOfQueue = -1;
    }

    void enQueue(int value){
        if(isFull()){
            throw new IllegalStateException("This queue is full");
        }else if(beginningOfQueue == -1){
            beginningOfQueue++;
            endOfQueue++;
            arr[endOfQueue] = value;
        }else{
            if(endOfQueue+1 == size){
                endOfQueue = 0;
            }else{
                endOfQueue++;
            }
            arr[endOfQueue] = value;
        }
    }

    boolean isFull(){
        if(endOfQueue+1 == beginningOfQueue) {
            return true;
        }else if(beginningOfQueue== 0 && endOfQueue+1==size){
            return true;
        }else{
            return false;
        }
    }

    boolean isEmpty(){
        if(endOfQueue == -1){
            return true;
        }
        return false;
    }

    int Dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("The array is empty");
        }else {
            int item = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0;
            if(beginningOfQueue == endOfQueue){
                beginningOfQueue = endOfQueue = -1;
            }else if(beginningOfQueue + 1 == size){
                beginningOfQueue = 0;
            }else{
                beginningOfQueue++;
            }
            return item;
        }
    }

    int peek(){
        if(isEmpty()) {
            throw new IllegalStateException("The array is empty");
        }else{
            return arr[beginningOfQueue];
        }
    }

    void delete(){
        arr = null;
    }
}
