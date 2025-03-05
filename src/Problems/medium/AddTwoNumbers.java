package Problems.medium;

import Problems.easy.RemoveElement;

import java.util.Arrays;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();

//        l1 = [2,4,3]
//        l2 = [5,6,4]

//        ListNode l1 = new ListNode(3, new ListNode(4,  new ListNode(2)));
//        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5)));

//        l1 = [9]
//        l2 = [1,9,9,9,9,9,9,9,9,9]

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))));

        System.out.println(obj.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int[] a = {};

        var l11 = l1;
        while (true) {
            a  = Arrays.copyOf(a, a.length + 1);
            a[a.length - 1] = l11.val;

            if (l11.next != null) {
                l11 = l11.next;
            } else {
                break;
            }
        }

        int[] b = {};

        l11 = l2;
        while (true) {
            b  = Arrays.copyOf(b, b.length + 1);
            b[b.length - 1] = l11.val;

            if (l11.next != null) {
                l11 = l11.next;
            } else {
                break;
            }
        }

        int c = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            c += (int) (a[i] * Math.pow(10, i));
        }

        int d = 0;
        for (int i = b.length - 1; i >= 0; i--) {
            d += (int) (b[i] * Math.pow(10, i));
        }

        int e = c + d;

        String temp = Integer.toString(e);
        int[] ints = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            ints[i] = temp.charAt(i) - '0';
        }

        ListNode listNode = null;
        for (int i = 0; i < ints.length; i++) {
            var newNode = new ListNode(ints[i], listNode);

            listNode = newNode;
        }

        return listNode;
    }

    public static class ListNode {
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
}
