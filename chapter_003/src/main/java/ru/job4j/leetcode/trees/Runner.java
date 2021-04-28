package ru.job4j.leetcode.trees;

import java.util.ArrayList;
import java.util.Stack;

//498
public class Runner {
    public static void main(String[] args) {

    }

    public static TreeNode getTreeNode() {
        return new TreeNode(41,
                new TreeNode(26,
                        new TreeNode(12, null, new TreeNode(14)), new TreeNode(31)),
                new TreeNode(76,
                        new TreeNode(45, new TreeNode(21, new TreeNode(5), null), null),
                        new TreeNode(81, new TreeNode(46), new TreeNode(100))));
    }
    public static int reverseDeepSum(TreeNode node) {
        int sum = node.value;
        if (node.left != null) {
            sum += reverseDeepSum(node.left);
        }
        if (node.right != null) {
            sum += reverseDeepSum(node.right);
        }
        return sum;
    }

    public static int iterDeepSum(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        stack.push(node);
        int sum = 0;

        while (!stack.isEmpty()) {
            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
            sum += current.value;
            current = stack.pop();
        }



        return sum;
    }
}
