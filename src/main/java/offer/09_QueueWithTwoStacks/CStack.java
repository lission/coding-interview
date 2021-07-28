import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *  后进先出
 * @author lisong@cestc.cn
 * @date 2021/7/13
 */
public class CStack {
    public CStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public void push(int value){
        queue1.add(value);
    }

    public int pop(){
        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }
        if (queue2.isEmpty()){
            return -1;
        }
        return queue2.poll();
    }
}
