import java.util.LinkedList;
import java.util.Stack;

/**
 * Red-Black Tree implementation with a Node inner class for representing the nodes of the tree.
 * Currently, this implements a Binary Search Tree that we will turn into a red black tree by
 * modifying the insert functionality. In this activity, we will start with implementing rotations
 * for the binary search tree insert algorithm.
 */
public class RedBlackTree<T extends Comparable<T>> {

    /**
     * This class represents a node holding a single value within a binary tree.
     */
    protected static class Node<T> {
        public T data;
        // The context array stores the context of the node in the tree:
        // - context[0] is the parent reference of the node,
        // - context[1] is the left child reference of the node,
        // - context[2] is the right child reference of the node.
        // The @SupressWarning("unchecked") annotation is used to supress an unchecked
        // cast warning. Java only allows us to instantiate arrays without generic
        // type parameters, so we use this cast here to avoid future casts of the
        // node type's data field.
        @SuppressWarnings("unchecked")
        public Node<T>[] context = (Node<T>[]) new Node[3];

        public Node(T data) {
            this.data = data;
        }

        /**
         * @return true when this node has a parent and is the right child of that parent, otherwise
         * return false
         */
        public boolean isRightChild() {
            return context[0] != null && context[0].context[2] == this;
        }
    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * Performs a naive insertion into a binary search tree: adding the input data value to a new
     * node in a leaf position within the tree. After this insertion, no attempt is made to
     * restructure or balance the tree. This tree will not hold null references, nor duplicate data
     * values.
     *
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException     when the provided data argument is null
     * @throws IllegalArgumentException when data is already contained in the tree
     *
     *     FOR EASY REFERENCES
     * 
     *         context[0]
     *             |
     *            NODE
     *        /          \
     * context[1]     context[2]
     * 
     * 
     */
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        if(data == null){
            throw new NullPointerException("the provided data argument is null");
        }
        if(contains(data)){
            throw new IllegalArgumentException("data is already contained in the tree");
        }
        //finding the place for the new data
        Node<T> compareNode = new Node<T>(root.data);
        Node<T> newNode = new Node<T>(data);

        nullSpaceFinder(compareNode, newNode);

        //determine which case the tree is on by comparing aunts
        //left aunt
        if(newNode.context[0].context[0].context[1] != null){

        }
        //right aunt
        else if(newNode.context[0].context[0].context[2] != null){

        }
        //left & right null aunt
        else{
            if(newNode.context[0].context[0].data.compareTo(data) < 0){

            }
            else if(newNode.context[0].context[0].data.compareTo(data) > 0){
                
            }
        }
    }

    //TODO work on this tmr (trying to implement recursion method) ##may not work using recursion## also, how can I check node colors?
    /**
     * helper method for insert for finding a place (null) for new node in the tree
     * 
     * @param compareNode is should be set to root node when implemented in insert method
     * @param newNode is the new node that insert method is inserting
     */
    private void nullSpaceFinder(Node<T> compareNode, Node<T> newNode){
        if(compareNode.data.compareTo(newNode.data) > 0){
            if(compareNode.context[1] != null){
                compareNode = compareNode.context[1];
                nullSpaceFinder(compareNode, newNode);
            }
            else{
                compareNode.context[1] = newNode;
            }

        }
        //right child contestant
        else if(compareNode.data.compareTo(newNode.data) < 0){
            if(compareNode.context[2] != null){
                compareNode = compareNode.context[2];
                nullSpaceFinder(compareNode, newNode);
            }
            else{
                compareNode.context[2] = newNode;
            }
            
        }

    }

    /**
     * Performs the rotation operation on the provided nodes within this tree. When
     * the provided
     * child is a left child of the provided parent, this method will perform a
     * right rotation. When
     * the provided child is a right child of the provided parent, this method will
     * perform a left
     * rotation. When the provided nodes are not related in one of these ways, this
     * method will
     * throw an IllegalArgumentException.
     *
     * @param child  is the node being rotated from child to parent position
     *               (between these two node
     *               arguments)
     * @param parent is the node being rotated from parent to child position
     *               (between these two node
     *               arguments)
     * @throws IllegalArgumentException when the provided child and parent node
     *                                  references are not
     *                                  initially (pre-rotation) related that way
     */
    void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {


    }

