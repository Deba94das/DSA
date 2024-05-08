package org.icims.dsa;

public class CircularQueueUsingArray {

    static class Queue{
        static int[] arr;
        static int size;
        static int rear = -1;
        static int front= -1;
        Queue(int size){
            arr= new int[size];
            this.size=size;
        }
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }


        // adding element to the queue - enqueue
        public static void add(int num){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1){
                front=0;
            }
            rear = (rear+1)%size;
            arr[rear]=num;
        }
        //removing element from queue- dequeue O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            int result= arr[front];
            // single element c
            if(rear == front){
                rear =front = -1;
            }else{
                front =(front+1)%size;
            }
            return result;
        }
        // return the first element without removing from queue
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
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
