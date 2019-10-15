#include<iostream>

using namespace std;

class MaxHeap {
    private:
        int *heap; //array for storing heap data
        int size = 0;

        //given the parent index, it will return the left child's index
        int leftChild(int parent) {
            return 2*parent + 1;
        }
        //given the parent index, it will return the right child's index
        int rightChild(int parent) {
            return 2*parent + 2;
        }

        //given the child's index, it will return its parent's index
        int getParent(int child) {
            return (child-1)/2;
        }

        //checking boundary to ensure left child's existence
        bool hasLeftChild(int parent) {
            return leftChild(parent) < size;
        }

        //checking boundary to ensure right child's existence
        bool hasRightChild(int parent) {
            return rightChild(parent) < size;
        }

        void swap(int index1, int index2) {
            int temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }

        void heapifyUp() {
            int i = size-1; //starts from last element

            while(i > 0) { //moving up unless it's root node
                if (heap[getParent(i)] < heap[i]) //heap property is Ok so stop
                    break;
                else
                    swap(getParent(i), i); //not ok, so swap between parent and child

                i = getParent(i); //moving i to parent index
            }
        }

        void heapifyDown() {
            int i = 0, minChild;

            while(hasLeftChild(i)) { //as Heap is complete binary tree, having right child ensures having left child
                minChild = leftChild(i);

                //if there is a right child and it is smaller than left. then change the minimum child
                if (hasRightChild(i) && heap[rightChild(i)] < heap[minChild])
                    minChild = rightChild(i);

                if (heap[i] < heap[minChild])
                    swap(i, minChild);
                else
                    break;

                i = minChild; //moving the iteration towards minimum valued child
            }
        }

    public:
        MaxHeap(int capacity) {
            heap = new int[capacity];
        }

        void insert(int data) {
            heap[size] = data; //inserting new data at the end of array
            size++;
            heapifyUp(); //fixing the array from bottom to top
        }

        //returning minimum element from top
        int peek() {
            return heap[0];
        }

        int remove() {
            int data = heap[0]; //removing first element
            heap[0] = heap[size-1]; //bringing last element to first
            size--;
            heapifyDown(); //fixing the heap from top to bottom

            return data;
        }

        void print()
        {
            for (int i = 0; i < size / 2; i++) {
                cout << " Parent : " << heap[i] << " Left child : " << heap[2 * i + 1] << " Right child :" << heap[2 * i + 2];
                cout << endl;
            }
        }
};

int main() {
    MaxHeap maxHeap(15);

    maxHeap.insert(5);
    maxHeap.insert(3);
    maxHeap.insert(17);
    maxHeap.insert(10);
    maxHeap.insert(84);
    maxHeap.insert(19);
    maxHeap.insert(6);
    maxHeap.insert(22);
    maxHeap.insert(9);

    maxHeap.print();
    cout << "The Min val is " << maxHeap.remove() << endl;
    maxHeap.print();

    return 0;
}