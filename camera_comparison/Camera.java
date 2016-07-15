public class Camera 
{
    boolean hasWiFi;
    boolean isWaterResistant;
    boolean hasGPS;
    String condition; //“New”, “Refurbished”, “Used” 
    double price;  // 0.00 to  1000.00
    int userRating; // 0 to 5
    public Camera(boolean hasWiFi, boolean isWaterResistant,
                  boolean hasGPS, String condition, 
                  double price, int userRating) 
    {
        this.hasWiFi = hasWiFi;
        this.isWaterResistant = isWaterResistant;
        this.hasGPS = hasGPS;
        this.condition = condition;
        this.price = price;
        this.userRating = userRating;    
    }
    public int computeValue() 
    {
        int value = 0;
        if (hasWiFi == true)
        {
            value = value + 1;
        }
        if (isWaterResistant == true)
        {
            value = value + 1;
        }
        if (hasGPS == true)
        {
            value = value + 1;
        }
        if (condition.equals("New"))
        {
            value = value + 2;
        }
        if (condition.equals("Refurbished"))
        {
            value = value + 1;
        }
        if (condition.equals("Used"))
        {
            value = value + 0;
        }
        return value;
    }
}