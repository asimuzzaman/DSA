public class LinkedList {
    private Node head, tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(int data) {
        //creating new node with current data
        Node temp = new Node(data);

        //checking whether first node or not
        if(head == null) {
            head = temp;
            tail = temp; //both first and last element
            temp.next = null;
        } else {
            tail.next = temp; //tail's 'next' points to new node
            tail = temp; //new node becomes tail
        }
        size++;
    }

    public void print() {
        Node travel = head; //a pointer for traversal

        //traverse until the LinkedList ends
        while (travel != null) {
            System.out.print(travel.data +" ");

            //move to next node
            travel = travel.next;
        }
    }

    //method to delete node by value
    public void deleteValue(int data) {
        Node travel = head; //a pointer for traversal
        Node prev = null; //to memorize previous node

        //if non-empty list AND first node is the desired node
        if (travel != null && travel.data == data) {
            head = travel.next; //un-linking first node
            size--;
            System.out.println("Node deleted.");

        } else {
            while (travel != null) {
                //node with matching data found
                if (travel.data == data) {
                    prev.next = travel.next; //remapping the link to next
                    size--;
                    System.out.println("Node deleted.");
                    break;
                }

                prev = travel; //memorizing previous node
                travel = travel.next; //move to next node
            }
        }
    }
    //method to delete node by index
    public void deleteIndex(int index) {
        Node travel = head; //a pointer for traversal
        Node prev = null; //to memorize previous node
        int counter = 0; //for finding index

        //if non-empty list AND first node is the desired node
        if (travel != null && index == 0) {
            head = travel.next; //un-linking first node
            size--;
            System.out.println("Node# " +index+" deleted.");

        } else {
            while (travel != null) {
                //node with matching data found
                if (counter == index) {
                    prev.next = travel.next; //remapping the link to next
                    size--;
                    System.out.println("Node "+index+" deleted.");
                    break;
                }

                prev = travel; //memorizing previous node
                travel = travel.next; //move to next node
                counter++;
            }
        }
    }

    public int getSize() {
        return size;
    }
}
