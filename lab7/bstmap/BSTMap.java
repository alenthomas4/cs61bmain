package bstmap;
import edu.princeton.cs.algs4.BST;
import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.Set;

/*
 BST Map, with a bound on K, such that K must extend comparable.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    /*
        Root node
     */
    private Node root;

    /*
    Abstract Node Structure: Contains a key, value pair.

    Key -> Value
    Pointer to left,
    Pointer to right
    Size (Cached)

     */
    private class Node {

        private K key;
        private V value;

        private Node left;
        private Node right;
        private int size;

        /*
        Consturctor for a node.
         */
        public Node(K key, V val, int size) {
            this.key = key;
            this.value = val;
            this.size = size;
        }
    }

    /*

     */
    public BSTMap() {
    }

    @Override
    public void clear() {
        if ( !isEmpty() ) {
            root = null;
        }


    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        return get(key) != null;

    }

    /*
    Primary get function - equivalent to search
    usage: get(3) -> finds and gets key 3, returns the value.
     */
    @Override
    public V get(K key) {
        return find(root, key);
    }

    /**
     * Helper function find -> implements the search algorithm
     *
     * @param T
     * @param key
     * @return Value V -> returns the value of the Node specified by the key
     */
    private V find(Node T, K key) {
        // If Node T is null, return null
        if (T == null) {
            return null;
        }
        //
        int cmp = key.compareTo(T.key);
        if (cmp == 0) {
            return T.value;
        }
        else if (cmp < 0) {
            return find(T.left, key);
        }
        else {  return find(T.right, key);
        }



    }


    /*
        Returns the size of the tree, from the root.
     */

    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public int size() {
        return size(root);
    }

    /*
        Returns the size of a node n

     */
    private int size(Node n) {
        if (n == null) {
        return 0;
        } else {
            return n.size;
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = insert(root, key, value);
    }

    private Node insert(Node T, K key, V value) {
        if (T == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(T.key);
        if (cmp < 0 ) {
            T.left = insert(T.left, key, value);
        } else if (cmp > 0) {
            T.right = insert(T.right, key, value);
        }
        return T;
    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    public static void main(String[] args) {
        BSTMap<String, Integer> map = new BSTMap<>();
        map.put("a", 1);
        map.put("c", 3);
        map.put("b", 2);
        System.out.println(map.containsKey("c"));
        System.out.println("is empty: " + map.isEmpty());
        map.clear();
        System.out.println(map.containsKey("c"));

    }
}
