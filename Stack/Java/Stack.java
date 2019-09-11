public class Stack {
    private int[] element;
    private int top;

    public Stack() {
        element = new int[10];
        top = -1;
    }

    //overriding constructor with size
    public Stack(int size) {
        element = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (!isFull()) //insert data if stack is not full
            element[++top] = data;
        else
            System.out.println("Can't push data, stack is full.");
    }

    //return the top data from stack without removing
    public int top() {
        return element[this.top];
    }

    //pop element from top of the stack
    public void pop() {
        if (!isEmpty())
            top--;
        else
            System.out.println("Stack is already empty.");
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == element.length - 1);
    }

    public int getLength() {
        return top + 1;
    }

    //printer method
    public void print() {
        if (!isEmpty()) {
            for (int i=0;i<=top;i++)
                System.out.print(element[i]+" ");
        }
        System.out.println();
    }
}
