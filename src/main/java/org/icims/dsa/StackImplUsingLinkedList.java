package org.icims.dsa;

/**
 * Stack implementation using LinkedList Data structure
 */
public class StackImplUsingLinkedList {
    static class  LLNode{
        int data;
        LLNode next;

        LLNode(int data){
            this.data=data;
            next=null;
        }
    }

    public static class Stack{
       public static  LLNode head;

        @Override
        public String toString() {
            return String.valueOf(head.data);
        }

        public static boolean isEmpty(){
            return head == null;
        }
        public static void push(int data){
            LLNode newNode = new LLNode(data);
            if(isEmpty()){
                head= newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top= head.data;
            head=head.next;
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
          return head.data;
        }

    }

    public static void main(String[] args) {
     Stack s = new Stack();
     s.push(1);
     s.push(2);
     s.push(3);
     s.push(4);
     System.out.println("Stack is: "+s);
     while(!s.isEmpty()){
         System.out.println(s.peek());
         s.pop();
     }
    }
}
