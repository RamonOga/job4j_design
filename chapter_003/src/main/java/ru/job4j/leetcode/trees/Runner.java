package ru.job4j.leetcode.trees;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;

//498
public class Runner {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode16();
        ListNode current = head;
        int count = 0;
        System.out.println(head);
        while (current.next != null) {
            current = current.next;
            count++;
        }
        count = count % 2 == 0 ? count / 2 : (count / 2) + 1;
        current = head;
        for (int i = 0; i < count; i++) {
            current = current.next;
        }
    }


}
