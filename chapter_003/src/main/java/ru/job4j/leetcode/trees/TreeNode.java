package ru.job4j.leetcode.trees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = value;
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
        System.out.println(sum);
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
            System.out.println(current.value);
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

    public static int iterWide(TreeNode node, int val) {
        int rsl = -1;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.value == val) {
                rsl = current.value;
                break;
            }
            System.out.println(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return rsl;
    }
}
