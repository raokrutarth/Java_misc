   
public class Shelf 
{
    private String shelfType;
    private Book[] books;
    
    public Shelf(String newType, Book[] newBooks) 
    {
        this.shelfType = newType;
        this.books = newBooks;
    }
    
    public void addBooks(Book newBook) 
    {
        Book[] replaceBooks = new Book[books.length + 1];
        for (int i = 0; i < replaceBooks.length; i++) 
        {
            if (i == replaceBooks.length - 1) 
            {
                replaceBooks[i] = newBook;
            }
            else 
            {
                replaceBooks[i] = books[i];
            } 
        }
        books = replaceBooks;
    }
    
    public String getShelfType() 
    {
        return this.shelfType;
    }
    
    public boolean lendBook(Book newBook, int byAttributes) 
    {
        int index = searchBook(newBook, byAttributes);
        if (index == -1)
        {
            return false;
        }
        else 
        {
            books[index].setAvailibility(false);                
            return true;
        }
        
    }
    public boolean returnBook(Book newBook, int byAttributes)
    {
        int index = searchBook(newBook, byAttributes);
        if (index == -1)
        {
            return false;
        }
        else
        {
            books[index].setAvailibility(true);
            return true;
        }
        
    }
    public boolean getBookDetails(Book newBook, int byAttributes)
    {
        int index = searchBook(newBook, byAttributes);
        if (index == -1)
        {
            return false;
        }
        else
        {
            System.out.println("Book number: " + books[index].getNumber());
            System.out.println("Book name: " + books[index].getName());
            System.out.println("Book category: " + books[index].getCategory());
            System.out.println("Book availibility: " + books[index].getAvailibility());
            
        }
        return false;
    }
    
    
    public int searchBook(Book newBook, int byAttributes)
    {
        if ( byAttributes == 1 )
        {
            String nbookName = newBook.getName();
            
            for ( int i = 0; i < books.length; i++)
            {                
                String bookName = books[i].getName();
                //System.out.println(nbookName + " " + bookName);
                if ( nbookName.equals(bookName))
                {
                    return i;
                }
            }
        }
        else if ( byAttributes == 0 )
        {
            int nbookNumber = newBook.getNumber();
            for ( int i = 0; i < books.length; i++)
            {                
                int bookNumber = books[i].getNumber();
                //System.out.println(nbookNumber + " " + bookNumber);
                if ( nbookNumber == bookNumber )
                {
                    return i;
                }
            }
        }
        return -1;
    }
}

