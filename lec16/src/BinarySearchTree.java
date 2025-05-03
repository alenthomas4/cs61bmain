public class BinarySearchTree<Key extends Comparable<Key>> {
    private class BST {
        private Key key;
        private BST left;
        private BST right;

        public BST(Key key, BST left, BST right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public BST(Key key) {
            this.key = key;
        }
    }

    private BST root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // Move the find method outside the inner class
    public BST find(BST T, Key key) {
        if (T == null) {
            return null;
        }
        if (key.equals(T.key)) {
            return T;
        }
        else if (key < T.key) {
            return find(T.left, key);
        }
        else {
            return find(T.right, key);
        }
    }

    // Public wrapper method
    public BST find(Key key) {
        return find(root, key);
    }
}