package com.company.Queue;
import java.util.Arrays;
public class Queue_Array {
    int[] arr;
    int endOfQueue;
    int beginningOfQueue;

    public Queue_Array(int size){
        //Time complexity for creating a Queue with an array is O(1), space O(N)
        this.arr = new int[size];
        this.endOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Queue of size "+ size +" successfully created");
    }

    void enQueueArr(int value){
        //Time complexity for inserting into an Array_Queue is O(1), space O(1)
        if(isFullArr()){
            throw new IllegalStateException("The Queue is full");
        }else if(isEmptyArr()){
            beginningOfQueue = 0;
            endOfQueue++;
            arr[endOfQueue] = value;
        }else{
            endOfQueue++;
            arr[endOfQueue] = value;
        }
    }

    int dequeueArr(){
        //Time complexity for dequeue an Array_Queue is O(1), space O(1)
        if(isEmptyArr()){
            throw new IllegalStateException("The Queue is empty");
        }else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > endOfQueue) {
                beginningOfQueue = endOfQueue = -1;
            }
            return result;
        }
    }

    int peekArr(){
        if(isEmptyArr()){
            throw new IllegalStateException("The Queue is empty");
        }else {
            return arr[beginningOfQueue];
        }
    }

    boolean isEmptyArr(){
        if(beginningOfQueue == -1 || (beginningOfQueue == arr.length)){
            return true;
        }
        return false;
    }

    boolean isFullArr(){
        if((arr.length - 1) == endOfQueue){
            return true;
        }
        return false;
    }

    void deleteArr(){
        arr = null;
    }
}
