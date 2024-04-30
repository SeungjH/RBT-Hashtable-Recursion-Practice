/**
 * This class represents a single intersection point where two streets laid out on a grid plan cross
 * at specified x and y coordinate positions.
 */
public class Intersection {

    private final int x; // X-axis coordinate of this intersection
    private final int y; // Y-axis coordinate of this intersection

    /**
     * Initializes this intersection with the given coordinates
     *
     * @param x Horizontal position of this Intersection
     * @param y Vertical position of this Intersection
     */
    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the horizontal position of this Intersection
     *
     * @return the horizontal position of this Intersection
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the vertical position of this Intersection
     *
     * @return the vertical position of this Intersection
     */
    public int getY() {
        return y;
    }

    /**
     * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
     *
     * @return a coordinate-pair representation of this Intersection
     */
    @Override
    public String toString() {
        String s = "(" + this.x + "," + this.y + ")";
        return s;
    }

    /**
     * Returns true if the given Object is identical to this Intersection
     *
     * @param o object to compare for equality
     * @return true if the given Object is an Intersection object which has the same x and y
     *         coordinates as this Intersection
     */
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Intersection other = (Intersection) o;
        return this.x == other.x && this.y == other.y;

    }

    /**
     * Creates a new Intersection instance which is one step directly above this Intersection. Should
     * not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly above this Intersection
     */
    public Intersection goNorth() {
        return new Intersection(x, y+1);
    }

    /**
     * Creates a new Intersection instance which is one step directly below this Intersection. Should
     * not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly below this Intersection
     */
    public Intersection goSouth() {
        return new Intersection(x, y-1);
    }

    /**
     * Creates a new Intersection instance which is one step directly to the right of this
     * Intersection object. Should not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly to the right of this
     *         Intersection
     */
    public Intersection goEast() {
        return new Intersection(x+1, y);
    }

    /**
     * Creates a new Intersection instance which is one step directly to the left of this
     * Intersection. Should not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly to the left of this Intersection
     */
    public Intersection goWest() {
        return new Intersection(x-1, y);
    }
}
