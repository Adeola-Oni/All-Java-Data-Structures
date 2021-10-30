package com.company.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {
    BinaryNode root;

    public BinaryTreeLinkedList(){
        this.root = null;
    }

    //DFS traversals are preorder, Inorder and postorder
    //BFS traversal is level-order traversal

    //preorder Root, left and right
    void preorder(BinaryNode node) {
        if(node == null){
            return;
        }
        System.out.println(node.value);
        preorder(node.left_pointer);
        preorder(node.right_pointer);

    }

    //Inorder left, Root,  and right
    void Inorder(BinaryNode node) {
        if(node == null) {
            return;
        }
        Inorder(node.left_pointer);
        System.out.println(node.value);
        Inorder(node.right_pointer);

    }

    //postorder left, right and Root
    void postorder(BinaryNode node) {
        if(node == null) {
            return;
        }
        postorder(node.left_pointer);
        postorder(node.right_pointer);
        System.out.println(node.value);

    }

    //levelorder traverses by levels i.e height
    void levelorder(BinaryNode node) {
        //step 1: create a queue that you will be use
        // to store the elements. I will be using a linkedlist queue
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value);
            if(presentNode.left_pointer != null){
                queue.add(presentNode.left_pointer);
            }

            if(presentNode.right_pointer != null){
                queue.add(presentNode.right_pointer);
            }
        }
    }


    public void search(String value){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.value == value){
                System.out.println("Found "+ value +" in this binary tree");
                return;
            }else{
                if(presentNode.left_pointer != null){
                    queue.add(presentNode.left_pointer);
                }

                if(presentNode.right_pointer != null){
                    queue.add(presentNode.right_pointer);
                }
            }
        }

        System.out.println("could not find "+ value+ " in this binary tree");

    }

    public void Insert(String value){
        BinaryNode newnode = new BinaryNode();
        newnode.value = value;
        if(root == null){
            root = newnode;
            System.out.println("new node inserted");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        while(!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            if(currentNode.left_pointer == null){
                currentNode.left_pointer = newnode;
                return;
            }else if(currentNode.right_pointer == null){
                currentNode.right_pointer = newnode;
                return;
            }else{
                queue.add(currentNode.left_pointer);
                queue.add(currentNode.right_pointer);

            }
        }

    }

    public void Delete(String value){
        //find node
        //find deepest node
        //set deepest node to currentNode
        //delete the deepest node
    }


}















