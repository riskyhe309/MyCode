/**
 * Created by Risky on 2014/12/10.
 */
public class Test {
    public  static void main(String[] args){
        MinStack ms = new MinStack();

        ms.push(2);
        ms.push(0);
        ms.push(3);
        ms.push(0);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());

    }
}
