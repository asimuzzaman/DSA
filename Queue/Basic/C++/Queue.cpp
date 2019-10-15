#include<iostream>

using namespace std;

class Queue {
    private:
        int *element;
        int front, rear, size, counter = 0;
        //counter counts total number of elements
        //size stores the maximum size of the queue

    public:
        Queue() {
            element = new int[10];
            size = 10;
            front = 0;
            rear = -1;
        }

        //overriding constructor with size
        Queue(int size) {
            element = new int[size];
            this->size = size;
            front = 0;
            rear = -1;
        }

        void enqueue(int data) {
            if(isFull())
                cout << "Can't enqueue, Queue is full." << endl;
            else {
                rear = (rear + 1) % size; //making the queue circular
                element[rear] = data;
                counter++;
            }
        }

        void dequeue() {
            if(isEmpty())
                cout << "The Queue is empty." << endl;
            else {
                front = (front + 1) % size; //making the front pointer circular
                counter--;
            }
        }

        int peek() {
            if(isEmpty()){
                cout << "The Queue is empty." << endl;
                return -1;
            }   
            return element[front];
        }

        bool isEmpty() {
            return counter == 0;
        }

        bool isFull() {
            return counter == size;
        }

        int getSize() {
            return counter;
        }

        //printer function
        void print() {
            for (int i = front; i != rear; i = (i+1)%size)
            {
                cout << element[i] << " ";
            }
            cout << endl;
        }
};

int main() {
    Queue q(5);

    cout << q.isEmpty();

    q.enqueue(65);
    q.enqueue(31);
    q.enqueue(7);

    cout << "Peek = " << q.peek() << endl;
    q.dequeue();
    q.enqueue(9);
    q.enqueue(21);
    q.enqueue(19);

    cout << "Peek = " << q.peek() << endl;
    cout << "Size = " << q.getSize() << endl;

    q.print();
    return 0;
}