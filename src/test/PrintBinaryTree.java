package test;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class PrintBinaryTree {
    static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        TreeNode speciNode = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(pRoot);
        q.add(speciNode);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node != speciNode) {
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }else {
                ArrayList<Integer> newList = new ArrayList<>(list);
                result.add(newList);
                //System.out.println(result);
                list.clear();     //刷新之后result中的所有list都指向了空list
                q.add(speciNode);
            }
            if (node == speciNode && q.peek() == speciNode) {
                break;
            }
        }
        return result;
    }
/*
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(8);
        node7.left = node5;
        node7.right = node6;
        node5.left = node1;
        node5.right = node2;
        node6.left = node3;
        node6.right = node4;
        System.out.println(Print(node7));
        return;
    }
*/
    /*
    while循环中，即使中间循环条件改变，也会执行完本次循环的所有操作
     */
    public static void main(String[] args) {
        boolean f = true;
        while (f) {
            System.out.println("yes");
            f = false;
            System.out.println("no");
        }
    }
}