    /**
     * Get the size of the tree (its number of nodes).
     *
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     *
     * @return true of this.size() return 0, false if this.size() > 0
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Removes the value data from the tree if the tree contains the value. This method will not
     * attempt to rebalance the tree after the removal and should be updated once the tree uses
     * Red-Black Tree insertion.
     *
     * @return true if the value was remove, false if it didn't exist
     * @throws NullPointerException     when the provided data argument is null
     * @throws IllegalArgumentException when data is not stored in the tree
     */
    public boolean remove(T data) throws NullPointerException, IllegalArgumentException {
        return false;
    }

    /**
     * Checks whether the tree contains the value *data*.
     *
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    public boolean contains(T data) {
        return false;
    }

    /**
     * This method performs an inorder traversal of the tree. The string representations of each
     * data value within this tree are assembled into a comma separated string within brackets
     * (similar to many implementations of java.util.Collection, like java.util.ArrayList,
     * LinkedList, etc).
     *
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    public String toInOrderString() {
        return "";
    }

    /**
     * This method performs a level order traversal of the tree. The string representations of each
     * data value within this tree are assembled into a comma separated string within brackets
     * (similar to many implementations of java.util.Collection). This method will be helpful as a
     * helper for the debugging and testing of your rotation implementation.
     *
     * @return string containing the values of this tree in level order
     */
    public String toLevelOrderString() {
        return "";
        
    }

    public String toString() {
        return "level order: " + this.toLevelOrderString() + "\nin order: " + this.toInOrderString();
    }


    // Implement at least 3 boolean test methods by using the method signatures below,
    // removing the comments around them and adding your testing code to them. You can
    // use your notes from lecture for ideas on concrete examples of rotation to test for.
    // Make sure to include rotations within and at the root of a tree in your test cases.
    // Give each of the methods a meaningful header comment that describes what is being
    // tested and make sure your test have inline comments to help developers read through them.
    // If you are adding additional tests, then name the method similar to the ones given below.
    // Eg: public static boolean test4() {}
    // Do not change the method name or return type of the existing tests.
    // You can run your tests by commenting in the calls to the test methods


