public class RunnableTest implements Runnable
{
    public static int counter;
    private int start;
    private int stop;
    
    public RunnableTest(int start, int stop)
    {
        this.start = start;
        this.stop = stop;
    }
    
    public void PrintRange(int start, int stop)
    {
        for (int i = start ; i < stop + 1; i++ )
        {
            //System.out.println(i);
            counter++;
        }
    }
    public static int getCounter()
    {
        return counter;
    }
    public void run()
    {
        PrintRange(this.start, this.stop);
    }
    
    public static void main(String[] args)
    {
        try 
        {
        Runnable r = new RunnableTest(12, 14);
        Thread t1 = new Thread(r);
        Runnable r1 = new RunnableTest(1, 14);
        Thread t2 = new Thread(r1);
        t2.start();
        t1.start();
        t2.join();
        t1.join();
        System.out.println("counter = " + RunnableTest.getCounter());
        }
        catch (InterruptedException e)
        {
        }
    }
}