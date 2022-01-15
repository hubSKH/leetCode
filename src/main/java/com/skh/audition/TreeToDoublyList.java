package audition;

import assit.Node;

/**
 * 面试题36. 二叉搜索树与双向链表
 * @Description
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * @auther SHENKAIHUAN
 * @create 2020-05-01 22:31
 */
public class TreeToDoublyList {
    public static void main(String[] args) {

        Node root = new Node (4);
        root.left = new Node (2);
        root.left.left =new Node (1);
        root.left.right=new Node (3);
        root.right = new Node (5);

        long start = System.currentTimeMillis ();
        Node node = treeToDoublyList (root);
        long end =System.currentTimeMillis ();
        System.out.println ("total:"+(end-start));
    }

    static Node pre = null;
    static Node head = null;
    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        rec (root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private static void rec(Node root) {
        if (root==null)return;
        rec (root.left);
        if(pre==null) head=root;
        else pre.right=root;
        root.left=pre;
        pre=root;
        rec (root.right);
    }



    //辅助空间
    /*private static Node toDoubleLink(Node root) {
        LinkedList<Node> linkedList =new LinkedList<> ();
        toDoubleLink (root,linkedList);
        Node node = new Node (-1),p=node;
        while (!linkedList.isEmpty ()){
            Node pop = linkedList.pop ();
            p.right=pop;
            pop.left=p;
            p=p.right;
        }
        node=node.right;
        p.right =node;
        node.left=p;
        return node;
    }
    private static void  toDoubleLink(Node root, LinkedList<Node> head){
        if(root==null) return;
        toDoubleLink (root.left,head);
        head.add (root);
        toDoubleLink (root.right,head);
    }*/
}