    public static boolean test1() {
        try {
            // when parent node is root and the child node is right child of the parent
            RedBlackTree<Integer> test = new RedBlackTree<Integer>();
            test.insert(50);// tree should look like
            test.insert(25);//                   50
            test.insert(100);//           25             100
            test.insert(10);//       10      40      80       120
            test.insert(40);//
            test.insert(80);//
            test.insert(120);


            test.rotate(test.root.context[2], test.root);
            // after rotate, tree should be
            //                              100
            //                50                          120
            //         25           80
            //     10     40
            //


            if (!test.toLevelOrderString().equals("[ 100, 50, 120, 25, 80, 10, 40 ]")) {
                return false;
            }

            if (!test.toInOrderString().equals("[ 10, 25, 40, 50, 80, 100, 120 ]")) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        try {
            // when parent node is root and the child node is left child of the parent
            RedBlackTree<Integer> test1 = new RedBlackTree<Integer>();
            test1.insert(50);// tree should look like
            test1.insert(25);//                    50
            test1.insert(100);//           25             100
            test1.insert(10);//       10      40      80       120
            test1.insert(40);//
            test1.insert(80);//
            test1.insert(120);


            test1.rotate(test1.root.context[1], test1.root);
            // after rotate, tree should be
            //                  25
            //       10                          50
            //                            40            100
            //                                      80       120
            //


            if (!test1.toLevelOrderString().equals("[ 25, 10, 50, 40, 100, 80, 120 ]")) {
                return false;
            }

            if (!test1.toInOrderString().equals("[ 10, 25, 40, 50, 80, 100, 120 ]")) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        return true;
    }

    public static boolean test2() {

        try {
            //when the child node is right child of the parent and parent node is right child
            // of the root
            RedBlackTree<Integer> test = new RedBlackTree<Integer>();
            test.insert(50);// tree should look like
            test.insert(25);//                        50
            test.insert(100);//            25                   100
            test.insert(10);//       10         40                    130
            test.insert(40);//              35      45
            test.insert(130);
            test.insert(35);
            test.insert(45);


            test.rotate(test.root.context[2].context[2], test.root.context[2]);
            // after rotate, tree should be
            //                        50
            //             25                       130
            //       10          40          100
            //               35      45
            //


            if (!test.toLevelOrderString().equals("[ 50, 25, 130, 10, 40, 100, 35, 45 ]")) {
                System.out.println(test.toLevelOrderString());
                return false;
            }
            if (!test.toInOrderString().equals("[ 10, 25, 35, 40, 45, 50, 100, 130 ]")) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        try {
            //when child node is right child of the parent and parent node is left child of the root
            RedBlackTree<Integer> test1 = new RedBlackTree<Integer>();
            test1.insert(50);// tree should look like
            test1.insert(25);//                        50
            test1.insert(100);//            25                   100
            test1.insert(10);//       10         40                    130
            test1.insert(40);//              35      45
            test1.insert(130);
            test1.insert(35);
            test1.insert(45);

            test1.rotate(test1.root.context[1].context[2], test1.root.context[1]);
            // after rotate, tree should be
            //                          50
            //            40                          100
            //      25         45                            130
            //  10      35
            //

            if (!test1.toLevelOrderString().equals("[ 50, 40, 100, 25, 45, 130, 10, 35 ]")) {
                return false;
            }
            if (!test1.toInOrderString().equals("[ 10, 25, 35, 40, 45, 50, 100, 130 ]")) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean test3() {
        try {
            //when child node is left child of the parent and parent node is right child of the root
            RedBlackTree<Integer> test = new RedBlackTree<Integer>();
            test.insert(50);// tree should look like
            test.insert(25);//                        50
            test.insert(100);//           25                      100
            test.insert(10);//       10       40             80
            test.insert(40);//                           70      90
            test.insert(80);//
            test.insert(70);//
            test.insert(90);

            // right rotation (5 and 3)(parent and left child)
            test.rotate(test.root.context[2].context[1], test.root.context[2]);
            // after rotate, tree should be
            //                  50
            //       25                          80
            // 10         40             70            100
            //                                    90
            //

            if (!test.toLevelOrderString().equals("[ 50, 25, 80, 10, 40, 70, 100, 90 ]")) {
                return false;
            }
            if (!test.toInOrderString().equals("[ 10, 25, 40, 50, 70, 80, 90, 100 ]")) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        try {
            //when child node is left child of the parent and parent node is left child of the root
            RedBlackTree<Integer> test1 = new RedBlackTree<Integer>();
            test1.insert(50);// tree should look like
            test1.insert(25);//                        50
            test1.insert(100);//            25                   100
            test1.insert(10);//       10         40        80          120
            test1.insert(40);//   5       15
            test1.insert(80);
            test1.insert(120);
            test1.insert(5);
            test1.insert(15);

            test1.rotate(test1.root.context[1].context[1], test1.root.context[1]);
            // after rotate, tree should be
            //                        50
            //         10                          100
            //  5            25             80            120
            //           15     40
            //

            if (!test1.toLevelOrderString().equals("[ 50, 10, 100, 5, 25, 80, 120, 15, 40 ]")) {
                System.out.println(test1.toLevelOrderString());
                return false;
            }
            if (!test1.toInOrderString().equals("[ 5, 10, 15, 25, 40, 50, 80, 100, 120 ]")) {
                System.out.println(test1.toInOrderString());
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }


    /**
     * Main method to run tests. Comment out the lines for each test to run them.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Test 1 passed: " + test1());
        System.out.println("Test 2 passed: " + test2());
        System.out.println("Test 3 passed: " + test3());
    }

}