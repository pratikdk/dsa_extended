class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int value) {this.val = value;}
    ListNode(int value, ListNode next) {this.val = value; this.next = next;}
}

public class P21_MergeTwoSortedLinkedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode dNode = new ListNode();
        ListNode dHead = dNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dHead.next = l1;
                l1 = l1.next;
            } else { // l2.val <= l1.val
                dHead.next = l2;
                l2 = l2.next;
            }
            dHead = dHead.next;
        }
        dHead.next = (l1 != null) ? l1 : l2;
        return dNode.next;
    }

    public static ListNode generate(int[] nums) {
        ListNode dNode = new ListNode();
        ListNode dHead = dNode;
        for (int num: nums) {
            dHead.next = new ListNode(num);
            dHead = dHead.next;
        }
        return dNode.next;
    }
    
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{1,2,4}, {1,3,4}},
            {{}, {}},
            {{}, {0}}
        };
        for (int[][] prob: probs) {
            printLinkedList(mergeTwoLists(generate(prob[0]), generate(prob[1])));
        }
    }
}
