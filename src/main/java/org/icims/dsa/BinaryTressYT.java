package org.icims.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTressYT {
   static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree {
        static int index =-1;
        public Node buildTree(int nodes[]){
           index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode= new Node(nodes[index]);
            newNode.left= buildTree(nodes);
            newNode.right= buildTree(nodes);
            return newNode;
        }
    }
    //preorder traversal
    public static void preorder(Node root){
       if(root == null){
           //System.out.print(-1);
           return;
       }
       System.out.print(root.data+" ");
       preorder(root.left);
       preorder(root.right);
    }
    //Inorder traversal
    public static void inorder(Node root){
        if(root == null){
            //System.out.print(-1);
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    //Postorder traversal
    public static void postorder(Node root){
        if(root == null){
            //System.out.print(-1);
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }
    //Level order traversal
    public static void levelOrder(Node root){
       if(root == null){
           return;
       }
        Queue<Node> q= new LinkedList<>();
       q.add(root);
       q.add(null);
       while(!q.isEmpty()){
           Node currNode=q.remove();
           if(currNode == null){
               System.out.println();
               if(q.isEmpty()){
                   break;
               }else{
                   q.add(null);
               }
           }else{
               System.out.print(currNode.data+" ");
               if(currNode.left!=null){
                   q.add(currNode.left);
               }
               if(currNode.right !=null){
                   q.add(currNode.right);
               }
           }
       }
    }

    //count nodes
    public  static int countOfNodes(Node root){
       if(root == null){
           return 0;
       }
       int leftSubtree= countOfNodes(root.left);
       int rightSubtree= countOfNodes(root.right);
       return leftSubtree+ rightSubtree+ 1;
    }
    // sum of nodes
    public  static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum= sumOfNodes(root.left);
        int rightSum= sumOfNodes(root.right);
        return leftSum+ rightSum+ root.data;
    }
    //Height of a Tree
    public  static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight= height(root.left);
        int rightHeight= height(root.right);
        return Math.max(leftHeight,rightHeight) +1;
    }
    //diameter of a Tree - approach1 , time-complexity- O(N*N)
    public static int diamter(Node root){
       if(root == null){
           return 0;
       }
       int diameter1= diamter(root.left);
       int diamter2= diamter(root.right);
       int diamter3= height(root.left)+ height(root.right)+1;

       return Math.max(diamter3, Math.max(diameter1,diamter2));
    }
    static class TreeInfo{
       int ht;
       int diam;
       TreeInfo(int ht, int diam){
           this.ht=ht;
           this.diam= diam;
       }
    }
    // return diameter approach-2 - time complexity O(n)
    public static TreeInfo diamter2(Node root){
       if(root == null){
           return new TreeInfo(0,0);
       }
       TreeInfo left= diamter2(root.left);
        TreeInfo right= diamter2(root.right);
        int myHeight= Math.max(left.ht ,right.ht)+1;
        int diam1=left.diam;
        int diam2= right.diam;
        int diam3= left.ht + right.ht + 1;
        int myDiam= Math.max(Math.max(diam1,diam2), diam3);
        return new TreeInfo(myHeight,myDiam);
    }
    public static void main(String[] args) {
        int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        Node root= tree.buildTree(nodes);
        //preorder(root);
        //inorder(root);
        //postorder(root);
       // levelOrder(root);
       // System.out.println(countOfNodes(root));
       // System.out.println(sumOfNodes(root));
        // System.out.println(height(root));
        //System.out.println(diamter(root));
        System.out.println(diamter2(root).diam);
        //System.out.println(root.data);
    }
}
