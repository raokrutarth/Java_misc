public class Driver 
{
        public static void main (String[] args)
        {
            Runnable r = new B();
            Thread t = new Thread(r);
            t.start();
            Thread t1 = new A();
            t1.start();
            
        }
}