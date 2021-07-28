import java.util.Stack;

/**
 * TODO
 *
 * @author lisong@cestc.cn
 * @date 2021/7/8
 */
public class PrintListInReversedOrder {

    /*
     *  从头到尾遍历链表，每经过一个节点，把该节点放到栈中。当遍历完整个链表后，再从栈顶开始逐个输出节点的值。
     */


    public int[] reversePrint(ListNode head){
        if (head == null ){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node.val);
            node = node.next;
        }
        int[] ints = new int[stack.size()];
        int index = 0;
        while (!stack.empty()){
            int i = stack.pop();
            System.out.println(i);
            ints[index++] = i;
        }
        return ints;
    }

    public static void main(String[] args) {
        PrintListInReversedOrder order = new PrintListInReversedOrder();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node1.setNext(node2);
        node.setNext(node1);
        order.reversePrintOnly(node);
    }
    public void reversePrintOnly(ListNode head){
        if (head == null ){
            return;
        }
        if (head.next != null){
            reversePrintOnly(head.next);
        }
        System.out.println(head.val);
    }

    public int[] reversePrintBase(ListNode head){
        if (head == null ){
            return new int[0];
        }
        if (head.next != null){
            reversePrintRecursion(head.next);
        }
        return null;
    }

    public int reversePrintRecursion(ListNode head){
        if (head.next != null){
            return reversePrintRecursion(head.next);
        }
        System.out.println(head.val);
        return head.val;
    }
}
