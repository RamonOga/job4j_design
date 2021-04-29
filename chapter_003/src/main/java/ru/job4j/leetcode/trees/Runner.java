package ru.job4j.leetcode.trees;

import java.util.ArrayList;
import java.util.Stack;

//498
public class Runner {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();

        SearchInABinarySearchTree search = new SearchInABinarySearchTree();

        System.out.println(search.searchBST(root, 555).value);

    }


}
