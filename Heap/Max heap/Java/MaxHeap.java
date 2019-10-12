public class MaxHeap {
    private int heap[]; //array for storing heap data
    private int size = 0;

    MaxHeap(int capacity) {
        heap = new int[capacity];
    }

    //given the parent index, it will return the left child's index
    private int leftChild(int parent) {
        return 2*parent + 1;
    }
    //given the parent index, it will return the right child's index
    private int rightChild(int parent) {
        return 2*parent + 2;
    }

    //given the child's index, it will return its parent's index
    private int getParent(int child) {
        return (child-1)/2;
    }

    //checking boundary to ensure left child's existence
    private boolean hasLeftChild(int parent) {
        return leftChild(parent) < size;
    }

    //checking boundary to ensure right child's existence
    private boolean hasRightChild(int parent) {
        return rightChild(parent) < size;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insert(int data) {
        heap[size] = data; //inserting new data at the end of array
        size++;
        heapifyUp(); //fixing the array from bottom to top
    }

    //returning maximum element from top
    public int peek() {
        return heap[0];
    }

    public int remove() {
        int data = heap[0]; //removing first element
        heap[0] = heap[size-1]; //bringing last element to first
        size--;
        heapifyDown(); //fixing the heap from top to bottom

        return data;
    }

    private void heapifyUp() {
        int i = size-1; //starts from last element

        while(i > 0) { //moving up unless it's root node
            if (heap[getParent(i)] > heap[i]) //heap property is Ok so stop
                break;
            else
                swap(getParent(i), i); //not ok, so swap between parent and child

            i = getParent(i); //moving i to parent index
        }
    }

    private void heapifyDown() {
        int i = 0, maxChild;

        while(hasLeftChild(i)) { //as Heap is complete binary tree, having right child ensures having left child
            maxChild = leftChild(i);

            //if there is a right child and it is greater than left. then change the maximum child
            if (hasRightChild(i) && heap[rightChild(i)] > heap[maxChild])
                maxChild = rightChild(i);

            if (heap[i] < heap[maxChild])
                swap(i, maxChild);
            else
                break;

            i = maxChild; //moving the iteration towards maximum valued child
        }
    }

    public void print()
    {
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" Parent : " + heap[i] + " Left child : " +
                    heap[2 * i + 1] + " Right child :" + heap[2 * i + 2]);
            System.out.println();
        }
    }
}
