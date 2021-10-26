package sort.leetcode;

import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(7);

        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node1.right=node4;
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(5);
//        ListNode node6 = new ListNode(7);
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node6;

        Main main = new Main();
        System.out.println(main.getMinHeight(root));
    }

    public int getMinHeight(TreeNode root){

        if(root==null) return 0;

        if(root.left==null&&root.right==null){
            return 1;
        }

        int min=Integer.MAX_VALUE;
        if(root.left!=null){
            min=Math.min(getMinHeight(root.left),min);
        }

        if(root.right!=null){
            min=Math.min(getMinHeight(root.right),min);
        }

        return min+1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        return val == listNode.val;
    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
