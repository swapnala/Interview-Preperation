/**
 * Created by swapnal on 9/24/2017.
 */
public class LinkedList{
    Node head;

    public static void main(String[] args){
        LinkedList linkedList= new LinkedList();
        Node head = new Node(2);
        linkedList.head= head;
        linkedList.addAtBeginning(1);
        linkedList.addAtEnd(4);
        linkedList.afterNode(head.next,3);
        linkedList.deleteNode(2);
        linkedList.deleteNodeAtPosition(0);

        System.out.println(linkedList.lengthOfList());
        System.out.println(linkedList.search(3));
        linkedList.printList(linkedList.head);
        linkedList.printMiddle();
        linkedList.printMiddleOnePtr();
    }

    //Complexity O(n)
    private void printList(Node head){
        System.out.println("====List====");

        while(head!=null ){
            System.out.println(head.data);
            head = head.next;
        }
    }

    //Complexity O(1)
    private void addAtBeginning(int data){
        Node head = this.head;
        Node node = new Node(data);
        node.next=head;
        this.head=node;
    }

    private void afterNode(Node prevNode, int data){

        Node temp = new Node(data);
        temp.next = prevNode.next;
        prevNode.next=temp;

    }

    //Complexity O(n)
    //Can be reduced to O(1) if a tail node is created which keeps track of the last element of the list.
    private void addAtEnd(int data){
        Node head = this.head;
        while(head.next!=null){
            head = head.next;
        }
        head.next = new Node(data);
    }

    private void deleteNode(int data){
        Node head = this.head;
        Node prev = null;
        if(head!=null && head.data == data){
            head = head.next;
            return;
        }
        while(head!=null && head.data!=data){
            prev = head;
            head = head.next;
        }
        if(head==null){
            return;
        }
        prev.next=head.next;
        return;
    }

    //considering indices from 0
    private void deleteNodeAtPosition(int index){
        Node temp = this.head;
        Node prev = null;
        int currentIndex = 0;
        if(index==0 && temp!=null){
            temp = temp.next;
            this.head=temp;
            return;
        }
        while(currentIndex!=index && temp!=null){
            prev = temp;
            temp = temp.next;
            currentIndex++;
        }
        if(temp!=null){
            prev.next=temp.next;
        }
    }

    private int lengthOfList(){
        int length=0;
        Node head = this.head;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }

    private int lengthRecursive(Node head){
        if(head ==null){
            return 0;
        }
        return 1+ lengthRecursive(head.next);
    }

    private int search(int data){
        Node head = this.head;
        int loc = 0;
        while(head !=null && head.data!=data){
            head = head.next;
            loc++;
        }
        if(head!=null){
            return loc;

        }
        return -1;

    }

    private void printMiddle(){
        Node slow = this.head;
        Node fastPtr = this.head;
        while(fastPtr!=null && fastPtr.next!=null){
            slow = slow.next;
            fastPtr = fastPtr.next.next;
        }
        if(slow!=null){
            System.out.println("Middle:"+slow.data);
        }
    }

    private void printMiddleOnePtr(){
        Node mid = this.head;
        Node head = this.head;
        int count=0;
        while(head!=null ){
            if((count & 1)==1)
                mid = mid.next;
            ++count;
            head = head.next;
        }
        if(mid!=null){
            System.out.println("Middle:"+mid.data);
        }
    }

     private static class Node {
        int data;
        Node next;

        Node(){
            data=0;
            next=null;
        }

        Node(int d){
            data=d;
            next=null;
        }
    }

}
