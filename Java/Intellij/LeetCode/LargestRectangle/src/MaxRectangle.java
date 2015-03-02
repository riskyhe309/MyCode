/**
 * Created by Risky on 2015/1/7.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxRectangle {

    // 使用栈来保存每个柱状条，当当前准备入栈的柱状条的高度小于当前栈顶的柱状条高度时，先让栈顶元素出栈，同时计算最大的矩形大小
    public int maxRectangleValue(int[] array) {
        if (array == null || array.length <= 0)
            return -1;
        int maxValue = 0;
        List<Element> inputList = new ArrayList<Element>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            Element element = new Element(array[i], i);
            inputList.add(element);
        }
        // 开始入栈操作
        Stack<Element> stack = new Stack<Element>();
        for (Element e : inputList) {
            if (stack.empty())
                stack.add(e);
            else {
                while (e.height < stack.peek().height) { // 出栈，并计算最大矩形大小
                    Element topElement = stack.pop();
                    int tmpValue = topElement.height * (e.index - topElement.index); // height * width

                    // 将这些直方图合并，下标取最左边直方图的下标
                    e.index = topElement.index;
                    if (tmpValue > maxValue)
                        maxValue = tmpValue;
                    if (stack.empty())
                        break;
                }
                // 进栈
                stack.add(e);
            }
        }
        // 将堆栈中包含的所有元素出栈，同时更新最大的矩形大小
        while (!stack.empty()) {
            Element topElement = stack.pop();
            int tmpValue = topElement.height * ((len - 1) - topElement.index + 1); // height * width
            if (tmpValue > maxValue)
                maxValue = tmpValue;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,18,19,20,21,24,17,18};
        MaxRectangle mr = new MaxRectangle();
        System.out.println(mr.maxRectangleValue(array));
    }
}

class Element {
    public int height; // 每一个柱状条的高度（宽度为1）
    public int index; // 每个柱状条的x坐标值，代表它们出现的相对次序
    public Element(int height, int index) {
        this.height = height;
        this.index = index;
    }
}
