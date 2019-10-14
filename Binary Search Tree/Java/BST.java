public class BST {
    private Node root;

    BST(int data) {
        root = new Node(data);
    }

    BST() {
        root = null;
    }

    public Node search(int key) {
        return recSearch(root, key);
    }

    //internal recursive search method
    private Node recSearch(Node root, int key) {
        if (root == null || root.data == key) //returning null means not found
            return root;

        if (key < root.data)
            return recSearch(root.left, key);

        return recSearch(root.right, key);
    }

    public void insert(int key) {
        root = recInsert(root, key);
    }

    //internal recursive insertion method
    //this method returns the parent root because Java methods are
    //call by value, not call by reference. So, to get the parent node we need to return
    private Node recInsert(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (key < node.data)
            node.left = recInsert(node.left, key);
        else if (node.data < key)
            node.right = recInsert(node.right, key);

        return node;
    }

    public void delete(int key) {
        root = recDelete(root, key);
    }

    //recursive method to delete node
    private Node recDelete(Node node, int key) {
        if (node == null)
            return node;

        if(node.data > key)
            node.left = recDelete(node.left, key);
        else if(node.data < key)
            node.right = recDelete(node.right, key);
        else {
            if(node.left == null) //to be deleted node has only right child
                node = node.right;
            else if(node.right == null) //to be deleted node has only right child
                node = node.left;
            else { //to be deleted node has two children
                /**
                 * 1. Delete current node
                 * 2. Replace the data of current node with inorder successor's data
                 * 3. Delete inroder successor
                 */

                //also this data will help us to find the inorder successor to delete
                node.data =  inOrderMin(node.right);

                //deleting inorder successor based on the value obtained in previous line
                node.right =  recDelete(node.right, node.data);
            }
        }

        return node;
    }

    //given the root of subtree, this method will find the data/key of inorder successor
    private int inOrderMin(Node node) {
        int min = node.data;

        while (node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    public void preorder() {
        recPreorder(root);
    }

    //internal recursive preorder method
    private void recPreorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            recPreorder(node.left);
            recPreorder(node.right);
        }
    }

    public void inorder() {
        recInorder(root);
    }

    //internal recursive inorder method
    private void recInorder(Node node) {
        if (node != null) {
            recInorder(node.left);
            System.out.print(node.data + " ");
            recInorder(node.right);
        }
    }

    public void postorder() {
        recPostorder(root);
    }

    //internal recursive postorder method
    private void recPostorder(Node node) {
        if (node != null) {
            recPostorder(node.left);
            recPostorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public int getHeight() {
        return recHeight(root);
    }

    private int recHeight(Node node) {
        if(node == null) //null means no tree or leaf
            return -1;

        return Math.max(recHeight(node.left), recHeight(node.right)) +1;
    }
}
