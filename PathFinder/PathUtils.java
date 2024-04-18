//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: PathUtils
// Course: CS 300 Fall 2022
//
// Author: Hye Won Park
// Email: hpark383@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: got help from TA
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * Utility methods for planning a trip through a grid of city intersections
 *
 */
public class PathUtils {

    public PathUtils() {

    }


    /**
     * Finds the number of valid Paths between the given start and end Intersections. If it is not
     * possible to get from the start to the end intersection by moving up or right, then 0 should be
     * returned.
     *
     * @param start Intersection to start at
     * @param end   Intersection to end at
     * @return the number of valid Paths which start and end at the given Intersections
     */
    public static int countPaths(Intersection start, Intersection end) {
        //base case
        //A is X(B)
        if(start.equals(end)){
            return 1;
        }
        //two ways to go from A to X
        if(start.getX() < end.getX() && start.getY() < end.getY()){
            return countPaths(start.goNorth(), end) + countPaths(start.goEast(), end);
        }
        //single way to go from A to X
        //1. start and end is on the same X axis
        if(start.getX() < end.getX() && start.getY() == end.getY()){
            return countPaths(start.goEast(), end);
        }
        //2. start and end is on the same Y axis
        else if(start.getY() < end.getY() && start.getX() == end.getX()){
            return countPaths(start.goNorth(), end);
        }
        //no possible path
        else{
            return 0;
        }
    }


    /**
     * Finds all valid Paths between the given start and end Intersections. If it is not possible to
     * get from the start to the end intersection by moving up or right, then an empty ArrayList
     * should be returned.
     *
     * @param start Intersection to start at
     * @param end   Intersection to end at
     * @return an ArrayList containing all valid Paths which start and end at the given Intersections
     */
    public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
        ArrayList<Path> returnArr = new ArrayList<>();
        //base case
        //A is X(B)
        if(start.equals(end)){
            Path startPath = new Path();
            startPath.addHead(start);
            returnArr.add(startPath);
            return returnArr;
        }
        //two ways to go from A to X
        if(start.getX() < end.getX() && start.getY() < end.getY()){
            ArrayList<Path>
            return
           ArrayList<Path> ultiArr = new ArrayList<>();
           ultiArr.addAll(findAllPaths(start.goNorth(), end));
           ultiArr.addAll(findAllPaths(start.goEast(), end));
           return ultiArr;
        }
        //single way to go from A to X
        //1. start and end is on the same X axis
        if(start.getX() < end.getX() && start.getY() == end.getY()){
            return findAllPaths(start.goEast(), end);
        }
        //2. start and end is on the same Y axis
        else if(start.getY() < end.getY() && start.getX() == end.getX()){
            return findAllPaths(start.goNorth(), end);
        }
        //no possible path
        else{
            return returnArr;
        }
    }



}
