package audition;

import java.util.Stack;

/**
 * 面试题31. 栈的压入、弹出序列
 * @Description
 * * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @auther SHENKAIHUAN
 * @create 2020-04-25 9:49
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed=new int[]{1,2,3,4,5};
        int[] popped=new int[]{4,3,5,2,1};
        long start=System.currentTimeMillis ();
        System.out.println (validateStackSequences (pushed,popped));
        long end=System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0,j=0;
        Stack<Integer> stack =new Stack<> ();
        while (i<pushed.length || j<popped.length){
            if(!stack.isEmpty () &&stack.peek ()==popped[j]){
                stack.pop ();
                j++;
                continue;
            }else {
                if(i>=pushed.length) return false;
                stack.push (pushed[i]);
                i++;
            }
        }
        return true;
    }
}


