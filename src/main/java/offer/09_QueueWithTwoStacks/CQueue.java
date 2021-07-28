import java.util.Stack;

/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/13
 */
public class CQueue {

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead(){
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()){
            return -1;
        }
        return stack2.pop();
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

}
