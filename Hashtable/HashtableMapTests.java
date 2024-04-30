import java.util.NoSuchElementException;

/*
 * This class contains testing methods in the HashtableMap class
 */
public class HashtableMapTests {

    /*
     * Checks the correct implementation of put method in the HashtableMap class
     *
     * return true if the pairs are added to the HashtableMap object collection
     * correctly
     */
    public static boolean test1() {
        // put pairs into the Hash table collection
        HashtableMap test = new HashtableMap(7);
        test.put("Harry", 1234);
        test.put("Tom", 1235);
        test.put("Jenny", 1345);
        test.put("Katie", 1456);
        test.put("Jerry", 1567);

        // check if the pairs are added to the HashtableMap object collection
        if (test.getSize() != 5) {
            return false;
        }
        // check if the capacity of the array is rehashed correctly
        System.out.println(test.getCapacity());
        System.out.println(test.toString());
        if (test.getCapacity() != 14) {
            return false;
        }
        // check if the pairs are added to the HashtableMap object using the toString
        // method
        if (!test.toString().equals("(Harry, 1234) (null, null) (null, null) (null, null) " +
                "(Katie, 1456) (Jerry, 1567) (null, null) (null, null) (Tom, 1235) (null, null) "
                + "(null, null) (null, null) (Jenny, 1345) (null, null) ")) {
            return false;
        }System.out.println("1");

        // check if the exception is thrown correctly
        try {
            test.put("Jerry", 1567);
            return false;
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /*
     * Checks the correct implementation of the containsKey method in the
     * HashtableMap class
     *
     * return true if the containsKey method correctly checks whether the given key
     * is present
     * in the hash table array
     *
     */
    public static boolean test2() {
        // put pairs into the Hash table collection
        HashtableMap test = new HashtableMap(8);
        test.put(1, "January");
        test.put(2, "February");
        test.put(3, "March");
        test.put(4, "April");
        test.put(5, "May");

        // check if the containsKey method correctly checks whether the given key is
        // present
        if (test.containsKey(7) != false) {
            return false;
        }

        if (test.containsKey(5) != true) {
            return false;
        }

        return true;
    }

    /*
     * Checks the correct implementation of the get method in the HashTableMap class
     *
     * return true if the get method returns the value of the given key
     *
     */
    public static boolean test3() {
        // put pairs into the Hash table collection
        HashtableMap test = new HashtableMap(9);
        test.put("orange juice", "$4");
        test.put("milk", "$3");
        test.put("water", "$2");
        test.put("egg", "$4.5");
        test.put("pork", "$10");
        test.put("beef", "$15");

        // test if the get method returns the value of the given key
        if (!test.get("orange juice").equals("$4")) {
            return false;
        }

        if (!test.get("milk").equals("$3")) {
            return false;
        }

        if (!test.get("water").equals("$2")) {
            return false;
        }

        if (!test.get("egg").equals("$4.5")) {
            return false;
        }

        if (!test.get("pork").equals("$10")) {
            return false;
        }

        if (!test.get("beef").equals("$15")) {
            return false;
        }

        // check if the exception is thrown correctly
        try {
            test.get("lemonade");
            return false;
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /*
     * Checks the correct implementation of the remove method in the HashTableMap
     * class
     *
     * return true if the pair of the given key is removed successfully
     *
     */
    public static boolean test4() {

        // put pairs into the Hash table collection
        HashtableMap test = new HashtableMap(9);
        test.put(1, "January");
        test.put(2, "February");
        test.put(3, "March");
        test.put(4, "April");
        test.put(5, "May");

        // remove the key from the Hash table collection
        test.remove(2);

        // check if the pair is removed successfully
        if (test.getSize() != 4) {
            return false;
        }

        if (test.getCapacity() != 9) {
            return false;
        }

        // check if the pair is removed from the HashtableMap object using the toString
        // method
        if (!test.toString().equals("(null, null) (1, January) (null, null) (3, March) (4, April) "
                + "(5, May) (null, null) (null, null) (null, null) ")) {
            return false;
        }

        // check if the exception is thrown correctly
        try {
            test.remove(7);
            return false;
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    /*
     * Checks the correct implementation of the clear method in the HashTableMap
     * class
     *
     * return true if the pair of the given key is removed successfully
     *
     */
    public static boolean test5() {
        // put pairs into the Hash table collection
        HashtableMap test = new HashtableMap(9);
        test.put(18, "April");
        test.put(25, "August");
        test.put(24, "July");
        test.put(9, "July");

        // clear the Hash table collection
        test.clear();

        // check if the elements in the Hash table collection is cleared successfully
        if (test.getSize() != 0) {
            return false;
        }

        if (test.getCapacity() != 9) {
            return false;
        }

        // check if the elements in the Hash table collection is cleared successfully
        // using
        // the toString method
        if (!test.toString().equals("(null, null) (null, null) (null, null) (null, null) " +
                "(null, null) (null, null) (null, null) (null, null) (null, null) ")) {
            return false;
        }

        return true;
    }

    /**
     * Checks the correctness of all of the test methods within this class
     * 
     */
    public static void main(String[] args) {
        System.out.println("Test 1 passed: " + test1());
        System.out.println("Test 2 passed: " + test2());
        System.out.println("Test 3 passed: " + test3());
        System.out.println("Test 4 passed: " + test4());
        System.out.println("Test 5 passed: " + test5());
    }

}