import java.util.Stack;

/**
 * Created by Risky on 2014/12/10.
 */
public class MinStack {

    int min;
    Stack<Integer> minStack;

    public MinStack(){
        minStack = new Stack<Integer>();
    }

    public void push(int x) {

        if(minStack.empty()){
            min = x;
            minStack.push(0);
        }
        else
        {
            minStack.push(x-min);
            if(min > x)
                min = x;

        }
    }

    public void pop() {

        if(minStack.empty()) return;

        int temp = minStack.pop();

        if(temp < 0)
            min = min - temp;

    }

    public int top() {
        int temp = minStack.peek();
        if(temp > 0)
            return (min + temp);
        else
            return min;

    }

    public int getMin() {

        return min;

    }
}
