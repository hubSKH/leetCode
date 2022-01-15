package audition;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * @Description
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * @auther SHENKAIHUAN
 * @create 2020-06-23 22:52
 */
public class MaxQueue {
    private Queue<Integer> queue ;
    private Deque<Integer> maxQue ;

    public MaxQueue() {
        queue =new LinkedList<> ();
        maxQue = new LinkedList<> ();
    }

    public int max_value() {
        return maxQue.isEmpty ()?-1:maxQue.peek ();

    }

    public void push_back(int value) {
        queue.offer (value);
        while (!maxQue.isEmpty () && maxQue.peekLast () < value) maxQue.pollLast ();
        maxQue.addLast (value);

    }

    public int pop_front() {
        int value=queue.isEmpty ()?-1:queue.poll ();
        while (!maxQue.isEmpty ()&& maxQue.peek ()==value) maxQue.poll ();
        return value;

    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        obj.push_back (1);
        obj.push_back (2);
        System.out.println (obj.max_value ());
        System.out.println (obj.pop_front ());
        System.out.println (obj.max_value ());
    }
}
