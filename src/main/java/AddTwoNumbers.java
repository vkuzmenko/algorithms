import helpers.ListNode;

/**
 * Definition for singly-linked list.
 * public class helpers.ListNode {
 *     int val;
 *     helpers.ListNode next;
 *     helpers.ListNode(int x) { val = x; }
 * }
 */


public class AddTwoNumbers {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (len(l1) < len(l2)) {
            ListNode tmp = l2;
            l2 = l1;
            l1 = tmp;
        }

        ListNode result = l1;

        while (true) {

            l1.val += l2.val;

            if (l1.val > 9) {
                l1.val -= 10;
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                    break;
                }
                l1.next.val += 1;
            }

            if (l2.next == null) {
                if (l1.next != null) {
                    while (l1.next.val > 9) {
                        l1 = l1.next;
                        l1.val -= 10;
                        if (l1.next == null) {
                            l1.next = new ListNode(1);
                            break;
                        }
                        l1.next.val += 1;
                    }
                }
                break;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return result;
    }

    private int len(ListNode node) {
        int i = 0;
        while (node !=  null) {
            i++;
            node = node.next;
        }
        return i;
    }

    private static void printList(ListNode node) {
        System.out.print("(");
        while (node !=  null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.print(")");
    }

    public static void main(String[] args){
        AddTwoNumbers a = new AddTwoNumbers();

        ListNode firstList = new ListNode(2);
        firstList.next = new ListNode(4);
        firstList.next.next = new ListNode(3);

        ListNode secondList = new ListNode(5);
        secondList.next = new ListNode(6);
        secondList.next.next = new ListNode(3);

        printList(a.addTwoNumbers(firstList, secondList)); // 707

        firstList = new ListNode(9);
        firstList.next = new ListNode(8);

        secondList = new ListNode(1);

        printList(a.addTwoNumbers(firstList, secondList)); //09

        firstList = new ListNode(9);
        firstList.next = new ListNode(9);

        secondList = new ListNode(1);

        printList(a.addTwoNumbers(firstList, secondList)); //001

        firstList = new ListNode(8);
        firstList.next = new ListNode(9);
        firstList.next.next = new ListNode(9);

        secondList = new ListNode(2);
        printList(a.addTwoNumbers(firstList, secondList)); //0001
    }
}
