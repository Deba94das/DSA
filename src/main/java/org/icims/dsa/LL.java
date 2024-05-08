package org.icims.dsa;

public class LL {
    public static final String SIZE_OF_LL = "size of LL";
    Node head;
    private int size;
    LL(){
        this.size= 0;
    }
 class Node{
         String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next= null;
            size++;
        }
    }
    int getSize(){
        return size;
    }
    // add - first
    public void addFirst(String data){
        Node newNode=new Node(data) ;
        if(head == null){
            head =newNode;
            return;
        }
        newNode.next=head;
        head= newNode;
    }
    //add - last
    public void addLast(String data){
        Node newNode= new Node(data);
        if(head ==null){
            head= newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }
    //delete first
    public void deleteFirst(){
     if(head == null){
         System.out.print("list is empty");
         return;
     }
     size--;
     head= head.next;
    }
    //delete last
    void deleteLast(){
        if(head == null){
            System.out.print("list is empty");
            return;
        }
        size--;
        if(head.next == null){
            head= null;
            return;
        }
        Node secondLastNode=head;
        Node lastNode= head.next;
        while(lastNode.next!=null){
            lastNode= lastNode.next;
            secondLastNode= secondLastNode.next;
        }
     secondLastNode.next=null;
    }

    //print list

    public void printList(){
        if(head == null){
            System.out.print("list is empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+ "->");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }
    public void reverseListIterator(){
        if(head == null || head.next == null){
            System.out.print("list is empty");
            return;
        }
        Node prevNode=head;
        Node currNode=head.next;
        while(currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;

            //update
            prevNode=currNode;
            currNode=nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
       Node newNode=  reverseRecursive(head.next);
        head.next.next= head;
        head.next=null;
        return newNode;
    }
// remove nth node from end
    public Node removeNthNodeFromEnd(Node head, int n){
        if(head.next == null){
            return null;
        }
        //calcualte the size
        int size=0;
        Node curr=head;
        while(curr!=null){
            curr= curr.next;
            size++;
        }
        if(size == n){
            return head.next;
        }
        if(n> size){
            return head;
        }

        //delete the nth node
        int indexToSearch=size-n;
        int i=1;
        Node prev=head;
        while(i<indexToSearch){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
    }
    //Check LinkedList is pallindrome or not
    public boolean isLLPallindrome(Node head){
        if(head ==null || head.next ==null){
            return true;
        }
        Node firstHalfEnd= findMiddle(head);// return the 1st half end
        Node secondHalfStart= reverseSecondHalf(firstHalfEnd.next);
        Node firstHalfStart= head;
        while(secondHalfStart!=null){
            if(secondHalfStart.data != firstHalfStart.data){
                return false;
            }
            firstHalfStart= firstHalfStart.next;
            secondHalfStart= secondHalfStart.next;
        }
    return true;
    }

    private Node reverseSecondHalf(Node head) {
        Node prev= null;
        Node curr=head;
        while(curr !=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private Node findMiddle(Node head) {
        Node pointer1 = head;// fast pointer
        Node pointer2=head; // slow pointer
        while(pointer1.next !=null && pointer1.next.next!=null){
            pointer1= pointer1.next.next;
            pointer2= pointer2.next;
        }
        return pointer2;
    }

    public static void main(String[] args) {
        LL list=new LL();
        list.addFirst("a");
        list.addFirst("b");
        System.out.println(SIZE_OF_LL + ":" +list.getSize());
        list.addLast("b");
        list.printList();
        System.out.println(SIZE_OF_LL + ":" +list.getSize());
        System.out.println("========");
        //list.reverseListIterator();
        list.printList();
        System.out.println("------");
        list.head= list.reverseRecursive(list.head);
        list.printList();
        //list.deleteFirst();
        list.printList();
        System.out.println(SIZE_OF_LL + ":" +list.getSize());
        //list.deleteLast();
        list.printList();
        System.out.println(SIZE_OF_LL + ":" +list.getSize());

//        list.head = list.removeNthNodeFromEnd(list.head, 4);
//        list.printList();
        System.out.println("Is linked list pallindrom? "+list.isLLPallindrome(list.head));
    }
}
