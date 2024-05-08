package org.icims.dsa;

import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    //delete a Node
    public static Node delete(Node root, int val){
        if(root.data >val){
            root.left= delete(root.left,val);
        }else if(root.data<val){
            root.right= delete(root.right,val);
        }else{// root.data == val
            //case -1
            if(root.left == null && root.right==null){
                return null;
            }
            //case- 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //case-3
           Node inorderSuccessor= inOrderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right= delete(root.right,inorderSuccessor.data);
        }
        return root;
    }

    private static Node inOrderSuccessor(Node root) {
    while(root.left !=null){
        root= root.left;
    }
    return root;
    }

    private static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //insert node in BST
    private static Node insertNode(Node root,int value) {
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(root.data>value){
            root.left= insertNode(root.left,value);
        }else{
            root.right= insertNode(root.right,value);
        }
        return root;
    }
    // Search Node in BST- O(H)
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data>key){
            return search(root.left,key);
        }else if(root.data == key){
            return  true;
        }else{
            return search(root.right,key);
        }
    }
    // print the node
    public static void printInRange(Node root,int x,int y){
        if(root == null){
            return;
        }
        //case1, 4
        if(root.data >=x && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        }
        //case 2
        else if (root.data >= y) {
            printInRange(root.left,x,y);
        }else{
            printInRange(root.right,x,y);
        }
    }
    // print roo to leaf nodes
    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        // leaf node
        if(root.left == null && root.right ==null){
            printPath(path);
        }else{
            printRootToLeaf(root.left,path);
            printRootToLeaf(root.right,path);
        }
        path.remove(path.size()-1);
    }

    private static void printPath(ArrayList<Integer> path) {
        for(int i=0;i< path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int values[]= {8,5,6,3,10,11,14};
        Node root =null;
        for(int i=0;i<values.length;i++){
            root= insertNode(root,values[i]);
        }
        inorder(root);
        System.out.println();

        /*if(search(root,7)){
            System.out.println("Key found");
        }else{
            System.out.println("Key not found");
        }*/
        //delete(root,1);
        printInRange(root,6,10);
        System.out.println("==============");
        printRootToLeaf(root,new ArrayList<>());
        //inorder(root);
    }
}
