package ru.job4j.leetcode;

class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
          this.val = val;
      }

     ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }

public class ReverseLinkList {

        public ListNode reverseList(ListNode head) {
            ListNode one = head;
            ListNode two = head.next;
            ListNode three;
            while (one.next != null) {
                three = one;
                one = two;
                two = one.next;
                one.next = three;
            }
            return two;
        }
}
