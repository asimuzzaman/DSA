//class for demonstrating Linked List
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(25);
        list.insert(2);
        list.insert(35);
        list.insert(9);
        list.insert(16);

        list.print();

        list.deleteValue(25);
        list.print();
        System.out.println("Size = " + list.getSize());

        list.deleteIndex(2);
        list.print();
        System.out.println("Size = " + list.getSize());
    }
}
