//tester method for BST class
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Height = " + tree.getHeight());
        tree.preorder();
        System.out.println();
        tree.postorder();
        System.out.println();
        tree.inorder();

        tree.delete(500);
        System.out.println();
        tree.inorder();
    }
}
