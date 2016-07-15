
public class Triangle 
{
    int l1;
    int l2;
    int l3;
    double angle;
    
    
    /* Constructor with 3 sides */
    public Triangle(int l1, int l2, int l3)
    {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }
    
    /* Constructor with 2 sides and the included angle */
    public Triangle(int l1, int l2, double angle)
    {
        this.l1 = l1;
        this.l2 = l2;
        this.angle = angle;
        this.l3 = (int) oppSide(angle, l1, l2);
    }
    
    /* compute the perimeter */
    public double perimeter()
    {
        return this.l1 + this.l2 + this.l3;
    }
    
    /* compute the area */
    public double area()
    {
        double angleBetween = angleFromSides(this.l1, this.l2, this.l3);
        double area = 0.5*l1*l2*(Math.sin(angleBetween));
        return area;
        
    }
    
    public double area(double l1, double l2, double angle)
    {
        double area = 0.5*l1*l2*(Math.sin(angle));
        return area;
    }
    
    
    // Auxiliary functions given
    
    /**
     * This functions computes the included angles of a triangle
     *
     * @param adj1 one of the adjacent side
     * @param adj2 the other adjacent side
     * @param opp the opposite side
     */
    public static double angleFromSides(double adj1, double adj2, double opp) 
    {
        double pythagoras = opp * opp - adj1 * adj1 - adj2 * adj2;
        return Math.acos(-pythagoras/(2*adj1*adj2));
    }
    
    /**
     * This functions computes the length of the opposite side
     *
     * @param angle the included angle
     * @param adj1 one of the adjacent side
     * @param adj2 the other adjacent side
     */
    public static double oppSide(double angle, double adj1, double adj2) 
    {
        return Math.sqrt(adj1 * adj1 - 2 * adj1 * adj2 * Math.cos(angle) + adj2 * adj2);
    }
    
    
    
}
