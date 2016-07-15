public class Book
{
    private int number;
    private String name;
    private String category;
    private boolean availability;
    
    public Book(int number, String name, String category)
    {
        this.number = number;
        this.name = name;
        this.category = category;
        availability = true;     
    }
    public boolean equals(Book newBook, int byAttributes)
    {
        if (byAttributes != 0 || byAttributes != 1)
        {
            return false;
        }
        else if (byAttributes == 0)
        {
            return ( newBook.number == this.number );
        }
        else if (byAttributes == 1)
        {
            return (newBook.equals(this.name));
        }
        return false;
    }
    public boolean getAvailibility()
    {
        return this.availability;        
    }
    public void setAvailibility(boolean isAvailable)
    {
        this.availability = isAvailable;
    }
    public int getNumber()
    {
        return this.number;
    }
    public String getName()
    {
        return this.name;
    }
    public String getCategory()
    {
        return this.category;
    }
    
}