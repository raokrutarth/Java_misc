import java.util.ArrayList;

public class SorterSecondGeneration {
    private ArrayList<Triangle> small = new ArrayList<Triangle>();
    private ArrayList<Triangle> medium = new ArrayList<Triangle>();
    private ArrayList<Triangle> large = new ArrayList<Triangle>();

    public SorterSecondGeneration() 
    {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    /**
     * Add the triangle in the good container and update the statistics.
     */
    public void sort(Triangle p) 
    {
        if(p.area() < 10)
        {
            this.small.add(p);
        }
        else if (10 <= p.area() && 50 > p.area())
        {
            this.medium.add(p);
        }
        else if (p.area() > 50)
        {
            this.large.add(p);
        }
    }
    
    public void printStatistics() {
        System.out.printf("There are currently %d triangles in stock:\n", this.small.size() + this.medium.size() + this.large.size());
        System.out.printf(" - %d small %n", this.small.size());
        System.out.printf(" - %d medium %n", this.medium.size());
        System.out.printf(" - %d large %n%n", this.large.size());
    }
}