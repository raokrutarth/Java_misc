import java.util.Stack;
public class Evaluator
{
    public static int evaluate(String rpn)
    {
        String[] rpnStr = rpn.split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        for ( String rpnEl : rpnStr)
        {
            if (isNum(rpnEl))
            {
                stack.push(Integer.parseInt(rpnEl));                
            }
             else 
             {
                int num2 = stack.pop(); 
                int num1 = stack.pop();
                if (rpnEl.equals("+")) 
                {
                    stack.push(num1 + num2);
                    //assert(num1 ==  7);
                }
                else if (rpnEl.equals("-"))
                    stack.push(num1 - num2);
                else if (rpnEl.equals("*") || rpnEl.equals("x"))
                    stack.push(num1 * num2);
                else if (rpnEl.equals("/"))
                    stack.push(num1 / num2);
                else throw new RuntimeException("unknown operator");
            }
        }
        return stack.pop();
    }
    
    
    private static boolean isNum(String numStr)
    {
        try 
        {
            Integer.parseInt(numStr);
            return true;
        } 
        catch (NumberFormatException e) 
        {
            return false;
        } 
    }
    public static void main(String[] args)
    {
        System.out.println(evaluate("5 1 2 + 4 x + 17 -"));
    }
    
}