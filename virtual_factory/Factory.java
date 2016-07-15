public class Factory {
    
    public static void main(String[] args) {
        SorterThirdGeneration sorter = new SorterThirdGeneration();
        
        PiecesFactory fact = new PiecesFactory();
        
        String[] triangleSpecs = fact.getNext();
        
        while (triangleSpecs != null) {
            
            Triangle newTr;            
            if(triangleSpecs[0].equals("S"))
            {
                newTr = new Triangle(Integer.parseInt(triangleSpecs[1]), Integer.parseInt(triangleSpecs[2]), Integer.parseInt(triangleSpecs[3]));                
            }
            else
            {
                newTr = new Triangle(Integer.parseInt(triangleSpecs[1]), Integer.parseInt(triangleSpecs[2]), Double.parseDouble(triangleSpecs[3]));
            }   
            
            /* Sort the triangle */
            sorter.sort(newTr);
            
            /* get the next specifications */            
            triangleSpecs = fact.getNext();
        }
        
        sorter.printStatistics();
    }
}