package ru.job4j.leetcode.trees;

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

//498
public class Runner {
    public static void main(String[] args) {
        TreeNode node = TreeNode.getTreeNode();


        System.out.println("========================================");
        TreeNode.iterWide(node, 999);
        System.out.println("========================================");
/*
        SearchInABinarySearchTree.searchBST(node, 100);
        System.out.println("========================================");
        TreeNode.iterDeepSum(node);
        System.out.println("========================================");
        TreeNode.reverseDeepSum(node);
        System.out.println("========================================");
*/

    }


}
