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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val + '}';
    }
}

public class ReverseLinkList {
        public static ListNode reverseList(ListNode head) {
            ListNode one = null;
            ListNode two = head;
            ListNode tmp;
            while (two != null) {
                tmp = one;
                one = two;
                two = one.next;
                one.next = tmp;
            }
            return one;
        }

        public static void print(ListNode ln) {
            while (ln != null) {
                System.out.println(ln);
                ln = ln.next;
            }
        }



    public static void main(String[] args) {
        ListNode ln = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        print(ln);
        print(reverseList(ln));

    }
}


