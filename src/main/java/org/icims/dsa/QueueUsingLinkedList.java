package org.icims.dsa;

public class QueueUsingLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    static class Queue{
       static Node head=null;
       static Node tail=null;
        public static boolean isEmpty(){
            return head == null && tail ==null;
        }
        // adding element to the queue - enqueue
        public static void add(int data){
            Node newNode= new Node(data);
            if(tail== null){
                tail = head = newNode;
                return;
            }
            tail.next=newNode;
            tail= newNode;
        }
        //removing element from queue- dequeue O(n)
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front= head.data;
            if(head == tail){
                tail= null;
            }
            head=head.next;
            return front;
        }
        // return the first element without removing from queue
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
    Queue queue= new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
        System.out.println("queue is:"+queue.peek());
    }
}
