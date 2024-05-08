package org.icims.dsa;

public class QueueUsingArray {

    static class Queue{
        static int[] arr;
        static int size;
        static int rear;
        Queue(int size){
            arr= new int[size];
            rear= -1;
            this.size=size;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }

        // adding element to the queue - enqueue
        public static void add(int num){
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear]=num;
        }
        //removing element from queue- dequeue O(n)
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int front= arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--; // we shifted all elements to previous place so our rear also need to shift prevoius place
            return front;
        }
        // return the first element without removing from queue
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
    Queue queue= new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
