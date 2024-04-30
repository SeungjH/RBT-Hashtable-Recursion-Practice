import java.util.ArrayList;
import java.util.Scanner;


/**
 * Tester class for PathUtils
 *
 */
public class PathUtilsTester {

    /**
     * Constructor for PathUtilsTester Class. It allows to create the instance of this class.
     */
    public PathUtilsTester() {

    }

    /**
     * Tests the case of countPaths() when there are no valid Paths. For example, when the start
     * position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should be
     * no valid Paths, so countPaths() should return 0.
     *
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsNoPath() {
        Intersection start = new Intersection(2, 2);
        Intersection end = new Intersection(1, 1);

        if (PathUtils.countPaths(start, end) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Tests the case of countPaths() when there is a single valid Path. For example, when the start
     * position is Intersection(1, 1) and the ending position is Intersection(1, 2), there should be a
     * single Path, so countPaths() should return 1.
     *
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsOnePath() {
        Intersection start = new Intersection(0, 0);
        Intersection end = new Intersection(0, 1);

        if (PathUtils.countPaths(start, end) != 1) {
            return false;
        }

        return true;
    }

    /**
     * Tests the case of countPaths() when there are multiple possible paths. For example, when the
     * start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there
     * should be three possible Paths, so countPaths() should return 3.
     *
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsRecursive() {
        Intersection start = new Intersection(0, 0);
        Intersection end = new Intersection(3, 2);

        if (PathUtils.countPaths(start, end) != 10) {
            return false;
        }

        return true;
    }

    /**
     * Tests the case of findAllPaths() when there are no valid Paths. For example, when the start
     * position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should be
     * no valid Paths, so findAllPaths() should return an empty ArrayList.
     *
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsNoPath() {
        Intersection start = new Intersection(3, 3);
        Intersection end = new Intersection(0, 0);

        if (!(PathUtils.findAllPaths(start, end)).isEmpty()) {
            return false;
        }
        return true;

    }


    /**
     * Tests the case of findAllPaths() when there is a single valid Path. For example, when the start
     * position is Intersection(1, 1) and the ending position is Intersection(1, 2), there should be a
     * single Path. For each of your cases, ensure that there is only a single path, and that the Path
     * exactly matches what you expect to see.
     *
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsOnePath() {
        Intersection start = new Intersection(1, 2);
        Intersection end = new Intersection(2, 2);
        ArrayList<Path> onePath = PathUtils.findAllPaths(start, end);

        Path pathstr_1 = onePath.get(0);
        if (!(pathstr_1.toString()).equals("(1,2)->(2,2)")) {
            return false;
        }


        if (onePath.size() != 1) {
            return false;
        }

        return true;



    }


    /**
     * Tests the case of findAllPaths() when there are multiple possible paths. For example, when the
     * start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there
     * should be three possible Paths. For each of your cases, ensure that there is both the correct
     * number of Paths, and that the returned Paths exactly match what you expect to see. Remember:
     * The order the Paths appear in the output of findAllPaths() will not necessarily match your own
     * implementation.
     *
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsRecursive() {
        Intersection start = new Intersection(0, 0);
        Intersection end = new Intersection(2, 1);

        ArrayList<Path> allPath = PathUtils.findAllPaths(start, end);
        Path pathstr_1 = new Path();
        Path pathstr_2 = new Path();
        Path pathstr_3 = new Path();

        pathstr_1 = allPath.get(0);
        pathstr_2 = allPath.get(1);
        pathstr_3 = allPath.get(2);

        if (!(pathstr_1.toString()).equals("(0,0)->(0,1)->(1,1)->(2,1)")) {
            return false;
        }
        if (!(pathstr_2.toString()).equals("(0,0)->(1,0)->(1,1)->(2,1)")) {
            return false;
        }
        if (!(pathstr_3.toString()).equals("(0,0)->(1,0)->(2,0)->(2,1)")) {
            return false;
        }

        if (allPath.size() != 3) {
            return false;
        }

        return true;



    }


    public static void main(String[] args) {

        try (Scanner keyboard = new Scanner(System.in)) {
            int startX, startY, endX, endY;
            String input = "Y";
            while (input.equalsIgnoreCase("Y")) {
                System.out.print("Enter starting X coordinate: ");
                startX = keyboard.nextInt();
                System.out.print("Enter starting Y coordinate: ");
                startY = keyboard.nextInt();
                System.out.print("Enter ending X coordinate: ");
                endX = keyboard.nextInt();
                System.out.print("Enter ending Y coordinate: ");
                endY = keyboard.nextInt();
                Intersection start = new Intersection(startX, startY);
                Intersection end = new Intersection(endX, endY);
                System.out
                        .println("Number of paths from start to end: " + PathUtils.countPaths(start, end));
                System.out.println("List of possible paths:");
                for (Path p : PathUtils.findAllPaths(start, end)) {
                    System.out.println(p);
                }
                do {
                    System.out.print("Try another route? (Y/N): ");
                    input = keyboard.next();
                } while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));
            }
        }
    }
}
