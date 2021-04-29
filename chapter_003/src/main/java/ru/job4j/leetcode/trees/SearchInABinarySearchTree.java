package ru.job4j.leetcode.trees;

import java.util.Stack;

public class SearchInABinarySearchTree {

        public TreeNode searchBST(TreeNode root, int val) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                root = stack.pop();
                if (root.value == val) {
                    return root;
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }

            }
            return null;
        }
    }


