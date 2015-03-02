import java.util.Stack;

/**
 * Created by Risky on 2015/2/3.
 */
public class StackTest {
    public static void main(String[] args){

        Stack<String> stack = new Stack<String>();

        stack.push(null);

        System.out.println(stack.pop());
    }
}
