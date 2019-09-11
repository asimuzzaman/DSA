public class Queue {
    private int[] element;
    private int front, rear, size, counter = 0;
    //counter counts total number of elements
    //size stores the maximum size of the queue

    public Queue() {
        element = new int[10];
        size = 10;
        front = 0;
        rear = -1;
    }

    //overriding constructor with size
    public Queue(int size) {
        element = new int[size];
        this.size = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int data) {
        if (isFull())
            System.out.println("Can't enqueue, Queue is full.");
        else {
            rear = (rear + 1) % size; //making the queue circular
            element[rear] = data;
            counter++;
        }
    }

    public void dequeue() {
        if (isEmpty())
            System.out.println("The Queue is empty.");
        else {
            front = (front + 1) % size; //making the front pointer circular
            counter--;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The Queue is empty.");
            return -1;
        }
        return element[front];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == size;
    }

    public int getSize() {
        return counter;
    }
}
