package com.company.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinarySearchNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    BinarySearchNode insert(BinarySearchNode node, int value){
        if(node == null){
            BinarySearchNode newnode = new BinarySearchNode();
            newnode.value = value;
            return newnode;
        }else if (node.value <= value){
            node.right = insert(node.right, value);
            return node.right;
        }else{
            node.left = insert(node.left, value);
            return root.left;
        }

    }

    void preorder (BinarySearchNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value + "  ");
        preorder(node.left);
        preorder(node.right);
    }

    void Inorder (BinarySearchNode node){
        if(node == null){
            return;
        }
        preorder(node.left);
        System.out.println(node.value + "  ");
        preorder(node.right);
    }

    void postorder (BinarySearchNode node){
        if(node == null){
            return;
        }
        preorder(node.left);
        preorder(node.right);
        System.out.println(node.value + "  ");
    }

    void levelorder (BinarySearchNode node){
        Queue<BinarySearchNode> queue = new LinkedList<BinarySearchNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            BinarySearchNode currNode = queue.remove();
            System.out.println(currNode.value + "  ");
            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }
        }

    }

    BinarySearchNode minimumNode(BinarySearchNode root){
        if(root.left == null){
            return root;
        }
        return minimumNode(root.left);
    }

    BinarySearchNode successorNode(BinarySearchNode root){
        if(root.left != null && root.right != null){
            BinarySearchNode temp = root;
            BinarySearchNode minNodeForRight = minimumNode(temp.right);
            root.value = minNodeForRight.value;
            root.right = deleteNode(root.right, minNodeForRight.value);
        }
        return minimumNode(root.left);
    }

    BinarySearchNode deleteNode(BinarySearchNode root, int value){
        if(root == null){
            throw new IllegalStateException("The tree is empty");
        }else{
            if(value > root.value){
                root.right = deleteNode(root.right, value);
            }else if( value < root.value){
                root.left = deleteNode(root.left, value);
            }else{
                if(root.left != null && root.right != null){
                    BinarySearchNode temp = root;
                    BinarySearchNode minNodeForRight = minimumNode(temp.right);
                    root.value = minNodeForRight.value;
                    root.right = deleteNode(root.right, minNodeForRight.value);
                }else if(root.left != null){
                    root = root.left;
                }
                else if(root.right != null){
                    root = root.right;
                }else{
                    root = null;
                }
            }
        }
        return minimumNode(root.left);
    }



}

















