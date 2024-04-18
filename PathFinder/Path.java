//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Path
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
import java.util.NoSuchElementException;

/**
 * This class represents a valid path through a grid of city intersections surrounded by streets.
 * That is, one which only moves either one step directly east, or one step directly north at each
 * step, meaning that only northeast paths from one intersection point to another are allowed. A
 * list of intersection elements creates the path.
 */
public class Path {

    private ArrayList<Intersection> intersections;
    // List of Intersections followed in this Path

    /**
     * Initializes this Path to start as empty
     *
     */
    public Path() {
        this.intersections = new ArrayList<>();

    }


    /**
     * Returns the number of Intersections in this Path
     *
     * @return the number of Intersections in this Path
     *
     */
    public int length() {
        return this.intersections.size();
    }

    /**
     * Returns the first Intersection in this Path, if it is not empty. Otherwise, throws a
     * NoSuchElementException.
     *
     * @return the first Intersection in this Path, if it is not empty
     *
     */
    public Intersection getHead() throws NoSuchElementException {
        try{
            return this.intersections.getFirst();
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns the last Intersection in this Path, if it is not empty. Otherwise, throws a
     * NoSuchElementException.
     *
     * @return the last Intersection in this Path, if it is not empty
     *
     */
    public Intersection getTail() throws NoSuchElementException {
        try{
            return this.intersections.getLast();
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    /**
     * Adds the given Intersection to the end of this Path if it is a valid addition. A Intersection
     * is a valid addition if the current Path is empty, or the Intersection to add is one step
     * directly east, or one step directly north of the current tail Intersection in this Path. Should
     * throw an IllegalArgumentException if the given Intersection is not a valid addition.
     *
     * @param toAdd Intersection to add to the end of this Path
     */
    public void addTail(Intersection toAdd) throws IllegalArgumentException {
        if(this.intersections.isEmpty() || toAdd.getX() == this.intersections.getLast().getX() + 1
        || toAdd.getY() == this.intersections.getLast().getY() + 1){
            this.intersections.add(toAdd);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Adds the given Intersection to the front of this Path if it is a valid addition. A Intersection
     * is a valid addition if the current Path is empty, or the Intersection to add is one step
     * directly west, or one step directly south of the current head Intersection in this Path. Should
     * throw an * IllegalArgumentException if the given Intersection is not a valid addition.
     *
     * @param toAdd Intersection to add to the beginning of this Path
     *
     */
    public void addHead(Intersection toAdd) throws IllegalArgumentException {
        if(this.intersections.isEmpty() || toAdd.getX() == this.intersections.getLast().getX() - 1
                || toAdd.getY() == this.intersections.getLast().getY() - 1){
            this.intersections.addFirst(toAdd);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns a String representing the coordinates taken in this Path. An empty Path should return
     * the String "Empty", while a non-empty Path should return the coordinates of the Intersections
     * it visits separated by a "->". For example:(0,0)->(1,0)->(1,1)->(1,2)
     *
     */
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (Intersection i : intersections) {
            returnString.append("(")
                    .append(i.getX())
                    .append(",")
                    .append(i.getY())
                    .append(")->");

        }
        if (returnString.length() >= 2) {
            return returnString.substring(0, returnString.length() - 2);
        }

        return returnString.toString();
    }



}
