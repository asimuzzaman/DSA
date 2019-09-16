public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>(5);

        System.out.println(q.isEmpty());

        q.enqueue(65);
        q.enqueue(31);
        q.enqueue(7);

        System.out.println("Peek = " + q.peek());
        q.dequeue();
        q.enqueue(9);
        q.enqueue(21);
        q.enqueue(19);
        System.out.println("Peek = " + q.peek());
        System.out.println("Size = " + q.getSize());
    }
}
