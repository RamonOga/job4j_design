package ru.job4j.leetcode.trees;

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {
      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
      public static ListNode getListNode15() {
          return new ListNode(1,
                  new ListNode(2,
                          new ListNode(3,
                                  new ListNode(4,
                                          new ListNode(5)))));
      }

      public static ListNode getListNode16() {
          return new ListNode(1,
                  new ListNode(2,
                          new ListNode(3,
                                  new ListNode(4,
                                          new ListNode(5,
                                                  new ListNode(6))))));
      }

      @Override
      public String toString() {
          return  val + " -> " + next + "\n";
      }
  }
