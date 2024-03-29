import java.util.Random;

/**
 * The TriangleDataGenerator class is used to generate data for a triangle to
 * be used in conjunction with the Triangle class. It has a method to generate
 * data about one triangle, stored in an array of Strings, and also has a
 * method to generate data for a specified number of triangles stored as an 
 * array of String arrays.
 * 
 * @author Neil Allison
 * @version March 1, 2015
 */
public class PiecesFactory {
    public static final int MAXLENGTH = 20; // Max length of a triangle side
    public static final int LOWN = 20;  // Minimum value for N
    public static final int HIGHN = 50;  // Maximum value for N
    private int N;
    
    /**
     * Constructor. Initializes member N to a random integer between LOWN and
     * HIGHN inclusive.
     */
    public PiecesFactory() {
        Random r = new Random();
        this.N = r.nextInt(HIGHN - LOWN + 1) + LOWN;
    }
    
    /**
     * Randomly generates data for a triangle if member variable N is greater 
     * than 0 by calling generateTriangle() and decrements N by one. If N is 
     * less than or equal to 0, returns null.
     *
     * @return String array generated by the method generateTriangle() if N
     *   is greater than 0 and null otherwise.
     */
    public String[] getNext() {
        if (this.N-- > 0) {
            return generatePieces();
        } else {
            return null;
        }
    }
    
    /**
     * Randomly generates 3 pieces of information about a triangle: the lengths
     * of two sides AND either the length of a third side OR the angle between
     * the two known sides. The first two sides will have a length within the
     * range [1, MAXLENGTH]. The third side will have a length within the range
     * [1, side1 + side2). The angle, measured in degrees, will be within the
     * range [0.01, 180.00).
     * 
     * @return String array containing the following:
     *   1: a letter corresponding to the third data of the triangle
     *    - 'S' if it is a third side
     *    - 'A' if it is an angle
     *   2: the length of the first side
     *   3: the length of the second side
     *   4: either the length of the third side or the angle
     */
    public static String[] generatePieces() {
        Random r = new Random();
        String dataString = "";
        
        // Generate triangle type
        char[] types = {'S', 'A'};
        char type = types[r.nextInt(2)];
        
        // Generate first two side lengths
        int side1 = r.nextInt(MAXLENGTH) + 1;
        int side2 = r.nextInt(MAXLENGTH) + 1;
        
        dataString += type + " " + side1 + " " + side2 + " ";
        
        // Generate third side OR truncated angle of two decimal precision
        if (type == 'S') {
            int min = Math.abs(side1 - side2) + 1;
            int range = side1 + side2 - min;
            dataString += min + r.nextInt(range);
        } else {
            dataString += ((int)(r.nextDouble() * 18000)) / 100.0;
        }
        
        // Return a tokenized version of dataString delimited by spaces
        return dataString.split(" ");
    }
    
    /**
     * Calls the generateTriangle() method to generate data for some number of
     * triangles passed as an argument to this method.
     *
     * @param n
     *   the number of triangles to generate data for
     * 
     * @return Array of String arrays that contain data for each triangle    
     */
    public static String[][] generateMultipleTriangles(int n) {
        String[][] triangles = new String[n][];
        for (int i = 0; i < n; i++) {
            triangles[i] = generatePieces();
        }
        return triangles;
    }
}