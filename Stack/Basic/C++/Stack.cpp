#include<iostream>

using namespace std;

class Stack {
    private:
        int *element;
        int top, capacity;
    
    public:
        Stack() {
            element = new int[10];
            top = -1;
            capacity = 10;
        }

        //overriding constructor with size
        Stack(int size) {
            element = new int[size];
            top = -1;
            capacity = size;
        }

        void push(int data) {
            if(!isFull()) //insert data if stack is not full
                element[++top] = data;
            else
                cout << "Can't push data, stack is full." << endl;
        }

        //return the top data from stack without removing
        int peek() {
            return element[top];
        }

        //pop element from top of the stack
        void pop() {
            if(!isEmpty())
                top--;
            else
                cout << "Stack is already empty." << endl;
        }

        bool isEmpty() {
            return (top == -1);
        }

        bool isFull() {
            return (top == capacity-1);
        }

        int getLength() {
            return top + 1;
        }

        //printer method
        void print() {
            if (!isEmpty()) {
                for (int i = 0; i <= top; i++)
                    cout << element[i] << " ";
            }
            cout << endl;
        }

        ~Stack() {

        }
};

int main() {
    Stack st(3);

    st.push(4);
    st.push(6);
    st.push(1);
    st.push(0);

    cout << st.peek() << endl;

    st.pop();

    st.print();

    return 0;
}